/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensprob;

import java.util.ArrayList;

/**
 *
 * @author kshitij10496
 */
public class NQueensProb {

    int[] x;
    ArrayList<int[][]> solutions = new ArrayList<>();

    public NQueensProb(int N) {
        x = new int[N];
    }

    public boolean canPlaceQueen(int r, int c) {
        /**
         * Returns TRUE if a queen can be placed in row r and column c.
         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
         * values have been set.
         */
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }

    public void addSolutions(int[] x) {
        int N = x.length;
        int solution[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    solution[i][j] = 1;
                } else {
                    solution[i][j] = 0;
                }
            }         
        }
        solutions.add(solution);
    }

    public void placeNqueens(int r, int n) {
        /**
         * Using backtracking this method prints all possible placements of n
         * queens on an n x n chessboard so that they are non-attacking.
         */
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    addSolutions(x);
                } else {
                    placeNqueens(r + 1, n);
                }
            }
        }
    }

    public void callplaceNqueens() {
        placeNqueens(0, x.length);
    }

}