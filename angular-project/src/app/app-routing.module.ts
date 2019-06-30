import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {TransaccionComponent} from './transaccion/transaccion.component';

const routes: Routes = [
  {path: '', redirectTo: '/transaccion/:codUsuario', pathMatch: 'full'},
  // {path: 'transaccion', component: TransaccionComponent},
  {path: 'transaccion/:codUsuario', component: TransaccionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
