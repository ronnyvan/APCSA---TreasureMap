public class TreasureMap {
    private boolean[][] map;
    private int rows, cols;

    public int numRows() {
        return rows;
    }

    public int numCols() {
        return cols;
    }

    public TreasureMap() {
        initializeMap();
    }

    private void initializeMap() {
        map = new boolean[6][9];
        rows = 6;
        cols = 9;
        map[0][0] = false;
        map[0][1] = true;
        map[0][2] = true;
        map[0][3] = false;
        map[0][4] = true;
        map[0][5] = false;
        map[0][6] = true;
        map[0][7] = false;
        map[0][8] = false;

        map[1][0] = false;
        map[1][1] = true;
        map[1][2] = false;
        map[1][3] = false;
        map[1][4] = false;
        map[1][5] = false;
        map[1][6] = true;
        map[1][7] = false;
        map[1][8] = false;

        map[2][0] = false;
        map[2][1] = true;
        map[2][2] = false;
        map[2][3] = true;
        map[2][4] = true;
        map[2][5] = false;
        map[2][6] = false;
        map[2][7] = true;
        map[2][8] = true;

        map[3][0] = true;
        map[3][1] = false;
        map[3][2] = true;
        map[3][3] = false;
        map[3][4] = true;
        map[3][5] = true;
        map[3][6] = false;
        map[3][7] = false;
        map[3][8] = false;

        map[4][0] = false;
        map[4][1] = true;
        map[4][2] = false;
        map[4][3] = false;
        map[4][4] = true;
        map[4][5] = false;
        map[4][6] = false;
        map[4][7] = true;
        map[4][8] = false;

        map[5][0] = true;
        map[5][1] = false;
        map[5][2] = false;
        map[5][3] = true;
        map[5][4] = false;
        map[5][5] = true;
        map[5][6] = false;
        map[5][7] = false;
        map[5][8] = false;
    }

    public TreasureMap(int rows, int cols) {
        map = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                map[r][c] = (int) (Math.random() * 100) < 21;
            }
        }
    }

    public boolean hasTreasure(int row, int col) {
        return !outOfBounds(row, col) && map[row][col];
    }

    public int numAdjacent(int row, int col) {
        return verticalCheck(row, col) + horizontalCheck(row, col) + diagonalCheck(row, col);
    }

    private int diagonalCheck(int row, int col) {
        return verticalCheck(row, col - 1) + verticalCheck(row, col + 1);
    }

    private int horizontalCheck(int row, int col) {
        return (!outOfBounds(row, col - 1) && map[row][col - 1] ? 1 : 0)
                + (!outOfBounds(row, col + 1) && map[row][col + 1] ? 1 : 0);
    }

    private int verticalCheck(int row, int col) {
        return (!outOfBounds(row - 1, col) && map[row - 1][col] ? 1 : 0)
                + (!outOfBounds(row + 1, col + 1) && map[row + 1][col + 1] ? 1 : 0);
    }

    private boolean outOfBounds(int row, int col) {
        return (row < 0 || row >= map.length) || (col >= map[0].length || col < 0);
    }

    public int[][] computeCounts() {
        int[][] result = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = (map[r][c]) ? 9 : numAdjacent(r, c);
            }
        }
        return result;
    }

    public void displayMap() {
        if (map == null) System.out.println("empty");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print((map[r][c] ? "X" : "_") + " ");
            }
            System.out.println();
        }
    }
}
