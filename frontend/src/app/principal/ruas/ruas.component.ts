import { Component, OnInit } from '@angular/core';
import { Localidade } from 'src/app/entidades/localidade';
import { Diarua } from 'src/app/entidades/diarua';

@Component({
  selector: 'app-ruas',
  templateUrl: './ruas.component.html',
  styleUrls: ['./ruas.component.css']
})
export class RuasComponent implements OnInit {

  localidades: Localidade[] = [
    { cidade: "Vianópolis", uf: "GO", latitude: 0, longitude: 0 },
    { cidade: "Moiriporá", uf: "GO", latitude: 0, longitude: 0 },
    { cidade: "João Dias", uf: "RN", latitude: 0, longitude: 0 },
    { cidade: "Escada", uf: "PE", latitude: 0, longitude: 0 },
    { cidade: "Goiorê", uf: "PR", latitude: 0, longitude: 0 },
  ];

  diarua: Diarua = { dia: 19, mes: "Agosto", ano: 2019, diaSemana: "Segunda-Feira", localidades: this.localidades};

  constructor() { }

  ngOnInit() {
  }

}
