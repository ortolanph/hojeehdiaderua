import { Component, OnInit, Input } from '@angular/core';
import { Diarua } from 'src/app/entidades/diarua';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})
export class CalendarioComponent implements OnInit {
  @Input() diarua: Diarua;

  constructor() { }

  ngOnInit() {
  }

}
