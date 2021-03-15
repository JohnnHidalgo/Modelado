package PredictionWithGammas;

import InversaFadheva.LimitesConfianza;
import InversaFadheva.ValoresPronosticados;
import CoeficienteDeterminacionAjustado.CoeficienteDeterminacionAjustado;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PredictionWithGammas {
    public static void main(String[] args) {

        double n = 17;
        double k = 3;
        double nivelConfianza = 0.95;
        double alphamedio = (1 - nivelConfianza) / 2;
/*
        Double[][] Y = {
                {  102.96 },
                {  114.38 },
                { 118.23 },
                {  120.45 },
                {  116.25 },
                {  140.27 },
                { 143.84 },
                { 128.20 },
                { 126.65 },
                { 141.05 },
                { 143.71 },
                { 142.37 },
                { 173.13 },
                { 223.21 },
                { 198.64 },
                { 191.89 },
                { 181.27 },
                { 180.56 },
                { 208.24 },
                { 235.43},
        };

        Double[][] X={{10.0,28.0,394.8095},
                {15.0,35.0,429.5537},
                {20.0,37.0,444.3675},
                {25.0,36.0,451.7588},
                {34.0,29.0,423.2879},
                {27.0,47.0,139.1570},
                {28.0,50.0,144.4618},
                {40.0,35.0,125.9617},
                {37.0,33.0,125.5909},
                {36.0,40.0,139.6420},
                {32.0,38.0,139.0219},
                {30.0,37.0,136.1869},
                {36.0,56.0,169.0255},
                {41.0,88.0,227.6729},
                {45.0,62.0,205.7611},
                {48.0,51.0,195.6917},
                {49.0,29.0,175.8074},
                {53.0,22.0,185.4952},
                {57.0,38.0,210.2461},
                {66.0,41.0,236.3250}
        };

/*
        Double[][] Y = {
                { 359.27, 102.96, 578.49, },
                { 415.76, 114.38, 650.86, },
                { 435.11, 118.23, 684.87, },
                { 440.17, 120.45, 680.47, },
                { 410.66, 116.25, 642.19, },
                { 530.33, 140.27, 787.41, },
                { 557.15, 143.84, 818.06, },
                { 472.80, 128.20, 712.16, },
                { 471.76, 126.65, 722.23, },
                { 538.30, 141.05, 811.44, },
                { 547.76, 143.71, 816.36, },
                { 539.00, 142.37, 807.78, },
                { 677.6, 173.13, 983.53, },
                { 943.85, 223.21, 1292.99, },
                { 893.42, 198.64, 1179.64, },
                { 871.00, 191.89, 1134.78, },
                { 793.93, 181.27, 1053.16, },
                { 850.36, 180.56, 1085.91, },
                { 967.42, 208.24, 1246.99, },
                { 1102.61, 235.43, 1401.94, },
        };*/
        Double[][] Y={{ 359.27},
                { 415.76},
                { 435.11},
                { 440.17},
                { 410.66},
                { 530.33},
                { 557.15},
                { 472.80},
                { 471.76},
                { 538.30},
                { 547.76},
                { 539.00},
                { 677.6},
                { 943.85},
                { 893.42},
                { 871.00},
                { 793.93},
                { 850.36},
                { 967.42},
                { 1102.61}};


        Double[][] X= {
                { 1.0,10.0, 1.34, 8.48, 98.9956, 577.2675 },
                { 1.0,15.0, 1.44, 9.16, 112.7750, 648.3323 },
                { 1.0,20.0 ,1.54, 9.9, 118.7574, 677.8518 },
                { 1.0,25.0 ,1.71, 11.02, 119.7986, 682.3415 },
                { 1.0,34.0 ,1.89, 11.64, 113.0597, 639.2604 },
                { 1.0,27.0 ,1.99, 12.73, 139.1570, 791.0645 },
                { 1.0,28.0 ,2.22, 13.88, 144.4618, 823.2056 },
                { 1.0,40.0 ,2.43, 14.5, 125.9617, 713.7249 },
                { 1.0,37.0 ,2.43, 15.47, 125.5909, 719.9472 },
                { 1.0,36.0 ,2.31, 16.61, 139.6420, 800.5668 },
                { 1.0,32.0 ,2.39, 17.4, 139.0219, 806.6671 },
                { 1.0,30.0 ,2.63, 18.83, 136.1869, 799.1868 },
                { 1.0,36.0 ,2.69, 20.62, 169.0255, 973.9971 },
                { 1.0,41.0 ,3.35, 23.76, 227.6729, 1298.7739 },
                { 1.0,45.0 ,2.81, 26.52, 205.7611, 1190.0791 },
                { 1.0,48.0 ,3.38, 27.45, 195.6917, 1142.0951 },
                { 1.0,49.0 ,3.14, 30.28, 175.8074, 1048.2664 },
                { 1.0,53.0 ,3.14, 25.4, 185.4952, 1091.1394 },
                { 1.0,57.0 ,6.19, 28.84, 210.2461, 1247.5536 },
                { 1.0,66.0 ,6.69, 34.36, 236.3250, 1404.9325 } };

//        Double[][] x1=addOneForInverseMatrix(X);
// AQUI EMPIEZA
        Double[][] x1=X;

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
        System.out.println("Matriz Inverse(XtX)XtY, las GAMMAS son \n----------------------");
        showMatrix(XtXInverseXtY);
/*
        System.out.println("a1= ");
        showMatrix(XtXInverseXtY);

        // CORRELACION SIMPLE
        Double a1s=0.440490341649941;
        Double a2s=-0.20904345575012467;
        Double a3s=0.3010564675192365;


        Double[][] matrixAs=solveMatrix(a1s,a2s,a3s);
        System.out.println("Las casi GAMAS");
        showMatrix(matrixAs);
        Double mat[][]={
                {-0.5595,0.3011,0.0},
                {0.7416,-1.0,0.0},
                {0.4405,-0.209,1.0}}
                ;
        Double[][] matrixAInverses=getInverseMatrix(mat);
        System.out.println("La inversa de las GAMAS CON LA SIMPLE");
        showMatrix(matrixAInverses);
        Double[][] aMatrixNegatives=generateAMinusMatrix(a1s,a2s,a3s);
        System.out.println("Las a negativos son: ");
        showMatrix(aMatrixNegatives);
        Double[][] gammasS=multiplyMatrices(matrixAInverses,aMatrixNegatives);
        System.out.println("Las gammas con la correlacion simple: ");
        showMatrix(gammasS);


/*
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
        };*/
        Double Xm[][]={
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



//        Double[][] pi=;
/*
        List<Double> gammasList=convertMatrixToListDouble(gammasS);
        List<ValoresPronosticados> valoresPronosticadosList=getNewValorPronostic(Xm,gammasList);
        System.out.println("La lista de valores pronosticados es : "+showListPronostic(valoresPronosticadosList));
/*
        Double mat[][]={
                {-0.5595,0.3011,0.0},
                {0.7416,-1.0,0.0},
                {0.4405,-0.209,1.0}}
                ;
        System.out.println("La matriz prueba");
        showMatrix(getInverseMatrix(mat));*/
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
        System.out.println("Matriz de A1");
        showMatrix(A);
        int n=1;
        Double q=0.0;
        Double[][] B=new Double[A.length][A[0].length];
        Double[][] copyB=B;
        do{
            Double [][]identityMatrix= generateIdentityMatrix(A);
            q=getTraceOfMatrix(A)/n;
            Double[][] qxI=multiplyConstantWithMatrix(q,identityMatrix);
            System.out.println("Matriz q x I: ");
            showMatrix(qxI);
            Double[][] matrixPositiveZeros=getMatrixWithZerosPositive(qxI);
            System.out.println("La matriz positiva es:  ");
            showMatrix(matrixPositiveZeros);
//            B=substractMatrices(A,qxI);
            Double[][] simplyMatrixDecimal=simplifyDecimalsOfMatrix(matrixPositiveZeros);
            System.out.println("La matriz con los decimales simplificados es:  ");
            showMatrix(simplyMatrixDecimal);
            B=substractMatrices(A,simplyMatrixDecimal);
            System.out.println("Matriz B "+n);
            showMatrix(B);
            if(!verifyMatrixBEqualZero(B)){
                A=multiplyMatrices(copyA,B);
                System.out.println("Matriz de A "+(n+1));
                showMatrix(A);
                copyB=B;

            }
            n++;
        }while (!verifyMatrixBEqualZero(B));
        if(n==2){
            copyB=B;
        }
              System.out.println("La q es igual a "+q+"\n la B es igual");
              showMatrix(copyB);
        Double[][] inverseA=multiplyConstantWithMatrix(1/q,copyB);
             System.out.println("Inversa de A");
             showMatrix(inverseA);
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

    public static List<ValoresPronosticados> getNewValorPronostic(Double [][]m,List<Double> gammas){
        List<ValoresPronosticados> newValors=new ArrayList<>();
        int contador=0;
        Double total=0.0;
        int valoresObjetivosHaHallar=50;
        for(int n=0;n<valoresObjetivosHaHallar;n++){
            for(int i=0;i<m.length;i++){
                if(i>m.length-4){
                    if(i==m.length-gammas.size())
                    {
                        total+=m[i][0]*gammas.get(2);
                    }
                    else
                    if(i==m.length-2){
                        total+=m[i][0]*gammas.get(1);

                    }
                    else {
                        if(i==m.length-1){
                            total+=m[i][0]*gammas.get(0);
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

    public static Double[][] getMatrixWithZerosPositive(Double[][] matrix){
        Double[][]matrixgenerate=new Double[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(String.valueOf(matrix[i][j]).equals("-0.0")){
                    matrixgenerate[i][j]=matrix[i][j]*(-1);
                }
                else {
                    matrixgenerate[i][j]=matrix[i][j];
                }
            }
        }
        return matrixgenerate;

    }


    public static Double[][] simplifyDecimalsOfMatrix(Double[][] matrix){
        Double[][] matrixgenerate=new Double[matrix.length][matrix[0].length];
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                    matrixgenerate[i][j]=Double.parseDouble(formato1.format(matrix[i][j]));
            }
        }
        System.out.println("Valor convertido en la matriz es :"+formato1.format(matrix[0][0]));

        return matrixgenerate;

    }
}
