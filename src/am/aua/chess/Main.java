package am.aua.chess;
import am.aua.chess.cli.ChessConsole;
import am.aua.chess.core.Chess;
import am.aua.chess.ui.ChessUI;
import javax.swing.*;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        // This program runs from the following location and the
        // accompanying database.txt file must be place there.
        //System.out.println(System.getProperty("user.dir"));
//        ChessConsole chessConsole = new ChessConsole();
//        chessConsole.run();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (args.length == 0) {
            ChessUI chessUi = new ChessUI();
            chessUi.setVisible(true);
        } else if (args[0].equals("-console")) {
            ChessConsole c = new ChessConsole();
            c.run();
        }

//        ChessUI chessUi = new ChessUI();
//        chessUi.setVisible(true);
    }
}
