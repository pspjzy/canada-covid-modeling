import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataViewComponent } from './dataview/data-view.component';
import {DataViewService} from "./dataview/dataview.service";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    DataViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      { path: '', component: DataViewComponent},
      { path: '', component: DataViewComponent},
      { path: '', component: DataViewComponent},
      { path: '', component: DataViewComponent},
      { path: '', component: DataViewComponent}
    ])
  ],
  providers: [DataViewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
