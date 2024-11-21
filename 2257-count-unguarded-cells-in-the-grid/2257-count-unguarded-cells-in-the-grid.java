class Solution {
    // 0 -> unoccupied and unguarded cell
    // 1 -> guarded cell
    // 2 -> guard
    // 3 -> wall
    int[][] grid;
    int m; // Number of rows
    int n; // Number of columns

    /**
     * Main method to count the number of unguarded cells in the grid.
     *
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @param guards Array of guard positions
     * @param walls Array of wall positions
     * @return Number of unoccupied and unguarded cells
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize grid and class-level variables
        grid = new int[m][n];
        this.m = m;
        this.n = n;

        // Mark guard positions with value 2
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark wall positions with value 3
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // Use DFS to mark cells guarded by each guard
        for (int[] guard : guards) {
            int i = guard[0]; // Row of the guard
            int j = guard[1]; // Column of the guard
            dfs(i - 1, j, 'U'); // Explore upwards
            dfs(i + 1, j, 'D'); // Explore downwards
            dfs(i, j + 1, 'R'); // Explore to the right
            dfs(i, j - 1, 'L'); // Explore to the left
        }

        // Count unguarded cells (cells with value 0)
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++; // Increment count for unguarded cells
                }
            }
        }
        return ans; // Return the total number of unguarded cells
    }

    /**
     * Depth First Search (DFS) to mark guarded cells in a given direction.
     *
     * @param i Current row
     * @param j Current column
     * @param dir Direction to move ('U' -> up, 'D' -> down, 'R' -> right, 'L' -> left)
     */
    private void dfs(int i, int j, int dir) {
        // Base case: Out of bounds or cell is already a guard (2), a wall (3), or already guarded (1)
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 2 || grid[i][j] == 3) {
            return;
        }

        // Mark the current cell as guarded (value 1)
        grid[i][j] = 1;

        // Move in the same direction and continue marking cells
        if (dir == 'U') {
            dfs(i - 1, j, 'U'); // Continue upwards
        } else if (dir == 'D') {
            dfs(i + 1, j, 'D'); // Continue downwards
        } else if (dir == 'R') {
            dfs(i, j + 1, 'R'); // Continue to the right
        } else if (dir == 'L') {
            dfs(i, j - 1, 'L'); // Continue to the left
        }
    }
}