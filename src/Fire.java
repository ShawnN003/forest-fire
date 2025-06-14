import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        boolean[][] visited = new boolean[forest.length][forest[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int burnTime = 0;
        int[] myNum = {matchR,matchC,burnTime};

        queue.add(myNum);

        while(!queue.isEmpty())
        {
            int[] treeBurn = queue.poll();
            int curR = treeBurn[0];
            int curC = treeBurn[1];
            int time = treeBurn[2];

            if (visited[curR][curC]) continue;

            visited[curR][curC] = true;

            burnTime = time;

            List<int[]> neighborTrees = possibleBurns(forest, curR, curC);

            time++;

            if (neighborTrees != null) {
                for (int[] neighbor : neighborTrees) {
                    int neighR = neighbor[0];
                    int neighC = neighbor[1];
                    if (!visited[neighR][neighC]) queue.add(new int[]{neighR, neighC, time});
                }
            }
        }
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        return burnTime;
    }

    public static List<int[]> possibleBurns(char[][] forest, int matchR, int matchC)
    {
        List<int[]> possibleList = new ArrayList<>();

        int[][] possibleBurn = 
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        int newRow = 0;
        int newCol = 0;

        for(int[] possible : possibleBurn)
        {
            newRow = matchR + possible[0];
            newCol = matchC + possible[1];

            if(newRow >= 0 && newRow < 
            forest.length && 
            newCol >= 0 && 
            newCol < forest[newRow].length && 
            forest[newRow][newCol] == 't')
            {
                possibleList.add(new int[]{newRow, newCol});
            }
        }
        return possibleList;
    }
}