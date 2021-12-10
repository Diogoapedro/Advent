import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day10.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        long count = 0;
        Stack<String> p; 
        String aux;
		while ((line = br.readLine()) != null) {
            // line = br.readLine();
            p = new Stack<String>();
            Boolean o = true;
            int i = 0;
            while (o && i < line.length()) {
                aux = line.substring(i, i+1);
                System.out.println(aux);
                if (aux.equals("[") || aux.equals("(") || aux.equals("{") || aux.equals("<"))
                    p.add(aux);
                else {
                    if(aux.equals("]") && p.peek().equals("[")) {
                        p.pop();
                    } else if(aux.equals(")") && p.peek().equals("(")) {
                        p.pop();
                    } else if(aux.equals("}") && p.peek().equals("{")) {
                        p.pop();
                    } else if(aux.equals(">") && p.peek().equals("<")) {
                        p.pop();
                    } else {
                        if (aux.equals("]")) {
                            count += 57;
                            o = false;
                        } else if(aux.equals(")")) {
                            count += 3;
                            o = false;
                        } else if(aux.equals("}")) {
                            count += 1197;
                            o = false;
                        } else if(aux.equals(">")) {
                            count += 25137;
                            o = false;
                        }
                    }
                }
                i++;
            }
        }
        System.out.println(count);
    }
}