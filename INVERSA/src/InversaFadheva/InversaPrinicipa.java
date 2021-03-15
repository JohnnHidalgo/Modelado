package InversaFadheva;

import CoeficienteDeterminacionAjustado.CoeficienteDeterminacionAjustado;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InversaPrinicipa {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el valor de nivel de confianza");
//        double nivelConfianza=scanner.nextDouble();
        double n = 20;
        double k = 2;
        double nivelConfianza = 0.95;
        double alphamedio = (1 - nivelConfianza) / 2;

        Double[][] Y = { { 359.27 }, { 415.76 }, { 435.11 }, { 440.17 }, { 410.66 }, { 530.33 }, { 557.15 },
                { 472.80 }, { 471.76 }, { 538.30 }, { 547.76 }, { 539.00 }, { 677.6 }, { 943.85 },
                { 893.42 }, { 871.00 }, { 793.93 }, { 850.36 }, { 967.42 }, { 1102.61 } };
/*
        Double[][] Y = { { 102.96 }, { 114.38 }, { 118.23 }, { 120.45 }, { 116.25 }, { 140.27 }, { 143.84},
                { 128.20, }, { 126.65, }, { 141.05 }, { 143.71, }, { 142.37, }, { 173.13, },
                { 223.21, }, { 198.64, }, { 191.89, }, { 181.27, }, { 180.56, }, { 208.24, },
                { 235.43, }, };*/
/*        Double[][] Y = { { 578.49, }, { 650.86, }, { 684.87, }, { 680.47, }, { 642.19, }, { 787.41, },
                { 818.06, }, { 712.16, }, { 722.23, }, { 811.44, }, { 816.36, }, { 807.78, },
                { 983.53, }, { 1292.99, }, { 1179.64, }, { 1134.78, }, { 1053.16, }, { 1085.91, },
                { 1246.99, }, { 1401.94, }, };*/

        Double[][] X = {
                { 1.0, 28.0, 3.06},
                { 1.0, 35.0, 3.19},
                { 1.0, 37.0, 3.3 },
                { 1.0, 36.0, 3.4},
                { 1.0, 29.0, 3.48},
                { 1.0, 47.0, 3.6},
                { 1.0, 50.0, 3.68},
                { 1.0, 35.0, 3.72},
                { 1.0, 33.0, 3.92},
                { 1.0, 40.0, 4.15},
                { 1.0, 38.0, 4.35 },
                { 1.0, 37.0, 4.37 },
                { 1.0, 56.0, 4.59},
                { 1.0, 88.0, 5.23 },
                { 1.0, 62.0, 6.04},
                { 1.0, 51.0, 6.36 },
                { 1.0, 29.0, 7.04 },
                { 1.0, 22.0, 7.81 },
                { 1.0, 38.0, 8.09 },
                { 1.0, 41.0, 9.24}
        };
/*
        Double[][] Y = { { 102.96 }, { 114.38 }, { 118.23 }, { 120.45 }, { 116.25, }, { 140.27 }, { 143.84, },
                { 128.20, }, { 126.65, }, { 141.05 }, { 143.71, }, { 142.37, }, { 173.13, },
                { 223.21, }, { 198.64, }, { 191.89, }, { 181.27, }, { 180.56, }, { 208.24, },
                { 235.43, }, };
        Double[][] X = {
                { 1.0, 28.0 },
                { 1.0, 35.0 },
                { 1.0, 37.0 },
                { 1.0, 36.0 },
                { 1.0, 29.0 },
                { 1.0, 47.0 },
                { 1.0, 50.0 },
                { 1.0, 35.0 },
                { 1.0, 33.0 },
                { 1.0, 40.0 },
                { 1.0, 38.0 },
                { 1.0, 37.0 },
                { 1.0, 56.0 },
                { 1.0, 88.0 },
                { 1.0, 62.0 },
                { 1.0, 51.0 },
                { 1.0, 29.0  },
                { 1.0, 22.0, },
                { 1.0, 38.0, },
                { 1.0, 41.0,  } };
*/
/*
        Double[][] Y = {
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
        Double[][] X={{2.0,-5.0,7.0},
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
        };*/
/*        Double[][] Y={{ 359.27},
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
                { 1.0,10.0, 1.34, 8.48},
                { 1.0,15.0, 1.44, 9.16},
                { 1.0,20.0 ,1.54, 9.9 },
                { 1.0,25.0 ,1.71, 11.02},
                { 1.0,34.0 ,1.89, 11.64},
                { 1.0,27.0 ,1.99, 12.73},
                { 1.0,28.0 ,2.22, 13.88},
                { 1.0,40.0 ,2.43, 14.5},
                { 1.0,37.0 ,2.43, 15.47},
                { 1.0,36.0 ,2.31, 16.61},
                { 1.0,32.0 ,2.39, 17.4},
                { 1.0,30.0 ,2.63, 18.83},
                { 1.0,36.0 ,2.69, 20.62},
                { 1.0,41.0 ,3.35, 23.76},
                { 1.0,45.0 ,2.81, 26.52},
                { 1.0,48.0 ,3.38, 27.45 },
                { 1.0,49.0 ,3.14, 30.28},
                { 1.0,53.0 ,3.14, 25.4},
                { 1.0,57.0 ,6.19, 28.84},
                { 1.0,66.0 ,6.69, 34.36} };

*/
        //CORRELACION SIMPLE
        /*Hallar A2
        Double[][] X={
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
        Double[][] Y={
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


HASTA AQUI*/
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

*/
        Double[][] betitas={
                {22.985},
                {4.8447},
                {72.3536},
        };

        //Y1
//DESDE AQUI -----------------------------------------------------------------------------
        Double[][] matrixEstimadas={
                {394.8096},
                {429.5537},
                {444.3675},
                {451.7588},
                {423.2878},
                {524.4266},
                {554.1307},
                {487.5832},
                {507.5395},
                {560.0529},
                {581.4209},
                {599.8677},
                {694.5623},
                {891.4519},
                {855.2933},
                {828.9144},
                {800.3790},
                {847.3982},
                {956.8255},
                {1088.987}};

        //Y3
/*        Double[][] matrixEstimadas= {
                { 577.2675 },
                {  648.3322 },
                { 677.8518 },
                { 682.3415 },
                { 639.2604 },
                { 791.0645 },
                { 823.2055 },
                { 713.7249 },
                { 719.9472 },
                { 800.5668 },
                { 806.6671 },
                { 799.1868 },
                { 973.9971 },
                { 1298.7739 },
                { 1190.0790 },
                { 1142.0951 },
                { 1048.2664 },
                { 1091.1394 },
                { 1247.5536 },
                { 1404.9325 } };
*/
/*
        //Y2
        Double[][] matrixEstimadas= {
                {  98.9956},
                {  112.7750},
                { 118.7574},
                {  119.7986},
                { 113.0597},
                { 139.1570},
                { 144.4618 },
                { 125.9617},
                { 125.5909},
                { 139.6420},
                { 139.0219},
                { 136.1869},
                { 169.0255},
                { 227.6729},
                { 205.7611},
                { 195.6917},
                { 175.8074},
                { 185.4952},
                { 210.2461},
                { 236.3250} };*/

        List<Double> YestimadasList=convertMatrixToListDouble(matrixEstimadas);
        List<Double> erroresList=CoeficienteDeterminacionAjustado.getErroresList(Y,YestimadasList);
//        List<Double> YestimadasList = CoeficienteDeterminacionAjustado.hallarYEstimadas(X,betitas);


        double media=CoeficienteDeterminacionAjustado.getMediaEstimadas(erroresList);
        double varianzaErrores=CoeficienteDeterminacionAjustado.getVarianzaErrores(media,erroresList);
        System.out.println("LA MEDIA DE LOS ERRORES ES "+ media);
        System.out.println("LA VARIANZA DE LOS ERRORES ES "+varianzaErrores);



        double mediaYEstimada = CoeficienteDeterminacionAjustado.getMediaEstimadas(YestimadasList);
        System.out.println("");
        double mediaY = CoeficienteDeterminacionAjustado.getMedia(Y);
        System.out.println("Y media "+mediaY);
        double sec = CoeficienteDeterminacionAjustado.getSEC(YestimadasList, mediaY);
        double stc = CoeficienteDeterminacionAjustado.getSTC(mediaY, Y);
        double src = CoeficienteDeterminacionAjustado.getSRC(Y, YestimadasList);
//        double sec=stc-src;
        System.out.println("SEC = "+sec);
        System.out.println("SRC = "+src);
        System.out.println("STC = "+stc);



        double cM1 = sec / (k);
        System.out.println("Cuadrados medios 1\n"+cM1);
        double cM2 = src / (n - k);
        System.out.println("Cuadrados medios 2\n"+cM2);
        double fisher = cM1 / cM2;
        System.out.println("Fisher:\n" + fisher);
        double fisherTeorico=2.975;
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
        double varianzaPoblacionalCuadrada=src/(X.length-(X[0].length-1));
        System.out.println("El valor de la varianza general es: "+varianzaPoblacionalCuadrada);
        Double[][] varianzaBgeneral=multiplyConstantWithMatrix(varianzaPoblacionalCuadrada,betitas);
        System.out.println("El valor de las varianzas Betas son: ");
        showMatrix(varianzaBgeneral);
        double desviacionEstandar=Math.sqrt(varianzaPoblacionalCuadrada);
        System.out.println("El valor de la desviacion estandar general es "+desviacionEstandar);
   //     List<LimitesConfianza> limitesConfianzaList=getConfidenceLimits(XtXInverseXtY,desviacionEstandar,alphamedio,XTxXinverse);

     //   String confidenceLimits=showConfidenceLimits(limitesConfianzaList);
//        System.out.println(confidenceLimits);

     //   String testConfidence=pruebaDeHipotesis(limitesConfianzaList,nivelConfianza);
  //      System.out.println(testConfidence);

        System.out.println("La lista de las Y estimadas es: "+showList(YestimadasList));
        List<Double> ydifferenceEstimates=getDifferenceEstimatesY(YestimadasList);
        System.out.println("La lista de las diferencias Y estimadas es: "+showList(ydifferenceEstimates));
        List<Double> yList=convertMatrixToListDouble(Y);
        List<Double> yListExceptTheFirstElement=getListMenosFirstElement(yList);
        System.out.println("La lista de Y menos el primer elemento es "+showList(yListExceptTheFirstElement));
        List<Double> listYEstimatesDifferenceDivideYList=getGammaEstimatesList(ydifferenceEstimates,yListExceptTheFirstElement);
        System.out.println("La lista de gamas son: "+showList(listYEstimatesDifferenceDivideYList));
        System.out.println("La lista estimada de gamas queda:\n"+testGammasSignificatives(listYEstimatesDifferenceDivideYList));

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
        };
        List<ValoresPronosticados> valoresPronosticadosList=getNewValorPronostic(Xm,a1s,a2s,a3s);
        System.out.println("La lista de valores pronosticados es : "+showListPronostic(valoresPronosticadosList));

