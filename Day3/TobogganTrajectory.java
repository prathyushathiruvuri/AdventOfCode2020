import java.io.*;
import java.util.*;

public class TobogganTrajectory {
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
        ArrayList<String> trees = new ArrayList<String>();
        int numRows = 0;
        while(reader.hasNextLine()){
            trees.add(reader.nextLine());
            numRows++;
        }
        int numColumns = trees.get(0).length();
        int numTrees1 = 0;
        int numTrees2 = 0;
        int numTrees3 = 0;
        int numTrees4 = 0;
        int numTrees5 = 0;
        int xCoord = 0;
        for(int i = 0; i < numRows; i++){
            xCoord %= numColumns;
            int treePresent = Character.compare(trees.get(i).charAt(xCoord), '#');
            if(treePresent == 0){
                numTrees1++;
            }
            xCoord += 3;
        }
        System.out.println("Num of Trees Passed = " + numTrees1);
        xCoord = 0;
        for(int i = 0; i < numRows; i++){
            xCoord %= numColumns;
            int treePresent = Character.compare(trees.get(i).charAt(xCoord), '#');
            if(treePresent == 0){
                numTrees2++;
            }
            xCoord++;
        }
        System.out.println("Num of Trees Passed = " + numTrees2);
        xCoord = 0;
        for(int i = 0; i < numRows; i++){
            xCoord %= numColumns;
            int treePresent = Character.compare(trees.get(i).charAt(xCoord), '#');
            if(treePresent == 0){
                numTrees3++;
            }
            xCoord += 5;
        }
        System.out.println("Num of Trees Passed = " + numTrees3);
        xCoord = 0;
        for(int i = 0; i < numRows; i++){
            xCoord %= numColumns;
            int treePresent = Character.compare(trees.get(i).charAt(xCoord), '#');
            if(treePresent == 0){
                numTrees4++;
            }
            xCoord += 7;
        }
        System.out.println("Num of Trees Passed = " + numTrees4);
        xCoord = 0;
        for(int i = 0; i < numRows; i+=2){
            xCoord %= numColumns;
            int treePresent = Character.compare(trees.get(i).charAt(xCoord), '#');
            if(treePresent == 0){
                numTrees5++;
            }
            xCoord++;
        }
        System.out.println("Num of Trees Passed = " + numTrees5);
        int product = numTrees1 * numTrees2 * numTrees3 * numTrees4 * numTrees5;
        System.out.println("Mult = " + product);

    }
}
