import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppLayoutFooterComponent } from './app-layout-footer.component';

describe('AppLayoutFooterComponent', () => {
  let component: AppLayoutFooterComponent;
  let fixture: ComponentFixture<AppLayoutFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppLayoutFooterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppLayoutFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
