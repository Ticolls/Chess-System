package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        // Apenas repassando para a superClasse
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

}
