import java.io.*;
import java.util.*;

public class BinaryBoarding {
    static File inputFile;
    static Scanner reader;
    public static void main(String args[]){
        try{
            inputFile = new File(args[0]);
            reader = new Scanner(inputFile);
        }
        catch(Exception e){
            System.out.println("File Not Found");
            System.exit(0);
        }
        int highestID = 0;
        String next;
        boolean[] seatTaken = new boolean[884];
        while(reader.hasNextLine()){
            next = reader.nextLine();
            int power = 6;
            int currentID = 0;
            int currentRow = 0;
            int currentCol = 0;
            System.out.println(next);
            for(int i = 0; i < 10; i++){
                if(i == 7){
                    power = 2;
                }

                if(i < 7){
                    int backHalf = Character.compare(next.charAt(i), 'B');
                    if(backHalf == 0){
                        currentRow += Math.pow(2, power);
                    }
                    power--;
                    if(power == -1){
                        System.out.println("Crow = " + currentRow);
                    }
                }
                else{
                    int rightSide = Character.compare(next.charAt(i), 'R');
                    if(rightSide == 0){
                        currentCol += Math.pow(2, power);
                    }
                    power--;
                }
            }
            System.out.println("CCol = " + currentCol);
            currentID = currentRow * 8 + currentCol;
            seatTaken[currentID] = true;
            if(currentID > highestID){
                highestID = currentID;
            }
        }
        System.out.println("Highest Id = " + highestID);
        for(int i = 0; i < seatTaken.length; i++){
            if(seatTaken[i] == false && seatTaken[i + 1] == true && seatTaken[i - 1] == true){
                System.out.println("Your seatID is " + i);
            }
        }

    }
}
