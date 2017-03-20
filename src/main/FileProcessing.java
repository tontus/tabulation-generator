package main;

import calculation.GradeCalculation;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Kazi Mainul Islam on 3/18/2017.
 */
public class FileProcessing {

    public static void process(String location){
        int counter = 0;
        File file = new File(location);
        Scanner scan = null;
        try{
            scan = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        while (scan.hasNext()){
            String line = scan.nextLine();
            String[] data = line.split(",");
            if(counter > 0){
                String reg = data[0];
                int tt = Integer.parseInt(data[1]);
                int atd = Integer.parseInt(data[2]);
                int pA = Integer.parseInt(data[3]);
                int pB = Integer.parseInt(data[4]);
                String result = GradeCalculation.calculate(atd, tt, pA, pB);
                System.out.println(reg + "  " + result);

                StoreResult.addResult(reg, result);
            }
            counter++;
        }
        StoreResult.positionCounter++;
    }

    public static void processLab(String location){
        int counter = 0;
        File file = new File(location);
        Scanner scan = null;
        try{
            scan = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        while (scan.hasNext()){
            String line = scan.nextLine();
            String[] data = line.split(",");
            if(counter > 0){
                String reg = data[0];
                int totalMarks = Integer.parseInt(data[1]);
                String result = GradeCalculation.calculate(totalMarks);
                System.out.println(reg + "  " + result);

                StoreResult.addResult(reg, result);
            }
            counter++;
        }
        StoreResult.positionCounter++;
    }
}
