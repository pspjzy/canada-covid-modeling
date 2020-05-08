import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyCriticalComponent } from './daily-critical.component';

describe('DailyCriticalComponent', () => {
  let component: DailyCriticalComponent;
  let fixture: ComponentFixture<DailyCriticalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyCriticalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyCriticalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
