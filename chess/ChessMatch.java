package chess;

import boardgame.Board;
import boardgame.Piece;
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

    // Faz o movimento na camada do Chess
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

        // Transformando as posições no formato do xadrez em posições da camada board
        Position source = sourcePosition.toBoardPosition();
        Position target = targetPosition.toBoardPosition();

        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);

        return (ChessPiece) capturedPiece;
    }

    // Faz o movimento na camada do board
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        return capturedPiece;
    }

    private void validateSourcePosition(Position source) {
        if (!board.thereIsAPiece(source)) {
            throw new ChessException("There is no piece on source position");
        }
        if (!board.getPiece(source).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    // Coloca uma peça na camada Board passando as coordenadas no formato do xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        Position boardPosition = new ChessPosition(column, row).toBoardPosition();
        board.placePiece(piece, boardPosition);
    }

    private void inicialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

}
