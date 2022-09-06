import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VegetablepageComponent } from './vegetablepage.component';

describe('VegetablepageComponent', () => {
  let component: VegetablepageComponent;
  let fixture: ComponentFixture<VegetablepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VegetablepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VegetablepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
