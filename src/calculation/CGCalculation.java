package calculation;

import java.text.DecimalFormat;

/**
 * Created by Kazi Mainul Islam on 3/2/2017.
 */
public class CGCalculation {

    private double totalCredit, totalCG;



    public void add(double credit, double cg){
        if(cg>0){
            totalCredit += credit;
            totalCG += credit*cg;
            System.out.println("total credit: " + totalCredit + "  & cg added " + totalCG);
        }
    }

    public double getResult(){
        double result;
        result = totalCG/totalCredit;
        result = Double.parseDouble(new DecimalFormat("##.##").format(result));
        return result;
    }

    public double getTotalCredit(){
        return totalCredit;
    }

    public void reset(){
        totalCredit = 0;
        totalCG = 0;
    }

}
