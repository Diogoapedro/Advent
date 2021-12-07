import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        int z = 0;
        List<Integer> numOrd = new ArrayList<Integer>();
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
		while ((line = br.readLine()) != null) {
            numOrd.add(Integer.parseInt(line));
        }
        br.close();
        int tamanho = numOrd.size();
        boolean b = false;
        Collections.sort(numOrd);
        // for (int d : numOrd) {
        //     System.out.println(d);
        // }
        for(int i = 0; i < tamanho-1 && !b; i++) {
            for(int f = i+1; f<tamanho-1 && !b; f++) {
                int j = tamanho-1;
                while (j>i && j>f && (numOrd.get(i) + numOrd.get(f) + numOrd.get(j))>2019 && !b) {
                    // System.out.println(numOrd.get(i) + numOrd.get(j));
                    if((numOrd.get(i) + numOrd.get(f) + numOrd.get(j))== 2020) {
                        x = numOrd.get(i);
                        y = numOrd.get(j);
                        z = numOrd.get(f);
                        b = true;
                    } else 
                        j--;
    
                }
            }
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(x*y*z);
    }

}
