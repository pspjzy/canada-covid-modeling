import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyRecoverComponent } from './daily-recover.component';

describe('DailyRecoverComponent', () => {
  let component: DailyRecoverComponent;
  let fixture: ComponentFixture<DailyRecoverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyRecoverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyRecoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
