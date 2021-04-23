/*
* CMSC 401 Dr. Bulut
* Pedram Maleki
* */
import java.util.Scanner;

public class cmsc401 {

    public static void main(String[]args){

        int sizeRod=0;
        int numCuts=0;

        Scanner in = new Scanner(System.in);
        sizeRod=in.nextInt();
        numCuts=in.nextInt();

        int [] cutPoints = new int[numCuts];

        for(int i=0;i<numCuts;i++){
            cutPoints[i]=in.nextInt();
        }

//        //2d of nulls, size of rod+2,
//        int [][] memo=new int[sizeRod][numCuts];
//        Arrays.fill(memo,Integer.MAX_VALUE);
//        //add two args

        int minumum=cutRod(0,sizeRod,cutPoints);
        System.out.println(minumum);

    }
    public static int cutRod(int start, int end, int [] cutPoints){
        int minimumVal= Integer.MAX_VALUE;
        int minimum;
        if(cutPoints.length == 0) return 0;

        else if(cutPoints.length == 1){
            return end-start;
        }
        //check memo(array) has the val already calculated
        else{
            minimum=minimumVal;
            for(int i=0; i<cutPoints.length;i++){
                int length=end-start;
                int [] leftCut = new int [i];
                int [] rightCut = new int [cutPoints.length-i-1];
                for(int j=0; j<i; j++){
                    leftCut[j]=cutPoints[j];
                }
                for(int j=1; j<cutPoints.length-i;j++){
                    rightCut[j-1]= cutPoints[i+j];
                }


                minimum=Math.min(minimum,length+(cutRod(start,cutPoints[i],leftCut)+cutRod(cutPoints[i],end,rightCut)));
                    //update memo


            }
            return minimum;
        }

    }


}