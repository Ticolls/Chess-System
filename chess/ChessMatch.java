package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        // Inicializando o tabuleiro 8:8
        board = new Board(8, 8);

        inicialSetup();
    }

    // Retornando as peças abstratas(Piece) em peças de xadrez(ChessPiece)
    public ChessPiece[][] getPieces() {
        ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matriz[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }
        return matriz;
    }

    private void inicialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));

    }

}
