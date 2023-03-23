package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        Board board = getBoard();
        boolean[][] mat = new boolean[board.getRows()][board.getColumns()];

        Position p = new Position(0, 0);

        // Movimentos dos peões brancos
        if (getColor() == Color.WHITE) {

            // Movimentos normais
            p.setValues(position.getRow() - 1, position.getColumn());
            // Verificando se pode mover para a posição da frente
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

                Position p2 = new Position(position.getRow() - 2, position.getColumn());
                // Verificando se pode mover duas posições para frente
                if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                    mat[p2.getRow()][p2.getColumn()] = true;
                }

            }

            // Movimentos de captura
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

        }
        // Movimento dos peões pretos
        else {
            // Movimentos normais
            p.setValues(position.getRow() + 1, position.getColumn());
            // Verificando se pode mover para a posição da frente
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

                Position p2 = new Position(position.getRow() + 2, position.getColumn());
                // Verificando se pode mover duas posições para frente
                if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                    mat[p2.getRow()][p2.getColumn()] = true;
                }

            }

            // Movimentos de captura
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
