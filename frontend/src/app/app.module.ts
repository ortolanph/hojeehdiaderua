import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RuasComponent } from './principal/ruas/ruas.component';
import { EstatisticasComponent } from './principal/estatisticas/estatisticas.component';
import { PlacaComponent } from './principal/placa/placa.component';
import { CalendarioComponent } from './principal/calendario/calendario.component';

@NgModule({
  declarations: [
    AppComponent,
    RuasComponent,
    EstatisticasComponent,
    PlacaComponent,
    CalendarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
