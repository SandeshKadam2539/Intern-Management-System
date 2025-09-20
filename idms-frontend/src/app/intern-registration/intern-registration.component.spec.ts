import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InternRegistrationComponent } from './intern-registration.component';

describe('InternRegistrationComponent', () => {
  let component: InternRegistrationComponent;
  let fixture: ComponentFixture<InternRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InternRegistrationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InternRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
