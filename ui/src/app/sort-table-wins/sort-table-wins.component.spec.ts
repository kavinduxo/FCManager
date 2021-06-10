import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortTableWinsComponent } from './sort-table-wins.component';

describe('SortTableWinsComponent', () => {
  let component: SortTableWinsComponent;
  let fixture: ComponentFixture<SortTableWinsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortTableWinsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortTableWinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
