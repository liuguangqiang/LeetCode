package com.liuguangqiang.leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * Created by Eric at 2021/3/21 11:12 下午
 */
public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int count = 0;
        int height = grid.length;
        if (height > 0) {
            int width = grid[0].length;
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    //从grid的第一个点开始遍历， 如果发现值等于1，则表示发现了一个岛；
                    //然后从这个点开始蔓延开去；
                    if (grid[h][w] == '1') {
                        count++;
                        floodFill(grid, h, w);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 从发现值等于1的地方，开始蔓延， 检查和其相邻的点是否为1；
     * 如果为1， 就表示还在这个岛范围内， 并把这个点标记为0；
     * 标记为0是为了避免被重复检查；
     *
     * @param grid
     * @param h
     * @param w
     */
    public void floodFill(char[][] grid, int h, int w) {
        if (h >= 0 && h < grid.length && w >= 0 && w < grid[0].length) {
            int value = grid[h][w];
            if (value == '1') {
                grid[h][w] = '0';
                floodFill(grid, h + 1, w);
                floodFill(grid, h, w + 1);
                floodFill(grid, h - 1, w);
                floodFill(grid, h, w - 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] gird = {
                {
                        '1', '1', '1', '1', '0'
                },
                {
                        '1', '1', '0', '0', '0'
                },
                {
                        '0', '0', '1', '0', '0'
                },
                {
                        '0', '0', '0', '1', '1'
                }
        };
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println(numberOfIsland.numIslands(gird));
    }
}
