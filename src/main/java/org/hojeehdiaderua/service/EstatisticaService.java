package org.hojeehdiaderua.service;

import org.hojeehdiaderua.beans.estatisticas.CategoriaSerie;
import org.hojeehdiaderua.beans.estatisticas.CidadeRua;
import org.hojeehdiaderua.beans.estatisticas.Estatisticas;
import org.hojeehdiaderua.beans.estatisticas.NomeEstadoComparator;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class EstatisticaService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    @Autowired
    private MonthConverter monthConverter;

    public Estatisticas estatisticaAnual() {
        return getEstatisticas(logradouroDataRepository.findAll());
    }

    public Estatisticas estatisticaMensal(Integer mes) {
        return getEstatisticas(logradouroDataRepository.findByMes(mes.byteValue()));
    }

    private Estatisticas getEstatisticas(List<LogradouroData> todos) {
        Estatisticas estatisticas = new Estatisticas();

        estatisticas.setQuantidadeDeRuas(todos.size());
        estatisticas.setQuantidadeDeCidades(quantidadeDeCidades(todos.stream()));
        estatisticas.setRuasPorMes(ruasPorMes(todos.stream()));
        estatisticas.setRuasPorUF(ruasPorUF(todos.stream()));
        estatisticas.setRuasPorDia(ruasPorDia(todos.stream()));
        estatisticas.setTopTenCidadeRua(topTenCidadeRua(todos.stream()));

        return estatisticas;
    }

    public List<LogradouroData> all() {
        return logradouroDataRepository
                .findAll()
                .stream()
                .sorted((l1, l2) -> l1.getDia() - l2.getDia())
                .sorted((l1, l2) -> l1.getMes() - l2.getMes())
                .collect(Collectors.toList());
    }

    public List<String> dumpToSQL() {
        return all()
                .stream()
                .map(l -> buildInsert(l))
                .collect(Collectors.toList());
    }

    private String buildInsert(LogradouroData logradouroData) {
        return String.format(Locale.ROOT, "insert into diaderua.logradourodata values (nextval('diaderua.seq_logdata'), %d, %d, '%s', '%s', %.10f, %.10f);\n",
                logradouroData.getDia(),
                logradouroData.getMes(),
                prepararCidade(logradouroData.getCidade()),
                logradouroData.getUf(),
                logradouroData.getLatitude(),
                logradouroData.getLongitude());
    }

    private String prepararCidade(String cidade) {
        return cidade.replaceAll("'", "''");
    }

    private long quantidadeDeCidades(Stream<LogradouroData> logradouroDataStream) {
        return logradouroDataStream.map(l -> l.getCidade()).distinct().count();
    }


    private CategoriaSerie<Byte, Long> ruasPorDia(Stream<LogradouroData> logradouroDataStream) {
        Map<Byte, Long> ruasPorDia =
                logradouroDataStream
                        .map(l -> l.getDia())
                        .collect(
                                Collectors.groupingBy(
                                        d -> d,
                                        Collectors.counting()
                                )
                        );

        List<Byte> dias =
                ruasPorDia
                        .keySet()
                        .stream()
                        .sorted((d1, d2) -> d1 - d2)
                        .collect(Collectors.toList());

        List<Long> ruas = newArrayList();

        dias.forEach(d -> ruas.add(ruasPorDia.getOrDefault(d, 0L)));

        CategoriaSerie<Byte, Long> categoriaSerie = new CategoriaSerie<>();

        categoriaSerie.setCategorias(dias);
        categoriaSerie.setSeries(ruas);

        return categoriaSerie;
    }

    private CategoriaSerie<String, Long> ruasPorMes(Stream<LogradouroData> logradouroDataStream) {
        Map<String, Long> ruasPorMes =
                logradouroDataStream
                        .map(l -> l.getMes())
                        .collect(
                                Collectors.groupingBy(
                                        m -> monthConverter.apply(Month.of(m.intValue())),
                                        Collectors.counting()
                                )
                        );

        List<String> meses =
                ruasPorMes
                        .keySet()
                        .stream()
                        .sorted(new NomeEstadoComparator())
                        .collect(Collectors.toList());

        List<Long> ruas = newArrayList();

        meses.forEach(b -> ruas.add(ruasPorMes.getOrDefault(b, 0L)));

        CategoriaSerie<String, Long> categoriaSerie = new CategoriaSerie<>();

        categoriaSerie.setCategorias(meses);
        categoriaSerie.setSeries(ruas);

        return categoriaSerie;
    }

    private CategoriaSerie<String, Long> ruasPorUF(Stream<LogradouroData> logradouroDataStream) {
        Map<String, Long> ruasPorUF =
                logradouroDataStream
                        .map(l -> l.getUf())
                        .collect(
                                Collectors.groupingBy(
                                        u -> u,
                                        Collectors.counting()
                                )
                        );

        List<String> ufs =
                ruasPorUF
                        .keySet()
                        .stream()
                        .sorted((k1, k2) -> k1.compareTo(k2))
                        .collect(Collectors.toList());

        List<Long> ruas = newArrayList();

        ufs.forEach(u -> ruas.add(ruasPorUF.getOrDefault(u, 0L)));

        CategoriaSerie<String, Long> categoriaSerie = new CategoriaSerie<>();

        categoriaSerie.setCategorias(ufs);
        categoriaSerie.setSeries(ruas);

        return categoriaSerie;
    }

    private List<CidadeRua> topTenCidadeRua(Stream<LogradouroData> logradouroDataStream) {
        String formatoCidade = "%s (%s)";

        Map<String, Long> cidadeRua =
                logradouroDataStream
                        .map(l -> String.format(formatoCidade, l.getCidade(), l.getUf()))
                        .collect(
                                Collectors.groupingBy(
                                        c -> c,
                                        Collectors.counting()
                                )
                        );

        List<CidadeRua> cidadeRuaList =
                cidadeRua
                        .keySet()
                        .stream()
                        .map(c -> new CidadeRua(c, cidadeRua.get(c)))
                        .sorted((c1, c2) -> c1.getCidade().compareTo(c2.getCidade()))
                        .sorted((c1, c2) -> c2.getTotal().intValue() - c1.getTotal().intValue())
                        .limit(10)
                        .collect(Collectors.toList());

        IntStream
                .range(0, 10)
                .forEach(i -> cidadeRuaList.get(i).setPosition(i + 1));

        return cidadeRuaList;
    }
}
