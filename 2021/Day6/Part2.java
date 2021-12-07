import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day6.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String[] line = br.readLine().split(",");
        Map<Integer,Long> fish = new HashMap<Integer,Long>();
        long aux = 0;
        long fin = 0;
        for (int k = 0; k < 9; k++) {
            fish.put(k, Long.parseLong("0"));
        }
        for(String a : line) {
            fish.replace(Integer.parseInt(a), fish.get(Integer.parseInt(a))+1);
        }
        // System.out.println(Arrays.toString(fish.toArray()));
		for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 9; j++) {
                if(j == 0) {
                    aux = fish.get(j);
                    fish.replace(j, fish.get(j+1));
                } else if (j == 8) {
                    fish.replace(j, aux);
                } else if (j == 6) {
                    fish.replace(j, fish.get(j+1) + aux);
                } else
                    fish.replace(j, fish.get(j+1));
            }
            // System.out.println(Arrays.toString(fish.toArray()));
        }
        for (int p = 0; p < 9; p++) {
            fin += fish.get(p);
        }
        System.out.println(fin);
    }
}
