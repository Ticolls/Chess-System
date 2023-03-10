package app;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChesssPosition(sc);

            System.out.println();
            System.out.print("Targe: ");
            ChessPosition target = UI.readChesssPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }

    }
}