package am.aua.chess.ui;

import javax.swing.*;
import java.awt.*;

public class BoardSquare extends JButton {
    private static final Color dark = new Color(0, 60, 0);
    public static final Color light = new Color(255, 255, 255);

    private Color color;
    private int xCord;
    private int yCord;

    public BoardSquare(boolean isWhite, int x, int y) {
        if (isWhite) {
            this.color = light;
        } else {
            this.color = dark;
        }
        this.setBackground(this.color);
        this.xCord = x;
        this.yCord = y;
    }

    public int[] getCords() {
        return new int[] {this.xCord, this.yCord};
    }

    public void setPiece(String letter) {
        switch (letter) {
            case "K":
            case "L":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/KingW.png"));
                break;
            case "R":
            case "S":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/RookW.png"));
                break;
            case "k":
            case "l":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/KingB.png"));
                break;
            case "r":
            case "s":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/RookB.png"));
                break;
            case "Q":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/QueenW.png"));
                break;
            case "q":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/QueenB.png"));
                break;
            case "B":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/BishopW.png"));
                break;
            case "b":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/BishopB.png"));
                break;
            case "N":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/KnightW.png"));
                break;
            case "n":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/KnightB.png"));
                break;
            case "P":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/PawnW.png"));
                break;
            case "p":
                this.setIcon(new ImageIcon("src/am/aua/chess/gfx/PawnB.png"));
                break;
        }
    }

    public void setPiece() {
        this.setIcon(null);
    }

    public void setHighlight(boolean isHighlighted) {
        if(isHighlighted) {
            this.setBackground(Color.red);
        }
        else {
            this.setBackground(color);
        }
    }

}
