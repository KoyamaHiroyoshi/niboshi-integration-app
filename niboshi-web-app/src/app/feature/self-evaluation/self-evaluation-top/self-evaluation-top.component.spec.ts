import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfEvaluationTopComponent } from './self-evaluation-top.component';

describe('SelfEvaluation01Component', () => {
  let component: SelfEvaluationTopComponent;
  let fixture: ComponentFixture<SelfEvaluationTopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelfEvaluationTopComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelfEvaluationTopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