*/
        showMatrix(generateListOfB());
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
        String valordouble="0.000";
        DecimalFormatSymbols decimalFormatSymbols=new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat format=new DecimalFormat("#.000",decimalFormatSymbols);
        boolean isZero=true;
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                String valor=format.format(m[i][j]);
                if(valor.equals(valordouble)){
                    isZero=false;
                }
/*                if(m[i][j].intValue()!=0){
                    isZero=false;
                }*/
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

    public static Double[][] generateListOfB(){
/*
        Double[][] matrix={
                {1102.61+70.3320},
                {1142.824+15.6087},
                {1124.0407-9.223},
                {1087.3016-7.9827},
                {1075.0148-20.3788},
                {1077.3692-6.0310},
                {1086.2016-5.4820},
                {1092.1593+0.6977},
                {1093.414-32.9242},
                {1091.7449-16.6309},
                {1089.7883+12.086},
                {1088.8714+15.6012},
                {1088.9748-13.9917},
                {1089.4729-9.1596},
                {1089.8490-6.0135},
                {1089.9441-29.000},
                {1089.8561+33.810},
                {1089.7388+4.634},
                {1089.6788-41.5565},
                {1089.6807-11.943},
                {1089.7091+4.63478},
        };*/
        Double[][] matrix={
                {1085.91-2.8491},
                {1246.99-2.2746},
                {1401.94+0.0407},
                {1409.8088-4.6010},
                {1340.5668+2.7172},
                {1283.5628-3.0523},
                {1294.1313+1.006},
                {1326.4824-4.7465},
                {1346.371-2.8468},
                {1343.031+1.3896},
                {1330.330-5.2156},
                {1322.772+8.1134},
                {1324.024-4.8013},
                {1328.921-6.2255},
                {1331.824+0.2154},
                {1331.344+6.0502},
                {1329.4598+3.733},
                {1328.3435-5.0244},
                {1328.528+11.2845},
        };

        return  matrix;

    }

}
