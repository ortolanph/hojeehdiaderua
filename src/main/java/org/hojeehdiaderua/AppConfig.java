package org.hojeehdiaderua;

import com.google.maps.GeoApiContext;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@EnableWebMvc
@Configuration
@PropertySource("classpath:hojeehdiaderua.properties")
@ComponentScan(basePackages = {"org.hojeehdiaderua.controller", "org.hojeehdiaderua.service"})
@EnableJpaRepositories("org.hojeehdiaderua.repositories")
@Import({SecurityConfig.class})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    /**
     * Registra um controlador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * Registra uma manipulador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("resources/");
    }

    /**
     * Mapeia todas as p&aacute;ginas JSP.
     *
     * @return o resolver da camada vis&atilde;o
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();

        b.setDataSource(dataSource());
        b.setPersistenceUnitName(environment.getProperty("entitymanager.unitname"));
        b.setPersistenceXmlLocation(environment.getProperty("entitymanager.xmllocation"));
        b.setPackagesToScan(environment.getProperty("entitymanager.packagestoscan"));
        b.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        b.setJpaDialect(new org.springframework.orm.jpa.vendor.HibernateJpaDialect());

        Properties props = new Properties();

        props.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        props.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.query.substitutions", environment.getProperty("hibernate.query.substitutions"));

        b.setJpaProperties(props);
        return b;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        URI dbUri = null;
        try {
            String uri = System.getenv("DATABASE_URL");
            dbUri = new URI(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setMaxActive(10);
        dataSource.setMinIdle(10);
        return dataSource;
    }
}
