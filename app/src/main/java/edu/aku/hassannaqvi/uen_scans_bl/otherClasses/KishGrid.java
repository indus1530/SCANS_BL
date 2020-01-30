package edu.aku.hassannaqvi.uen_scans_bl.otherClasses;

public abstract class KishGrid {

    private static int[][] grid = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2},
            {1, 1, 3, 3, 3, 3, 3, 3},
            {1, 2, 1, 4, 4, 4, 4, 4},
            {1, 1, 2, 1, 5, 5, 5, 5},
            {1, 2, 3, 2, 1, 6, 6, 6},
            {1, 1, 1, 3, 2, 1, 7, 7},
            {1, 2, 2, 4, 3, 2, 1, 8},
            {1, 1, 3, 1, 4, 3, 2, 1},
            {1, 2, 1, 2, 5, 4, 3, 2}
    };

    public static int kishGridProcess(int hh, int tot) {

        int a = hh, b = tot - 1;

        if (hh > 9) {
            String hhSplit = String.valueOf(hh);
            a = Integer.parseInt(String.valueOf(hhSplit.charAt(hhSplit.length() - 1)));
        }

        if (b > 7) {
            b = 7;
        }

        return grid[a][b];
    }

}
