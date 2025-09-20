import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Existing components
import { InternFormComponent } from './components/intern-form/intern-form.component';
import { InternListComponent } from './components/intern-list/intern-list.component';
import { BatchFormComponent } from './components/batch-form/batch-form.component';
import { BatchListComponent } from './components/batch-list/batch-list.component';

// ✅ New page components
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { InternsComponent } from './pages/interns/interns.component';
import { BatchesComponent } from './pages/batches/batches.component';

@NgModule({
  declarations: [
    AppComponent,
    InternFormComponent,
    InternListComponent,
    BatchFormComponent,
    BatchListComponent,
    DashboardComponent,
    InternsComponent,
    BatchesComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,

    // Angular Material modules
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
