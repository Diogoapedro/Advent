import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day7.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;

        Map<String, Integer> direct = new HashMap<String, Integer>();
        Stack<String> dir = new Stack<String>();
        Stack<Integer> sizes = new Stack<Integer>(); 

        
        while ((line = br.readLine()) != null) {
            if(line.charAt(0) == '$' && line.substring(2, 4).equals("cd")) {     //Command lines

                if(line.charAt(5) == '.') {
                    String a = dir.pop();
                    int i = sizes.pop();
                    direct.put(a, i);
                    sizes.push(sizes.pop() + i);

                } else {
                    dir.push(line.substring(5));
                    sizes.push(0);
                }

            } else if(line.charAt(0) != '$' && line.charAt(0) != 'd') {
                String[] s = line.split(" ");
                sizes.push(sizes.pop() + Integer.parseInt(s[0]));
                
            }
        }
        
        while(!dir.isEmpty()) {
            String a = dir.pop();
            int i = sizes.pop();
            direct.put(a, i);
            if(!dir.isEmpty()) {
                sizes.push(sizes.pop() + i);
            }
        }

        Integer counter = 0;

        // for(String s:direct.keySet()) {
        //     System.out.print(s);
        //     System.out.print(" ");
        //     System.out.println(direct.get(s));
        // }

        for(Integer a:direct.values()) {
            if(a <= 100000) {
                counter += a;
            }
        }

        System.out.println(counter);

    }

}