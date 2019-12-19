import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { POSICOES } from "../posicoes";
import { Peca } from "../peca";

@Component({
  selector: "app-jogo-tabuleiro",
  templateUrl: "./jogo-tabuleiro.component.html",
  styleUrls: ["./jogo-tabuleiro.component.css"]
})
export class JogoTabuleiroComponent implements OnInit {
  pos = POSICOES;
  manda: Peca;
  jog: number = 0;

  constructor() {}

  ngOnInit() {}

  onClick(event: number) {
    console.log(this.pos[event]);
    this.manda = this.pos[event];
    if(this.jog ==0){
      this.jog++;
    }else{
      this.jog--;
    }
    console.log(this.pos[event]);
  }
}
