import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoPlacarComponent } from './jogo-placar.component';

describe('JogoPlacarComponent', () => {
  let component: JogoPlacarComponent;
  let fixture: ComponentFixture<JogoPlacarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JogoPlacarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoPlacarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
