import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortTableGoalsComponent } from './sort-table-goals.component';

describe('SortTableGoalsComponent', () => {
  let component: SortTableGoalsComponent;
  let fixture: ComponentFixture<SortTableGoalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortTableGoalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortTableGoalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
