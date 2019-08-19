import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RuasComponent } from './ruas.component';

describe('RuasComponent', () => {
  let component: RuasComponent;
  let fixture: ComponentFixture<RuasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RuasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RuasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
