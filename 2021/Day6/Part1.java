import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day6.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String[] line = br.readLine().split(",");
        ArrayList<Integer> fish = new ArrayList<Integer>();
        for(String a : line) {
            fish.add(Integer.parseInt(a));
        }
        // System.out.println(Arrays.toString(fish.toArray()));
		for (int i = 0; i < 256; i++) {
            for (int j = 0; j < fish.size(); j++) {
                if(fish.get(j) == 0) {
                    fish.set(j, 6);
                    fish.add(9);
                } else 
                    fish.set(j, fish.get(j)-1);
            }
            // System.out.println(Arrays.toString(fish.toArray()));
        }
        System.out.println(fish.size());
    }
}
