import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerCompanyDetailsComponent } from './manager-company-details.component';

describe('ManagerCompanyDetailsComponent', () => {
  let component: ManagerCompanyDetailsComponent;
  let fixture: ComponentFixture<ManagerCompanyDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerCompanyDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerCompanyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
