import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfEvaluation02Component } from './self-evaluation-02.component';

describe('SelfEvaluation02Component', () => {
  let component: SelfEvaluation02Component;
  let fixture: ComponentFixture<SelfEvaluation02Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelfEvaluation02Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelfEvaluation02Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
