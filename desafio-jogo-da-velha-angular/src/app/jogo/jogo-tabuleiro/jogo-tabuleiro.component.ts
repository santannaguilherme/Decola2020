import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";

@Component({
  selector: "app-jogo-tabuleiro",
  templateUrl: "./jogo-tabuleiro.component.html",
  styleUrls: ["./jogo-tabuleiro.component.css"]
})
export class JogoTabuleiroComponent implements OnInit {
  quad: any[];
  xProximo: boolean;
  vencedor: string;
  placarX: number = 0;
  placarO: number = 0;
  jogador:string;

  constructor() {}

  ngOnInit() {
    this.quad = Array(9).fill(null);
    this.xProximo = true;
    this.vencedor = null;
    this.jogador = "X";
  }


  jogada(index: number) {
    this.jogador = this.xProximo ? "X" : "O";
    if (!this.quad[index]) {
      this.quad.splice(index, 1, this.jogador);
      this.xProximo = !this.xProximo;
    }

    this.vencedor = this.verificaVencedor();
    if (this.vencedor != null) {
      alert("Jogado " + this.vencedor + " ganhou");
      if(this.vencedor == "X"){
        this.placarX++;
      }else{
        this.placarO++;
      }
      this.ngOnInit();
    }
  }

  verificaVencedor() {
    const matrizVitoria = [
      [0, 1, 2],
      [0, 3, 6],
      [0, 4, 8],
      [1, 4, 7],
      [2, 4, 6],
      [2, 5, 8],
      [3, 4, 5],
      [6, 7, 8]
    ];

    for (let i = 0; i < matrizVitoria.length; i++) {
      const [a, b, c] = matrizVitoria[i];
      if (
        this.quad[a] &&
        this.quad[a] === this.quad[b] &&
        this.quad[a] === this.quad[c]
      ) {
        return this.quad[a];
      }
    }
    return null;
  }
}
