import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RuasComponent } from './principal/ruas/ruas.component';
import { EstatisticasComponent } from './principal/estatisticas/estatisticas.component';


const routes: Routes = [
  { path: '', component: RuasComponent },
  { path: 'estatisticas', component: EstatisticasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
