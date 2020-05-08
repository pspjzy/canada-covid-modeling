import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyDeathComponent } from './daily-death.component';

describe('DailyDeathComponent', () => {
  let component: DailyDeathComponent;
  let fixture: ComponentFixture<DailyDeathComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyDeathComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyDeathComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
