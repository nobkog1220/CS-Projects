//Do not change this class! This class shouldn't be submitted.
public class Cell {
    //row the cell is in the grid
    public int row;
    //column the cell is in the grid
    public int col;
    //walls
    public boolean top_wall;
    public boolean right_wall;
    public boolean left_wall;
    public boolean bottom_wall;
    public boolean visited;   // used for generation and BFS
    public Cell parent;        // used for BFS path reconstruction
    public boolean inPath;    // true if the cell is on the BFS path

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
		visited = false;
        parent = null;
        inPath = false;
        //All walls start with value true
        top_wall = true;
        bottom_wall = true;
        left_wall = true;
        right_wall = true;
    }
}