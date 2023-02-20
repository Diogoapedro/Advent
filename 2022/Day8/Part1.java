import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day8.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int numLin = 99; //Num de linhas do ficheiro
        int numCol;
        int currLine = 0;
        int[][] tabuleiro;
        int[][] visiveis;
	    String line = br.readLine();

        if (line != null) {
            numCol = line.length();
            tabuleiro = new int[numLin][numCol];
            visiveis = new int[numLin][numCol];
            //System.out.println(numLin + " " + numCol);

            for (int x = 0; x < numLin; x++) {
                Arrays.fill(visiveis[x], 0);
            }
            

            while(line != null) {
                for(int i = 0; i < numCol; i++) {
                    tabuleiro[currLine][i] = Integer.parseInt(line.substring(i, i+1));
                }
                line = br.readLine();
                currLine++;
            }

            //verificacoes verticais
            for (int i = 0; i < numLin; i++) {

                int currTallest1 = 0;
                int currTallest2 = 0;

                for (int j = 0; j < numCol; j++) {

                    //de cima para baixo
                    if (j == 0) {
                        visiveis[j][i] = 1;
                        currTallest1 = tabuleiro[j][i];
                    } else if (((visiveis[j-1][i] == 1) && (tabuleiro[j-1][i] < tabuleiro[j][i])) || tabuleiro[j][i] > currTallest1) {
                        visiveis[j][i] = 1;
                        if(tabuleiro[j][i] > currTallest1) {
                            currTallest1 = tabuleiro[j][i];
                        }
                    }

                    int a = numLin - i - 1;
                    int b = numCol - j - 1;
                    
                    //de baixo para cima
                    if (b == (numLin - 1)) {
                        visiveis[b][a] = 1;
                        currTallest2 = tabuleiro[b][a];
                    } else if (((visiveis[b+1][a] == 1) && (tabuleiro[b+1][a] < tabuleiro[b][a])) || tabuleiro[b][a] > currTallest2) {
                        visiveis[b][a] = 1;
                        if(tabuleiro[b][a] > currTallest2) {
                            currTallest2 = tabuleiro[b][a];
                        }
                    }

                }
            }

            //verificacoes horizontais
            for (int i = 0; i < numLin; i++) {

                int currTallest1 = 0;
                int currTallest2 = 0;

                for (int j = 0; j < numCol; j++) { 
                    //de esquerda para direita
                    if (j == 0) {
                        visiveis[i][j] = 1;
                        // System.out.println(tabuleiro[i][j]);
                        currTallest1 = tabuleiro[i][j];
                    } else if (((visiveis[i][j-1] == 1) && (tabuleiro[i][j-1] < tabuleiro[i][j])) || tabuleiro[i][j] > currTallest1) {
                        visiveis[i][j] = 1;
                        // System.out.println(i + " " + j + " " + tabuleiro[i][j] + " " + currTallest1);
                        if(tabuleiro[i][j] > currTallest1) {
                            currTallest1 = tabuleiro[i][j];
                        }
                    }

                    int a = numLin - i - 1;
                    int b = numCol - j - 1;
                    
                    //da direita para esquerda
                    if (b == (numCol - 1)) {
                        visiveis[a][b] = 1;
                        currTallest2 = tabuleiro[a][b];
                    } else if (((visiveis[a][b+1] == 1) && (tabuleiro[a][b+1] < tabuleiro[a][b])) || tabuleiro[a][b] > currTallest2) {
                        visiveis[a][b] = 1;
                        if(tabuleiro[a][b] > currTallest2) {
                            currTallest2 = tabuleiro[a][b];
                        }
                    }

                }
            }

            //System.out.println(Arrays.deepToString(visiveis));
            //System.out.println(Arrays.deepToString(tabuleiro));

            int count = 0;

            for (int i = 0; i < numLin; i++) {
                for (int j = 0; j < numCol; j++) {

                    if(visiveis[i][j] == 1)
                        count++;

                }
            }

            System.out.println(count);

        }
        
    }

}