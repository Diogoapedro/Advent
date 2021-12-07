import java.io.*;
import java.util.*;
import java.lang.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day5.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        String[] linha;
        int count = 0;
        int[][] tab = new int[1000][1000];
		while ((line = br.readLine()) != null) {
            linha = line.split("[\\s,]+");
            if((Integer.parseInt(linha[0]) == Integer.parseInt(linha[3])) || (Integer.parseInt(linha[1]) == Integer.parseInt(linha[4]))) {
                for(int i = (Math.min(Integer.parseInt(linha[0]), Integer.parseInt(linha[3]))) ; i <= (Math.max(Integer.parseInt(linha[0]), Integer.parseInt(linha[3]))); i++) {
                    for(int j = (Math.min(Integer.parseInt(linha[1]), Integer.parseInt(linha[4]))); j <= (Math.max(Integer.parseInt(linha[1]), Integer.parseInt(linha[4]))); j++) {
                        tab[j][i]++;
                    }
                }
            } else if ((Integer.parseInt(linha[0]) < Integer.parseInt(linha[3])) 
                        && (Integer.parseInt(linha[1]) < Integer.parseInt(linha[4]))
                        && (Integer.parseInt(linha[3]) - Integer.parseInt(linha[0])) == (Integer.parseInt(linha[4]) - Integer.parseInt(linha[1]))) {
                for(int i = 0 ; (i+Integer.parseInt(linha[0]) <= Integer.parseInt(linha[3])) || (i+Integer.parseInt(linha[1]) <= Integer.parseInt(linha[4])); i++) {
                    tab[i+Integer.parseInt(linha[1])][i+Integer.parseInt(linha[0])]++;
                }
            }  else if ((Integer.parseInt(linha[0]) > Integer.parseInt(linha[3])) 
                        && (Integer.parseInt(linha[1]) < Integer.parseInt(linha[4]))
                        && (Integer.parseInt(linha[0]) - Integer.parseInt(linha[3])) == (Integer.parseInt(linha[4]) - Integer.parseInt(linha[1]))) {
                for(int i = 0 ; (i+Integer.parseInt(linha[3]) <= Integer.parseInt(linha[0])) || (i+Integer.parseInt(linha[1]) <= Integer.parseInt(linha[4])); i++) {
                    tab[i+Integer.parseInt(linha[1])][Integer.parseInt(linha[0])-i]++;
                }
            } else if ((Integer.parseInt(linha[0]) < Integer.parseInt(linha[3])) 
                        && (Integer.parseInt(linha[1]) > Integer.parseInt(linha[4]))
                        && (Integer.parseInt(linha[3]) - Integer.parseInt(linha[0])) == (Integer.parseInt(linha[1]) - Integer.parseInt(linha[4]))) {
                for(int i = 0 ; (i+Integer.parseInt(linha[0]) <= Integer.parseInt(linha[3])) || (i+Integer.parseInt(linha[4]) <= Integer.parseInt(linha[1])); i++) {
                    tab[Integer.parseInt(linha[1])-i][i+Integer.parseInt(linha[0])]++;
                }
            } else if ((Integer.parseInt(linha[0]) > Integer.parseInt(linha[3])) 
                    && (Integer.parseInt(linha[1]) > Integer.parseInt(linha[4]))
                    && (Integer.parseInt(linha[0]) - Integer.parseInt(linha[3])) == (Integer.parseInt(linha[1]) - Integer.parseInt(linha[4]))) {
                for(int i = 0 ; (i+Integer.parseInt(linha[3]) <= Integer.parseInt(linha[0])) || (i+Integer.parseInt(linha[4]) <= Integer.parseInt(linha[1])); i++) {
                    tab[Integer.parseInt(linha[1])-i][Integer.parseInt(linha[0])-i]++;
                }
            }
        }
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(tab[i][j] >= 2)
                    count++;
            }
        }
        System.out.println(count);
    }
}
