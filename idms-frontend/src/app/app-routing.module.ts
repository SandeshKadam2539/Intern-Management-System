import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InternFormComponent } from './components/intern-form/intern-form.component';
import { InternListComponent } from './components/intern-list/intern-list.component';
import { BatchFormComponent } from './components/batch-form/batch-form.component';
import { BatchListComponent } from './components/batch-list/batch-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/intern-form', pathMatch: 'full' }, // Default page
  { path: 'intern-form', component: InternFormComponent },
  { path: 'intern-list', component: InternListComponent },
  { path: 'batch-form', component: BatchFormComponent },
  { path: 'batch-list', component: BatchListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
