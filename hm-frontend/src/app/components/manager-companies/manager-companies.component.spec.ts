import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerCompaniesComponent } from './manager-companies.component';

describe('ManagerCompaniesComponent', () => {
  let component: ManagerCompaniesComponent;
  let fixture: ComponentFixture<ManagerCompaniesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerCompaniesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerCompaniesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
