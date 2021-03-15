package TestTStudent;

import InversaFadheva.LimitesConfianza;
import InversaFadheva.ValoresPronosticados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaTStudent {
    public static void main(String[] args) {

        double n = 17;
        double k = 3;
        double nivelConfianza = 0.95;
        double alphamedio = (1 - nivelConfianza) / 2;

        double[][] Y = {
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
                {-3.0},
                {10.0},
        };
/*        double[][] X={{2.0,-5.0,7.0},
                {4.0,2.0,-5.0},
                {5.0,4.0,2.0},
                {7.0,5.0,4.0},
                {2.0,7.0,5.0},
                {6.0,2.0,7.0},
                {4.0,6.0,2.0},
                {-2.0,4.0,6.0},
                {-3.0,-2.0,4.0},
                {11.0,-3.0,-2.0},
                {9.0,11.0,-3.0},
                {10.0,9.0,11.0},
                {-4.0,10.0,9.0},
                {-1.0,-4.0,10.0},
                {8.0,-1.0,-4.0},
                {3.0,8.0,-1.0},
                {-3.0,3.0,8.0},
        };
*/
        //CORRELACION SIMPLE
  //      Hallar A2
        double[][] X={
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
                {90.0},
        };
/*        Double[][] Y={
                {20.0},
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
        };*//*
        //Hallar A1
        Double[][] X={
                {20.0},
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
        };
        Double[][] Y={
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
                {90.0},
        };*/
        //Correlacion simple A3
//        double[][] Y= { { 7.0 }, { -5.0 }, { 2.0 }, { 4.0 }, { 5.0 }, { 7.0 }, { 2.0 }, { 6.0 }, { 4.0 }, { -2.0 },
//                { -3.0 }, { 11.0 }, { 9.0 }, { 10.0 }, { -4.0 }, { -1.0 }, { 8.0 }, { 3.0 }, { -3.0 }, { 10.0 }, };
/*        Double[][] X={
                {20.0},
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
        };
        Double[][] Y={
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
                {90.0},
        };
/*        Double[][] X={
                {20.0},
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
                {90.0}
        };
   /*     Double[][] X = {
                {10.0, 3.0, 1.0},
                {5.0, 1.5, 1.0},
                {10.0, 1.0, 1.0},
                {20.0, 2.0, 1.0},
                {15.0, 4.0, 1.0},
                {10.0, 2.0, 1.0},
                {6.0, 0.0, 0.0},
                {25.0, 1.0, 1.0},
                {30.0, 2.0, 1.0},
                {10.0, 1.0, 1.0},
                {10.0, 1.0, 1.0},
                {20.0, 1.0, 1.0},
                {20.0, 0.5, 1.0},
                {20.0, 2.0, 1.0},
                {30.0, 0.5, 1.0},
                {20.0, 1.0, 0.0},
                {10.0, 1.0, 1.0},
        };/*
        int[][] mA={{3,4,-1},
                   {1,0,3},
                   {2,5,-4}};
                   */
/*
        Double[][] Y = {
                {1.0},
                {2.0},
                {3.0},
                {4.0},
                {5.0},
                {6.0},
                {7.0},
                {8.0},
                {9.0},
                {10.0},
                {11.0},
                {12.0},
                {13.0},
                {14.0},
                {15.0},
                {16.0},
                {17.0},
                {18.0},
                {19.0},
                {20.0},
                {21.0}};
    */

// 2/04/20


/*
        //Datos correlacion simple
        //Y Para Dt-1
        Double Y[][]={
                {-5.0},
                {2.0},
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
                {-3.0},
                {10.0},};

        //Dt-1
        Double X[][]={
                {7.0},
                {-5.0},
                {2.0},
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
                {-3.0},
        };*/
        /*
        //Y Para Dt-2
        Double Y[][]={
                {2.0},
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
                {-3.0},
                {10.0},};


        //Dt-2
        Double X[][]={
                {7.0},
                {-5.0},
                {2.0},
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
        };*/

        //Y Para Dt-3
/*        Double Y[][]={
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
                {3.0},
                {-3.0},
                {10.0},};

        //Dt-3
        Double X[][]={
                {7.0},
                {-5.0},
                {2.0},
                {4.0},
                {5.0},
                {7.0},
                {2.0},
                {6.0},
                {4.0},
                {-2.0},
                {-3.0},
                {11.0},
                {9.0},
                {10.0},
                {-4.0},
                {-1.0},
                {8.0},
        };
*/
//        Double[][] x1=addOneForInverseMatrix(X);
/*        Double[][] x1=X;

//        Double[][] x1=X;

//        Double[][] X=convertIntMatrixToDoubleMatrix(mA);
        Double[][] Xt = matrixTranspose(x1);

        //CALCULO DE LA X TRANSPUESTA POR LA MATRIZ X
        Double[][] XTxX = multiplyMatrices(Xt, x1);
        System.out.println("Matriz XTxX ");
        showMatrix(XTxX);

        //CALCULO DE LA INVERSA DE LA X TRANSPUESTA POR LA MATRIZ X
        Double[][] XTxXinverse = getInverseMatrix(XTxX);
        System.out.println("Matriz Inversa(XTxX) ");
        showMatrix(XTxXinverse);

//        Double[][] inverWithOne = addOneForInverseMatrix(XTxXinverse);
//        showMatrix(inverWithOne);

        //CALCULO DE X POR Y
        Double[][] XtxY = multiplyMatrices(Xt, Y);
        System.out.println("Matriz XTxY ");
        showMatrix(XtxY);

        //MULTIPLICACION DE [(XtX)-1]*Xt*Y
        Double[][] XtXInverseXtY = multiplyMatrices(XTxXinverse, XtxY);

        //MOSTRAR RESULTADO FINAL
        System.out.println("Matriz Inverse(XtX)XtY, las BETAS son \n----------------------");
//        showMatrix(XtXInverseXtY);

        System.out.println("a1= ");
        showMatrix(XtXInverseXtY);

        // CORRELACION SIMPLE
        Double a1s=0.440490341649941;
        Double a2s=-0.20904345575012467;
        Double a3s=0.3010564675192365;

        //CORRELACION PARCIAL
        Double a1=-0.08014550574982399;
        Double a2=-0.4504283965728274	;
        Double a3=-0.19092219020172913;



 /*
        Double a1=0.988693;
        Double a2=0.926288;
        Double a3=0.9571630832;

        Double a1s=1.118402520;
        Double a2s=-0.45049334;
        Double a3s=0.41401350;
*/
/*        Double[][] matrixAs=solveMatrix(a1s,a2s,a3s);
        System.out.println("Las casi GAMAS");
        showMatrix(matrixAs);
        Double[][] matrixAInverses=getInverseMatrix(matrixAs);
        System.out.println("La inversa de las GAMAS CON LA SIMPLE");
        showMatrix(matrixAInverses);
        Double[][] aMatrixNegatives=generateAMinusMatrix(a1s,a2s,a3s);
        System.out.println("Las a negativos son: ");
        showMatrix(aMatrixNegatives);
        Double[][] gammasS=multiplyMatrices(matrixAInverses,aMatrixNegatives);
        System.out.println("Las gammas con la correlacion simple: ");
        showMatrix(gammasS);


        Double[][] matrixA=solveMatrix(a1,a2,a3);
        Double[][] matrixAInverse=getInverseMatrix(matrixA);
        Double[][] aMatrixNegative=generateAMinusMatrix(a1,a2,a3);
        Double[][] gammas=multiplyMatrices(matrixAInverse,aMatrixNegative);

//        System.out.println("Las gammas con la correlacion parcial: ");
//        showMatrix(gammas);



        List<Double> YestimadasList = CoeficienteDeterminacionAjustado.hallarYEstimadas(x1, XtXInverseXtY);

        double mediaYEstimada = CoeficienteDeterminacionAjustado.getMediaEstimadas(YestimadasList);
        System.out.println("");
        double mediaY = CoeficienteDeterminacionAjustado.getMedia(Y);
        System.out.println("Y media "+mediaY);
//        double sec = CoeficienteDeterminacionAjustado.getSEC(YestimadasList, mediaY);
        double stc = CoeficienteDeterminacionAjustado.getSTC(mediaY, Y);
        double src = CoeficienteDeterminacionAjustado.getSRC(Y, YestimadasList);
        double sec=stc-src;



        double cM1 = sec / (k - 1);
        System.out.println("Cuadrados medios 1\n"+cM1);
        double cM2 = src / (n - k);
        System.out.println("Cuadrados medios 2\n"+cM2);
        double fisher = cM1 / cM2;
        System.out.println("Fisher:\n" + fisher);
        double fisherTeorico=3.634;
        if(fisher>fisherTeorico){
            System.out.println("SE RECHAZA LA H0");
        }
        else {
            System.out.println("SE ACEPTA LA H0");

        }

        System.out.println("SEC = "+sec);
        System.out.println("SRC = "+src);
        System.out.println("STC = "+stc);
        double r1=sec/stc;
        double r2=1-(src/stc);

        System.out.println("R1 = "+r1);
        System.out.println("R2 = "+r2);

        double rcuadrado=1-(src/stc);
        System.out.println("El r cuadrado es "+rcuadrado);
        double varianzaPoblacionalCuadrada=src/(x1.length-(x1[0].length-1));
        System.out.println("El valor de la varianza general es: "+varianzaPoblacionalCuadrada);
        Double[][] varianzaBgeneral=multiplyConstantWithMatrix(varianzaPoblacionalCuadrada,XTxXinverse);
        System.out.println("El valor de las varianzas Betas son: ");
        showMatrix(varianzaBgeneral);
        double desviacionEstandar=Math.sqrt(varianzaPoblacionalCuadrada);
        System.out.println("El valor de la desviacion estandar general es "+desviacionEstandar);
        List<LimitesConfianza> limitesConfianzaList=getConfidenceLimits(XtXInverseXtY,desviacionEstandar,alphamedio,XTxXinverse);

        String confidenceLimits=showConfidenceLimits(limitesConfianzaList);
        System.out.println(confidenceLimits);

        String testConfidence=pruebaDeHipotesis(limitesConfianzaList,nivelConfianza);
        System.out.println(testConfidence);

        System.out.println("La lista de las Y estimadas es: "+showList(YestimadasList));
        List<Double> ydifferenceEstimates=getDifferenceEstimatesY(YestimadasList);
        System.out.println("La lista de las diferencias Y estimadas es: "+showList(ydifferenceEstimates));
        List<Double> yList=convertMatrixToListDouble(Y);
        List<Double> yListExceptTheFirstElement=getListMenosFirstElement(yList);
        System.out.println("La lista de Y menos el primer elemento es "+showList(yListExceptTheFirstElement));
        List<Double> listYEstimatesDifferenceDivideYList=getGammaEstimatesList(ydifferenceEstimates,yListExceptTheFirstElement);
        System.out.println("La lista de gamas son: "+showList(listYEstimatesDifferenceDivideYList));
        System.out.println("La lista estimada de gamas queda:\n"+testGammasSignificatives(listYEstimatesDifferenceDivideYList));


        Double[][] Xm={
                {20.0},
                {27.0},
                {22.0},
                {24.0},
                {28.0},
                {33.0},
                {40.0},
                {42.0},
                {48.0},
                {52.0},
                {50.0},
                {47.0},
                {58.0},
                {67.0},
                {77.0},
                {73.0},
                {72.0},
                {80.0},
                {83.0},
                {80.0},
                {90.0}
        };
        List<ValoresPronosticados> valoresPronosticadosList=getNewValorPronostic(Xm,a1s,a2s,a3s);
        System.out.println("La lista de valores pronosticados es : "+showListPronostic(valoresPronosticadosList));*/
        double[][] matrixjoin=joinMatrix(Y,X);
        showMatrix2(matrixjoin);


    }


    public static String testGammasSignificatives(List<Double> gammasList){
        String cad="";
        for (int i=0;i<gammasList.size();i++){
            if(gammasList.get(i)!=0.0){
                cad+=gammasList.get(i)+" Se rechaza la H0\n";
            }
            else {
                cad+=gammasList.get(i)+" Se acepta la H0\n";
            }
        }
        return cad;
    }

    public static List<Double> getDifferenceEstimatesY(List<Double> estimates){
        List<Double> estimatesList=new ArrayList<>();
        for(int i=0;i<estimates.size()-1;i++){
            estimatesList.add(estimates.get(i+1)-estimates.get(i));
        }
        return estimatesList;
    }

    public static List<Double> getListMenosFirstElement(List<Double> elementsList){
        List<Double> estimatesList=new ArrayList<>();
        for(int i=0;i<elementsList.size();i++){
            if(i!=0){
                estimatesList.add(elementsList.get(i));
            }
        }
        return estimatesList;
    }

    public static List<Double> getGammaEstimatesList(List<Double> estimatesDifferenceList,List<Double> listY){
        List<Double> elementsList=new ArrayList<>();
        for(int i=0;i<estimatesDifferenceList.size();i++){
            elementsList.add(estimatesDifferenceList.get(i)/listY.get(i));
        }
        return elementsList;
    }


    public static String showList(List<Double> list){
        String cad="";
        for (int i=0;i<list.size();i++){
            cad+=list.get(i)+", ";
        }
        return cad;
    }

    public static String showListPronostic(List<ValoresPronosticados> list){
        String cad="";
        for (int i=0;i<list.size();i++){
            cad+=list.get(i).getNumberYEstimate()+"  "+list.get(i).getValor()+"\n";
        }
        return cad;
    }

    public static List<Double> convertMatrixToListDouble(Double [][]matrix){
        List<Double> listDouble=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            listDouble.add(matrix[i][0]);
        }
        return listDouble;
    }


    public static Double[][] getInverseMatrix(Double [][]A){
//        Double[][] A=convertIntMatrixToDoubleMatrix(mA);
        Double[][] copyA=copyMatrix(A);
//        System.out.println("Matriz de A1");
//        showMatrix(A);
        int n=1;
        Double q=0.0;
        Double[][] B=new Double[A.length][A[0].length];
        Double[][] copyB=B;
        do{
            Double [][]identityMatrix= generateIdentityMatrix(A);
            q=getTraceOfMatrix(A)/n;
            Double[][] qxI=multiplyConstantWithMatrix(q,identityMatrix);
//            System.out.println("Matriz q x I: ");
//            showMatrix(qxI);
            B=substractMatrices(A,qxI);
//            System.out.println("Matriz B"+n);
//            showMatrix(B);
            if(!verifyMatrixBEqualZero(B)){
                A=multiplyMatrices(copyA,B);
//                System.out.println("Matriz de A"+(n+1));
//                showMatrix(A);
                copyB=B;

            }
            n++;
        }while (!verifyMatrixBEqualZero(B));
        if(n==2){
            copyB=B;
        }
        //      System.out.println("La q es igual a "+q+"\n la B es igual");
        //      showMatrix(copyB);
        Double[][] inverseA=multiplyConstantWithMatrix(1/q,copyB);
        //     System.out.println("Inversa de A");
        //     showMatrix(inverseA);
        return  inverseA;
    }

    public static Double[][] InsertMatriz(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la matriz");
        int n=scanner.nextInt();
        Double[][] matriz= new Double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println("Ingrese la posicion ["+i+"]["+j+"]");
                matriz[i][j]=scanner.nextDouble();
            }
        }
        return matriz;
    }

    public static void showMatrix(Double m[][]){

        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void showMatrix2(double m[][]){

        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }


    public static boolean verifyMatrixBEqualZero(Double m[][]){
        boolean isZero=true;
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                if(m[i][j].intValue()!=0){
                    isZero=false;
                }
            }
        }
        return isZero;
    }


    public static Double[][] substractMatrices(Double m1[][],Double m2[][]){
        Double[][] m=new Double[m1.length][m1[0].length];
        for (int i=0;i<m1.length;i++)
        {
            for (int j=0;j<m1[0].length;j++){
                m[i][j]=m1[i][j]-m2[i][j];
            }
        }
        return m;
    }

    public static Double[][] multiplyMatrices(Double m1[][],Double m2[][]){
        int numRow=0;
        int numColumn=0;
        Double m[][]=new Double[m1.length][m2[0].length];
        if(m1[0].length==m2.length){
            for (int i=0;i<m.length;i++){
                for (int j=0;j<m[0].length;j++){
                    m[i][j]=sumOfRowAndColumnMultiplication(m1,m2,numRow,numColumn);
                    numColumn++;
                }
                numRow++;
                numColumn=0;
            }
        }
        else {
            System.out.println("El numero de columnas de la primera matriz no coincide con el numero de filas de la segunda matriz");
        }
        return m;
    }

    public static Double sumOfRowAndColumnMultiplication(Double m1[][],Double m2[][],int row,int column){
        Double totalAumount=0.0;
        for (int i=0;i<m1[0].length;i++){
            totalAumount+=m1[row][i]*m2[i][column];
        }
        return totalAumount;
    }

    public static Double[][] generateIdentityMatrix(Double m1[][]){
        Double m[][]=new Double[m1.length][m1[0].length];
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                if(i==j){
                    m[i][j]=1.0;
                }
                else m[i][j]=0.0;
            }
        }
        return m;
    }

    public static Double getTraceOfMatrix(Double m[][]){
        Double sum=0.0;
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                if(i==j){
                    sum+=m[i][j];
                }
            }
        }
