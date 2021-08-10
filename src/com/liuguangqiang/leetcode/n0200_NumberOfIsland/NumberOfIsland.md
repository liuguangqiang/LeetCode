## Number of Islands

https://leetcode.com/problems/number-of-islands/description/

## Description
```
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 
You may assume all four edges of the grid are all surrounded by water.
```

## Example 1:
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

## Example 2:
```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

## Constraints:
- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 300
- grid[i][j] is '0' or '1'.

## Solution by java
```
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
```