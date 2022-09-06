import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmimpageComponent } from './admimpage.component';

describe('AdmimpageComponent', () => {
  let component: AdmimpageComponent;
  let fixture: ComponentFixture<AdmimpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdmimpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmimpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
