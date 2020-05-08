import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataViewComponent } from './dataview/data-view.component';
import {DataViewService} from "./dataview/dataview.service";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";
import { DailyDeathComponent } from './daily-death/daily-death.component';
import { DailyRecoverComponent } from './daily-recover/daily-recover.component';
import { DailyTestComponent } from './daily-test/daily-test.component';
import { DailyCaseComponent } from './daily-case/daily-case.component';
import { DailyCriticalComponent } from './daily-critical/daily-critical.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';

@NgModule({
  declarations: [
    AppComponent,
    DataViewComponent,
    DailyDeathComponent,
    DailyRecoverComponent,
    DailyTestComponent,
    DailyCaseComponent,
    DailyCriticalComponent,
    MainNavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      { path: '', component: DataViewComponent},
      { path: 'case', component: DailyCaseComponent},
      { path: 'critical', component: DailyCriticalComponent},
      { path: 'death', component: DailyDeathComponent},
      { path: 'recover', component: DailyRecoverComponent},
      { path: 'test', component: DailyTestComponent}
    ]),
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule
  ],
  providers: [DataViewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
