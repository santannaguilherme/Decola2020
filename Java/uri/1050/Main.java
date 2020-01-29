import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		String linha = in.nextLine();
		String palavras[] = linha.split(" ");
		String valor[] = palavras[2].split(",");
		String dinheiro = palavras[2];
		double total = Integer.parseInt(palavras[1]) * Double.parseDouble(dinheiro);
		linha = in.nextLine();
		String palavrass[] = linha.split(" ");
		String valors[] = palavrass[2].split(",");
		dinheiro = palavrass[2];
		total = (Integer.parseInt(palavrass[1]) * Double.parseDouble(dinheiro))+total;
		System.out.printf("VALOR A PAGAR: %.2f\n", total);
		
	}
	
}
