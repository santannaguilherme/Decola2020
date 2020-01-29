import { Injectable } from "@angular/core";

@Injectable({ providedIn: "root" })
export class JogoService {
  placarX: number = 0;
  placarO: number = 0;
  quad: any[] = Array(9).fill(null);
  xProximo: boolean = true;
  vencedor: string;
  jogador: string = "X";
  teste: number = 0;

  jogada(index: number) {
    this.jogador = this.xProximo ? "X" : "O";
    if (!this.quad[index]) {
      this.quad.splice(index, 1, this.jogador);
      this.xProximo = !this.xProximo;
    }

    this.vencedor = this.verificaVencedor();
    if (this.vencedor != null) {
      if (this.vencedor == "X") {
        this.placarX++;
        alert("Jogado " + this.vencedor + " ganhou");
      } else if (this.vencedor == "O") {
        this.placarO++;
        alert("Jogado " + this.vencedor + " ganhou");
      } else {
        alert(this.vencedor);
      }
      this.restartBoard();
    }
  }

  verificaVencedor() {
    this.teste++;
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
      } else {
      }
    }
    console.log(this.teste);
    if (this.teste >= 9) {
      return "Empate";
    }
    return null;
  }

  restartGame() {
    this.placarO = 0;
    this.placarX = 0;
    this.restartBoard();
  }

  restartBoard() {
    this.quad.fill(null);
    this.xProximo = true;
    this.vencedor = null;
    this.jogador = "X";
    this.teste = 0;
    console.log("clicou");
  }
}
