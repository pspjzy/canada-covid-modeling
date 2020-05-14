import {animate, animateChild, group, query, style, transition, trigger} from "@angular/animations";

export const slideInAnimation =  trigger('routeAnimations', [
  transition('test => *,recover=>death,recover=>critical,recover=>case,death=>critical,death=>case,critical=>case', [
    style({ position: 'relative' }),
    query(':enter, :leave', [
      style({
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%'
      })
    ]),
    query(':enter', [
      style({ left: '-100%',opacity: 0})
    ]),
    query(':leave', animateChild()),
    group([
      query(':leave', [
        animate('800ms ease-out', style({ left: '100%',opacity: 0}))
      ]),
      query(':enter', [
        animate('800ms ease-out', style({ left: '0%',opacity: 1}))
      ])
    ]),
    query(':enter', animateChild()),
  ]),
  transition('case => *,critical=>death,critical=>recover,critical=>test,death=>recover,death=>test,recover=>test', [
    style({ position: 'relative' }),
    query(':enter, :leave', [
      style({
        position: 'absolute',
        top: 0,
        right: 0,
        width: '100%'
      })
    ]),
    query(':enter', [
      style({ right: '-100%',opacity: 0})
    ]),
    query(':leave', animateChild()),
    group([
      query(':leave', [
        animate('800ms ease-out', style({ right: '100%',opacity: 0}))
      ]),
      query(':enter', [
        animate('800ms ease-out', style({ right: '0%',opacity: 1}))
      ])
    ]),
    query(':enter', animateChild()),
  ])
]);
