import { Component, OnInit, Input } from '@angular/core';
import { Localidade } from 'src/app/entidades/localidade';

@Component({
  selector: 'app-placa',
  templateUrl: './placa.component.html',
  styleUrls: ['./placa.component.css']
})
export class PlacaComponent implements OnInit {
  @Input() localidade: Localidade;

  constructor() { }

  ngOnInit() {
  }

}
