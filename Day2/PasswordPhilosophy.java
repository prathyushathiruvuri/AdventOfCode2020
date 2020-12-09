import java.io.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class PasswordPhilosophy {
    static File inputFile;
    static Scanner reader;
    public static void main(String args[]){
        int numCorrectPasswords = 0;
        try{
            inputFile = new File(args[0]);
            reader = new Scanner(inputFile);
        }
        catch(Exception e){
            System.out.println("File does not exist");
            System.exit(0);
        }

        String next;
        while(reader.hasNextLine()){
            int index = 0;
            int count = 0;
            int minimum = 0;
            int maximum = 0;
            next = reader.nextLine();
            System.out.println(next);
            StringBuffer min = new StringBuffer(5);
            StringBuffer max = new StringBuffer(5);
            int compare = Character.compare(next.charAt(index), '-');
            while(compare != 0){
                min.append(next.charAt(index++));
                compare = Character.compare(next.charAt(index), '-');
            }
            minimum = Integer.parseInt(min.toString());
            index++;
            compare = Character.compare(next.charAt(index), ' ');
            while(compare != 0){
                max.append(next.charAt(index++));
                compare = Character.compare(next.charAt(index), ' ');
            }
            maximum = Integer.parseInt(max.toString());
            index += 1;
            char letter = next.charAt(index);
            boolean pos1 = false;
            boolean pos2 = false;
            index += 3;
            compare = Character.compare(next.charAt(index + minimum - 1), letter);
            if(compare == 0){
                pos1 = true;
            }
            compare = Character.compare(next.charAt(index + maximum - 1), letter);
            if(compare == 0){
                pos2 = true;
            }
            if(pos1 && !pos2 || !pos1 && pos2){
                numCorrectPasswords++;
            }


            /*for(; index < next.length(); index++){
                char current = next.charAt(index);
                int equal = Character.compare(current, letter);
                if(equal == 0){
                    count++;
                }
            }
            if(count >= minimum && count <= maximum){
                numCorrectPasswords++;
            }*/
        }
        System.out.println("Correct passwords = " + numCorrectPasswords);
    }
}
