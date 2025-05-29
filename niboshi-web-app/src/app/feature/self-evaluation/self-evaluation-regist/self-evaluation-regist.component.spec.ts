import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfEvaluationrRegistComponent } from './self-evaluation-regist.component';

describe('SelfEvaluation02Component', () => {
  let component: SelfEvaluationrRegistComponent;
  let fixture: ComponentFixture<SelfEvaluationrRegistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelfEvaluationrRegistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelfEvaluationrRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
