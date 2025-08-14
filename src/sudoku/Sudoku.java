package sudoku;

public class Sudoku {

    private int[][] tabuleiro = new int[9][9];
    private boolean[][] fixos = new boolean[9][9];

    public void gerarTabuleiro() {

        int[][] inicial = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabuleiro[i][j] = inicial[i][j];
                if (inicial[i][j] != 0) {
                    fixos[i][j] = true;
                }
            }
        }
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(tabuleiro[i][j] == 0 ? ". " : tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean validarJogada(int linha, int coluna, int valor) {
        if (valor < 1 || valor > 9) return false;
        if (fixos[linha][coluna]) return false;

        for (int i = 0; i < 9; i++) {
            if (tabuleiro[linha][i] == valor || tabuleiro[i][coluna] == valor) return false;
        }

        int startLinha = (linha / 3) * 3;
        int startColuna = (coluna / 3) * 3;
        for (int i = startLinha; i < startLinha + 3; i++) {
            for (int j = startColuna; j < startColuna + 3; j++) {
                if (tabuleiro[i][j] == valor) return false;
            }
        }

        return true;
    }

    public void colocarValor(int linha, int coluna, int valor) {
        tabuleiro[linha][coluna] = valor;
    }

    public boolean verificarVitoria() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tabuleiro[i][j] == 0) return false;
            }
        }
        return true;
    }
}

