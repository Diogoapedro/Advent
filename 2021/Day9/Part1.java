import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day9.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int[][] tab = new int[100][100];
        int aux = 0;
        int count = 0;
		while ((line = br.readLine()) != null) {
            for(int i = 0; i < 100; i++) {
                tab[aux][i] = Integer.parseInt(line.substring(i, i+1));
            }
            aux++;
        }
        for (int i = 0; i < 100; i++) {
            for (int k = 0; k < 100; k++) {
                if (verify(i, k, tab))
                    count += (1+tab[i][k]);
            }
        }
        // System.out.println(Arrays.toString(tab[1]));
        System.out.println(count);
    }
    private static boolean verify (int row, int col, int[][]c) {
        int aux = c[row][col];
        if (row > 0 && row < 99 && col > 0 && col < 99) {
            if (aux < c[row - 1][col] && aux < c[row + 1][col] && aux < c[row][col -1] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        } else if (row > 0 && row < 99 && col > 0) {
            if (aux < c[row - 1][col] && aux < c[row + 1][col] && aux < c[row][col -1])
                return true;
            else 
                return false;
        } else if (row > 0 && row < 99 && col < 99) {
            if (aux < c[row - 1][col] && aux < c[row + 1][col] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        } else if (row > 0 &&  col > 0 && col < 99) {
            if (aux < c[row - 1][col] && aux < c[row][col -1] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        } else if (row < 99 && col > 0 && col < 99) {
            if (aux < c[row + 1][col] && aux < c[row][col -1] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        } else if (row < 99 && col < 99) {
            if (aux < c[row + 1][col] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        } else if (row > 0 && col > 0) {
            if (aux < c[row - 1][col] && aux < c[row][col -1])
                return true;
            else 
                return false;
        } else if (row < 99 && col > 0) {
            if (aux < c[row + 1][col] && aux < c[row][col -1])
                return true;
            else 
                return false;
        } else if (row > 0 && col < 99) {
            if (aux < c[row - 1][col] && aux < c[row][col + 1])
                return true;
            else 
                return false;
        }
        return true;
    }
}
