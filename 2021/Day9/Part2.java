import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day9.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int[][] tab = new int[100][100];
        int aux = 0;
        long aux2 = 0;
        long sol[/**o stor vai dar o peido mestre */] = new long[3];
		while ((line = br.readLine()) != null) {
            for(int i = 0; i < 100; i++) {
                tab[aux][i] = Integer.parseInt(line.substring(i, i+1));
            }
            aux++;
        }
        for (int i = 0; i < 100; i++) {
            for (int k = 0; k < 100; k++) {
                if (verify(i, k, tab)) {
                    aux2 = verifyAll(i, k, tab, 1, tab[i][k]);
                    sol[smallestIndex(sol)] = aux2;
                }
            }
        }
        // System.out.println(Arrays.toString(tab[1]));
        System.out.println(Arrays.toString(sol));
    }
    private static int verifyAll(int row, int col, int[][]c, int size, int last){
        if (row > 0 && row < 99 && col > 0 && col < 99) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        } else if (row > 0 && row < 99 && col > 0) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
        } else if (row > 0 && row < 99 && col < 99) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        } else if (row > 0 &&  col > 0 && col < 99) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        } else if (row < 99 && col > 0 && col < 99) {
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        } else if (row < 99 && col < 99) {
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        } else if (row > 0 && col > 0) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
        } else if (row < 99 && col > 0) {
            if (c[row + 1][col] > last && c[row + 1][col] != 9)
                return verifyAll(row+1, col, c, size+1, c[row][col]);
            if (c[row][col - 1] > last && c[row][col -1] != 9)
                return verifyAll(row, col-1, c, size+1, c[row][col]);
        } else if (row > 0 && col < 99) {
            if (c[row - 1][col] > last && c[row - 1][col] != 9)
                return verifyAll(row-1, col, c, size+1, c[row][col]);
            if (c[row][col + 1] > last && c[row][col + 1] != 9)
                return verifyAll(row, col+1, c, size+1, c[row][col]);
        }
        return size;
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
    private static int smallestIndex (long[] a) {
        int aux = 0;
        long smallest = a[0];
        for (int i = 1; i < 3; i++) {
            if (a[i] < smallest) {
                aux = i;
            }
        }
        return aux;
    }
}
