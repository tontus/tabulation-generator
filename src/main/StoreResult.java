package main;

import calculation.CGCalculation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Kazi Mainul Islam on 3/18/2017.
 */
public class StoreResult {

//    private static String[][] result = new String[100][30];

//    private static String[] temp = new String[20];

    private static HashMap<String, String[]> data = new HashMap<String, String[]>();

    private static ArrayList<String> listRegNo = new ArrayList<>();
    private static double[] credit = new double[20];
    private static String[] result = new String[100];

    public static int positionCounter = 0;

    public static void addResult(String regNo, String result){
        if(positionCounter != 0){
            String[] temp = new String[20];
            if (data.containsKey(regNo)){
                temp = data.get(regNo);
                temp[positionCounter] = result;
                data.put(regNo, temp);
                System.out.println("Result entered");
            }
            else {
                listRegNo.add(regNo);
                for(int i = 0; i< positionCounter; i++){
                    temp[i] = "-";
                }
                temp[positionCounter] = result;
                data.put(regNo, temp);
            }
        }else {
            listRegNo.add(regNo);
            String[] temp= new String[20];
            temp[0] = result;
            data.put(regNo, temp);
            System.out.println("Registration Done");
        }

    }


    public static void addInfoToTable(){
        CGCalculation calculate = new CGCalculation();
        int j = 0;
        for(String rno : listRegNo){
            String[] result = data.get(rno);
            for(int i =0; i<positionCounter; i++){
                if(i==0){
                    PDFCreator.addValue(rno);
                }
                PDFCreator.addValue(result[i]);
            }
            String[] res = generateResult(result, j);
            PDFCreator.addValue(res[0]);
            PDFCreator.addValue(res[1]);
            System.out.println(rno);
        }
    }

    public static String[] generateResult(String[] regNo, int n){
        String[] output = new String[2];
        CGCalculation cal = new CGCalculation();
        for (int i = 0; i<positionCounter; i++){
            Double cg = Double.parseDouble(regNo[i]);
            cal.add(WindowInputData.credit[i], cg);
        }
        output[0] = "" + cal.getTotalCredit();
        output[1] = "" + cal.getResult();

        return output;
    }



}
