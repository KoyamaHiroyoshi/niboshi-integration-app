import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfEvaluation01Component } from './self-evaluation-01.component';

describe('SelfEvaluation01Component', () => {
  let component: SelfEvaluation01Component;
  let fixture: ComponentFixture<SelfEvaluation01Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelfEvaluation01Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelfEvaluation01Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
