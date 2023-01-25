import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day5.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        Boolean complete = false;
        Stack<Character>[] pilhas = new Stack[9];
        for(int i = 0; i < 9; i++) {
            pilhas[i] = new Stack<Character>();
        }
		if ((line = br.readLine()) != null) {
            while (!complete) {
                if(line.charAt(1) == '1') {
                    br.readLine();
                    complete = true;
                } else {
                    for(int i = 0; i < 9 ; i++) {
                        if (line.charAt(((i*4)+1)) != ' ') {
                            //System.out.println(line.charAt(((i*4)+1)));
                            pilhas[i].push(line.charAt(((i*4)+1)));
                        }
                    }
                    line = br.readLine();
                }
            }
            for(int i = 0; i < 9; i++) {
                pilhas[i] = rever(pilhas[i]);
            }
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                int howMany = Integer.parseInt(numbers[1]);
                int from = Integer.parseInt(numbers[3]); 
                int to = Integer.parseInt(numbers[5]);
                for(int i = 0; i < howMany; i++) {
                    if(!pilhas[from - 1].isEmpty()) {
                        pilhas[to - 1].push(pilhas[from - 1].pop());
                    }
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            System.out.print(pilhas[i].peek());
        }
        
    }

    public static Stack<Character> rever (Stack<Character> toRever) {
        Stack<Character> newStack = new Stack<Character>();
        while(!toRever.isEmpty()) {
            newStack.push(toRever.pop());
        }
        return newStack;
    }
}