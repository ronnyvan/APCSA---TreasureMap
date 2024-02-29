public class TreasureHunt
{
    public static void main(String[] args)
    {
        option1(); // the default treasure map for testing
//        option2(); // random treasure map
    }

    public static void option1()
    {
        TreasureMap map = new TreasureMap();

        System.out.println("Default Map:");
        map.displayMap();

        System.out.println("\nMap size:");
        System.out.println("rows: " + map.numRows() + " cols: " + map.numCols());

        System.out.println("\nhasTreasure:");
        System.out.println(" @ (2, 0): " + map.hasTreasure(2,0));
        System.out.println(" @ (0, -1): " + map.hasTreasure(0, -1));
        System.out.println(" @ (2, 3): " + map.hasTreasure(2, 3));
        System.out.println(" @ (2, 2): " + map.hasTreasure(2, 2));
        System.out.println(" @ (4, 9): " + map.hasTreasure(4, 9));

        System.out.println("\nnumAdjacent:");
        System.out.println(" @ (3, 3): " + map.numAdjacent(3, 3));
        System.out.println(" @ (2, 4): " + map.numAdjacent(2, 4));
        System.out.println(" @ (4, 9): " + map.numAdjacent(4, 9));

        System.out.println("\ncomputeCounts:");
        displayMatrix(map.computeCounts());
    }

    public static void displayMatrix(int[][] mat)
    {
        for(int row = 0; row < mat.length; row++)
        {
            for(int col = 0; col < mat[0].length; col++)
                System.out.print(mat[row][col] + "\t");
            System.out.println();

        }
    }

    public static void option2()
    {
        //complete option 2 to similar to option 1 to show random
        int rows = (int) (Math.random()*7) + 3;
        int cols = (int) (Math.random()*7) + 3;
        TreasureMap map = new TreasureMap(rows, cols);

        System.out.println("Default Map:");
        map.displayMap();

        System.out.println("\nMap size:");
        System.out.println(" rows: " + map.numRows() + " cols: " + map.numCols());

        System.out.println("\nhasTreasure:");
        System.out.println(" @ (0, 2): " + map.hasTreasure(0,2));
        System.out.println(" @ (0, -1): " + map.hasTreasure(0, -1));
        System.out.println(" @ (2, 3): " + map.hasTreasure(2, 3));
        System.out.println(" @ (2, 2): " + map.hasTreasure(2, 2));
        System.out.println(" @ (4, 9): " + map.hasTreasure(4, 9));

        System.out.println("\nnumAdjacent:");
        System.out.println(" @ (3, 3): " + map.numAdjacent(3, 3));
        System.out.println(" @ (2, 4): " + map.numAdjacent(2, 4));
        System.out.println(" @ (4, 9): " + map.numAdjacent(4, 9));

        System.out.println("\ncomputeCounts:");
        displayMatrix(map.computeCounts());
    }

}
