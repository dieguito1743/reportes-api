import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TransaccionComponent } from './transaccion/transaccion.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';

import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatSelectModule, MatToolbarModule, MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';

import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';

@NgModule( {
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        MatTableModule,
        MatSortModule,
        MatPaginatorModule,
        MatIconModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatToolbarModule,
        CdkTableModule,
        MatDatepickerModule,
        MatNativeDateModule,
        NgxMatSelectSearchModule
    ],
    exports: [],
    declarations: [
        AppComponent,
        TransaccionComponent
    ],
    bootstrap: [
        AppComponent
    ]
} )

export class AppModule {
}
