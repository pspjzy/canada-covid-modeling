import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {Router, RouterOutlet} from "@angular/router";
import {slideInAnimation} from "./slideInAnimation";

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css'],
  animations: [slideInAnimation]
})
export class MainNavComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  navLinks: any[];
  activeLinkIndex = -1;
  constructor(private breakpointObserver: BreakpointObserver,private router: Router) {
    this.navLinks = [
      {
        label: 'Case',
        link: './case',
        index: 0
      }, {
        label: 'Critical',
        link: './critical',
        index: 1
      }, {
        label: 'Death',
        link: './death',
        index: 2
      }, {
        label: 'Recover',
        link: './recover',
        index: 3
      }, {
        label: 'Tested',
        link: './test',
        index: 4
      },
    ]
  }

  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
    });
  }


  prepareRoute(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData['animation'];
  }





}
