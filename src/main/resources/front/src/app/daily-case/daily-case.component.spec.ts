import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyCaseComponent } from './daily-case.component';

describe('DailyCaseComponent', () => {
  let component: DailyCaseComponent;
  let fixture: ComponentFixture<DailyCaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyCaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
