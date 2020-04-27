import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {DataViewComponent} from './dataview.component'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    DataViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
