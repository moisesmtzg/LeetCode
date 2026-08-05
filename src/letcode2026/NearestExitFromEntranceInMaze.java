package letcode2026;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public record Pair(int row, int col){}
    public static int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visitedB = new boolean[maze.length][maze[0].length];
        int[][] movements = {{0,1},{1,0},{-1,0},{0,-1}};
        int steps = 0;
        Pair entranceP = new Pair(entrance[0], entrance[1]);
        queue.offer(entranceP);
        visitedB[entranceP.row][entranceP.col] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for(int[] movement:movements){
                    int newRow = pair.row+movement[0];
                    int newCol = pair.col+movement[1];
                    Pair possiblePair = new Pair(newRow, newCol);
                    //revisamos si la nueva pos es valida
                    if(newRow >=0 && newCol >= 0 &&
                            newRow < maze.length &&
                            newCol < maze[0].length &&
                            maze[newRow][newCol] == '.' &&
                            !visitedB[newRow][newCol]
                            )
                    {
                        //checamos si ya es salida
                        if(newRow == 0 || newRow == maze.length - 1 || newCol == 0 || newCol == maze[0].length - 1){
                            return steps;
                        }
                        queue.offer(possiblePair);
                        visitedB[possiblePair.row][possiblePair.col] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(nearestExit(maze, entrance));
    }
}
