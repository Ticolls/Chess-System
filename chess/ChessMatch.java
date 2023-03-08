package chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        // Inicializando o tabuleiro 8:8
        board = new Board(8, 8);
    }

    // Retornando as peças abstratas(Piece) em peças de xadrez(ChessPiece)
    public ChessPiece[][] getPieces() {
        ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matriz[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return matriz;
    }

}
