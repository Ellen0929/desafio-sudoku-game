package sudoku;

import java.util.Scanner;

public class JogoSudoku {
    public static void main(String[] args) {
        Sudoku jogo = new Sudoku();
        jogo.gerarTabuleiro();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vinda(o) ao Sudoku!");
        while (!jogo.verificarVitoria()) {
            jogo.mostrarTabuleiro();

            System.out.print("Digite a linha (0-8): ");
            int linha = sc.nextInt();

            System.out.print("Digite a coluna (0-8): ");
            int coluna = sc.nextInt();

            System.out.print("Digite o valor (1-9): ");
            int valor = sc.nextInt();

            if (jogo.validarJogada(linha, coluna, valor)) {
                jogo.colocarValor(linha, coluna, valor);
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        System.out.println("Parabéns! Você completou o Sudoku!");
        jogo.mostrarTabuleiro();
        sc.close();
    }
}
