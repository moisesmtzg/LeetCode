package letcode2026;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public record Orange(int row, int col) {
    }

    public static  int bfs(int[][] grid,Queue<Orange> queue , int fresh) {

        int[][] movements = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int time = -1;


        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Orange orange = queue.poll();
                for (int[] mov : movements) {
                    int newRow = orange.row + mov[0];
                    int newCol = orange.col + mov[1];
                    if (newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0) {
                        if (grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            fresh--;
                            queue.offer(new Orange(newRow, newCol));
                        }
                    }
                }
            }
        }
        return (fresh == 0) ? time : -1;
    }

    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Orange> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new Orange(i,j));
                }
            }
        }
        if (fresh == 0) return 0;
        return bfs(grid, queue, fresh);
    }

    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
