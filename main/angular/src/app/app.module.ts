import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppRoutingModule } from './app-routing.module';

import {DashboardService} from './dashboard/dashboard.service';

import {AppComponent} from './app.component';
import {DashboardComponent} from './dashboard/dashboard.component';



@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule
    ],
    providers: [
        DashboardService
    ],
    declarations: [
        AppComponent,
        DashboardComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
