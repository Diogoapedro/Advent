import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        List<Integer> numOrd = new ArrayList<Integer>();
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
		while ((line = br.readLine()) != null) {
            numOrd.add(Integer.parseInt(line));
        }
    
        int tamanho = numOrd.size();
        boolean b = false;
        Collections.sort(numOrd);
        // for (int d : numOrd) {
        //     System.out.println(d);
        // }
        for(int i = 0; i < tamanho-1 && !b; i++) {
            int j = tamanho-1;
            while (j>i && (numOrd.get(i) + numOrd.get(j))>2019 && !b) {
                if((numOrd.get(i) + numOrd.get(j))== 2020) {
                    x = numOrd.get(i);
                    y = numOrd.get(j);
                    b = true;
                } else 
                    j--;    
            }
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(x*y);
    }

}
