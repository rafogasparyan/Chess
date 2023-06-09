package am.aua.chess.core;
import java.util.ArrayList;
public class Queen extends Piece {
    public Queen() {
        super();
    }

    public Queen(Chess.PieceColor color) {
        super(color);
    }

    public String toString() {
        if (this.getPieceColor() == Chess.PieceColor.WHITE)
            return "Q";
        else
            return "q";
    }

    public ArrayList<Position> allDestinations(Chess chess, Position p) {

        ArrayList<Position> result = Rook.reachablePositions(chess, p);
        ArrayList<Position> myarrlist = Bishop.reachablePositions(chess, p); // getting positions list
        Position[] pos = new Position[myarrlist.size()]; // creating same size array
        pos = myarrlist.toArray(pos);// put list items to array


        result = Position.appendPositionsToArray(result, pos);
        return result;
    }
}
