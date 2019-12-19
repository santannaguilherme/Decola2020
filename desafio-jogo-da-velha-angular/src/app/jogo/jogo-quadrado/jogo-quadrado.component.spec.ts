import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoQuadradoComponent } from './jogo-quadrado.component';

describe('JogoQuadradoComponent', () => {
  let component: JogoQuadradoComponent;
  let fixture: ComponentFixture<JogoQuadradoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JogoQuadradoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoQuadradoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
