// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.util.Stack;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    // O(N^2)
    public int charArea(char ch) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] nxt = new int[n][m];
        for (int i = 0; i < n; ++i) {
            int nxt_ch = -1;
            for (int j = m - 1; j >= 0; --j) {
                if (grid[i][j] == ch) {
                    nxt_ch = Math.max(nxt_ch, j);
                } else {
                    nxt_ch = -1;
                }
                nxt[i][j] = nxt_ch;
            }
        }
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            Stack<Pair> s = new Stack<>();
            for (int i = 0; i < n; ++i) {
                int c = 1;
                int val;
                if (nxt[i][j] != -1) {
                    val = nxt[i][j] - j + 1;
                } else {
                    val = 0;
                }
                while (!s.empty() && s.peek().x >= val) {
                    c += s.pop().y;
                }
                s.push(new Pair(val, c));
                ans = Math.max(ans, val * c);
            }
            int c = 0;
            while (!s.empty()) {
                c += s.peek().y;
                ans = Math.max(ans, s.pop().x * c);
            }
        }
        return ans;
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        return 0; // YOUR CODE HERE
    }
}