//        System.out.println("Traza: "+sum);
        return sum;
    }

    public static Double[][] multiplyConstantWithMatrix(Double constant,Double m[][]){
        Double [][]resultMatrix=new Double[m.length][m[0].length];
        for (int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                resultMatrix[i][j]=constant*m[i][j];
            }
        }
        return resultMatrix;
    }


    public static Double[][] convertIntMatrixToDoubleMatrix(int m[][]){
        Double[][] matrix=new Double[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                matrix[i][j]=Double.parseDouble(String.valueOf(m[i][j]));
            }
        }
        return matrix;

    }

    public static int[][] convertDoubleMatrixToIntMatrix(Double m[][]){
        int[][] matrix=new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                matrix[i][j]=m[i][j].intValue();
            }
        }
        return matrix;
    }


    public static Double[][] copyMatrix(Double m[][]){
        Double[][] matrix=new Double[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                matrix[i][j]=m[i][j];
            }
        }
        return matrix;
    }


    public static Double[][] matrixTranspose(Double[][]m){
        Double[][] matrix=new Double[m[0].length][m.length];
        for(int j=0;j<m[0].length;j++){
            for (int i=0;i<m.length;i++){
                matrix[j][i]=m[i][j];
            }
        }

        return matrix;

    }

    public static Double[][] addOneForInverseMatrix(Double[][] inverseXtX){
        Double[][] apart=new Double[inverseXtX.length][inverseXtX[0].length+1];
        for(int i=0;i<inverseXtX.length;i++){
            for(int j=0;j<inverseXtX[0].length+1;j++){
                if(j==0){
                    apart[i][j] =1.0;
                }
                else
                    apart[i][j]=inverseXtX[i][j-1];
            }
        }
        return apart;
    }


    public static List<LimitesConfianza> getConfidenceLimits(Double[][] betas,double desviacionEstandar,double nivelDeConfianza,Double[][] cMatrix){
        List<LimitesConfianza> limitesConfianzaList=new ArrayList<>();
        for (int i=0;i<betas.length;i++){
            double limInferior=betas[i][0]-(nivelDeConfianza*desviacionEstandar*Math.sqrt(cMatrix[i][i]));
            double limSuperior=betas[i][0]+(nivelDeConfianza*desviacionEstandar*Math.sqrt(cMatrix[i][i]));
            double t=betas[i][0]/(desviacionEstandar*Math.sqrt(cMatrix[i][i]));
            LimitesConfianza limitesConfianza=new LimitesConfianza(t,betas[i][0],limInferior,limSuperior);
            limitesConfianzaList.add(limitesConfianza);
        }
        return limitesConfianzaList;
    }

    public static String showConfidenceLimits(List<LimitesConfianza> limitesConfianzaList){
        String cad="";
        for(int i=0;i<limitesConfianzaList.size();i++){
            cad+="B"+i+" Limite inferior = "+limitesConfianzaList.get(i).getLimite_inferior()+"\t limite superior = "+limitesConfianzaList.get(i).getLimite_superior()+"\n";
        }
        return cad;
    }


    public static String pruebaDeHipotesis(List<LimitesConfianza> limitesConfianzaList,double nivelConfianza){
        String cad="";
        for(int i=0;i<limitesConfianzaList.size();i++){
            if(limitesConfianzaList.get(i).getPruebaDeSignificancia()>nivelConfianza){
                cad+="B"+i+" Se rechaza con un valor "+limitesConfianzaList.get(i).getPruebaDeSignificancia()+"\n";
            }
            else {
                cad+="B"+i+" Se acepta con un valor "+limitesConfianzaList.get(i).getPruebaDeSignificancia()+"\n";
            }
        }
        return cad;
    }

    public static Double[][] solveMatrix(Double a1, Double a2,Double a3){
        Double[][] matrix=new Double[3][3];
        matrix[0][0]=a1-1.0;
        matrix[0][1]=a3;
        matrix[0][2]=0.0;
        matrix[1][0]=a3+a1;
        matrix[1][1]=-1.0;
        matrix[1][2]=0.0;
        matrix[2][0]=a1;
        matrix[2][1]=a2;
        matrix[2][2]=1.0;
        return matrix;
    }

    public static Double[][] generateAMinusMatrix(Double a1,Double a2,Double a3){
        Double[][] aMatrix=new Double[3][1];
        aMatrix[0][0]=a1*(-1);
        aMatrix[1][0]=a2*(-1);
        aMatrix[2][0]=a3*(-1);
        return aMatrix;
    }

    public static List<ValoresPronosticados> getNewValorPronostic(Double [][]m,Double a1,Double a2,Double a3){
        List<ValoresPronosticados> newValors=new ArrayList<>();
        int contador=0;
        Double total=0.0;
        int valoresObjetivosHaHallar=50;
        for(int n=0;n<valoresObjetivosHaHallar;n++){
            for(int i=0;i<m.length;i++){
                if(i>m.length-4){
                    if(i==m.length-3)
                    {
                        total+=m[i][0]*a1;
                    }
                    else
                    if(i==m.length-2){
                        total+=m[i][0]*a2;

                    }
                    else {
                        if(i==m.length-1){
                            total+=m[i][0]*a3;
                        }
                    }

                }

            }
            contador++;

            ValoresPronosticados valoresPronosticados=new ValoresPronosticados("Y "+contador,total);
            newValors.add(valoresPronosticados);
        }
        return newValors;
    }

    public static List<Double> integrarSerie(List<ValoresPronosticados> valoresPronosticadosList){
        List<Double> valoresIntegradosList=new ArrayList<>();
        for (int i=0;i<valoresPronosticadosList.size();i++){
            if(i!=0){
                valoresIntegradosList.add(valoresPronosticadosList.get(i-1).getValor()+valoresPronosticadosList.get(i).getValor());
            }
        }
        return valoresIntegradosList;
    }
    public static double[][] joinMatrix(double[][] m1,double[][] m2){
        double[][] matrix=new double[m1.length][m1[0].length+m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length+m2[0].length;j++){
                if(j<m1[0].length){
                    matrix[i][j]=m1[i][j];
                }
                else {
                    matrix[i][j]=m2[i][j-m1[0].length];
                }
            }
        }
        return matrix;

    }

}
