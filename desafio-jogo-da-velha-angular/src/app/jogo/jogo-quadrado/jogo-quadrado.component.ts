import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { Peca } from "../peca";

@Component({
  selector: "app-jogo-quadrado",
  templateUrl: "./jogo-quadrado.component.html",
  styleUrls: ["./jogo-quadrado.component.css"]
})
export class JogoQuadradoComponent implements OnInit {
  @Input() campo: Peca;
  @Input() jogador: number;
  @Output() newItemEvent = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  onClick() {
    if (this.campo.dado === "") {
      if (this.jogador == 0) {
        this.campo.dado = "X";
        this.jogador++;
      } else {
        this.campo.dado = "O";
        this.jogador--;
      }
    }

    console.log(this.jogador);
  }
}
