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

    // Coloca uma peça na camada Board passando as coordenadas no formato do xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        Position boardPosition = new ChessPosition(column, row).toBoardPosition();
        board.placePiece(piece, boardPosition);
    }

    private void inicialSetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

    }

}
