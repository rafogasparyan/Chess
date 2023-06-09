package am.aua.chess.ui;
import am.aua.chess.core.Chess;
import am.aua.chess.core.Position;
import am.aua.chess.core.Move;
import am.aua.chess.core.Piece;
import am.aua.chess.core.IllegalArrangementException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChessUI extends JFrame {
    private Chess game;
    private BoardSquare[][] board;
    private Position origin;

    public ChessUI() {
        super("Chess game");
        try {
            game = new Chess();
            board = new BoardSquare[Chess.BOARD_RANKS][Chess.BOARD_FILES];
        } catch(IllegalArrangementException e) {
            e.printStackTrace();
        }

        this.setSize(new Dimension(630,660));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(560,560));

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new BoardSquare((i + j) % 2 == 0, i, j);
                board[i][j].setPreferredSize(new Dimension(70,70));
                int x = i;
                int y = j;
                board[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boardClicked(board[x][y].getCords());
                    }
                });
                panel.add(board[i][j]);
            }
        }
        updatePieces();
        this.setContentPane(panel);
    }
    private void boardClicked(int[] coordinates) {
        if (origin == null) {
            System.out.println(coordinates[0] + " " + coordinates[1]);
            origin = new Position(coordinates[0], coordinates[1]);
            if(game.getBoard()[origin.getRank()][origin.getFile()] != null) {
                ArrayList<Position> available = game.reachableFrom(origin);
                if (available != null) {
                    for (int i = 0; i < available.toArray().length; i++) {
                        board[available.get(i).getRank()][available.get(i).getFile()].setHighlight(true);
                    }
                }
            }
        } else {
            System.out.println(coordinates[0] + " " + coordinates[1]);
            Position destination = new Position(coordinates[0], coordinates[1]);
            if (game.reachableFrom(origin) != null && game.reachableFrom(origin).contains(destination)) {
                game.performMove(new Move(origin, destination));

            }

            for (BoardSquare[] row : board) {
                for (BoardSquare b : row) {
                    b.setHighlight(false);
                }
            }
            origin = null;
        }
        updatePieces();
    }

    private void updatePieces() {
        Piece[][] m = game.getBoard();
        for(int i = 0;i<m.length;i++) {
            for(int j = 0;j<m[i].length;j++) {
                if (m[i][j] != null) {
                    board[i][j].setPiece(m[i][j].toString());
                } else {
                    board[i][j].setPiece();
                }
            }
        }
    }
}

