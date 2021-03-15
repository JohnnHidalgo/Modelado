package ColorMatrix.Laberinto;

import ColorMatrix.ColorMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaberintoMatrix extends JPanel implements ActionListener {

    public  static ElementsMatrixLaberinto elementsOfMatrix[][]=new ElementsMatrixLaberinto[22][22];
    public  static int rowPosition=2,columnPosition=1;
    public  static java.util.List<RoadTaked> caminoTomado=new ArrayList<RoadTaked>();
    public  static int estaVolviendoALaAnterior=0;
    Timer tm=new Timer(500,this);


    public static void main(String a[]){
        LaberintoMatrix colorMatrix=new LaberintoMatrix();
        generateMatrix();
        System.out.println(showMatrix(elementsOfMatrix));
        JFrame jFrame=new JFrame();
        jFrame.setSize(900  ,700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(colorMatrix);
        jFrame.setVisible(true);

//        generateMatrix();
//        new ColorMatrix();
    }
    public static void generateMatrix(){
        int numberOfFigure=(int)(Math.random()*20)+5;
        System.out.println("Son "+numberOfFigure+" autos");
        int numRowRandom=(int)(Math.random()*20)+1;
        int numColumnRandom=(int)(Math.random()*20)+1;
        int numberFigure=(int)(Math.random())*7;
        System.out.println("Genera ["+numRowRandom+","+numColumnRandom+"]");
        int cont=1;
        ElementsMatrixLaberinto elementsMatrix2=new ElementsMatrixLaberinto(3,Color.BLUE,1);
        elementsOfMatrix[20][20]=new ElementsMatrixLaberinto(6,Color.GREEN,1);
        elementsOfMatrix[2][1]=elementsMatrix2;
//        mistakeElements.add(new MistakesElements(2,1));
        while(cont<=numberOfFigure){
            if(numColumnRandom!=0 && numColumnRandom!=elementsOfMatrix[0].length-1 && numRowRandom!=0 && numRowRandom!=elementsOfMatrix.length-1){
                for(int i=0;i<elementsOfMatrix.length;i++){
                    for(int j=0;j<elementsOfMatrix[0].length;j++){
                        if(i==0 || i==elementsOfMatrix.length-1 || j==elementsOfMatrix[0].length-1 || j==0){
                            ElementsMatrixLaberinto elementsMatrix=new ElementsMatrixLaberinto(1,Color.GRAY,0);
                            elementsOfMatrix[i][j]=elementsMatrix;
                        }
                        else {
                            if(i==numRowRandom && j==numColumnRandom){
                                if(elementsOfMatrix[i][j]!=null){
                                    if(elementsOfMatrix[i][j].getNumber()==0){
                                            generateFigures(numberFigure,i,j);
                                            numRowRandom=(int)(Math.random()*20)+1;
                                            numColumnRandom=(int)(Math.random()*20)+1;
                                            cont++;
                                        System.out.println("Genera en ["+numRowRandom+","+numColumnRandom+"]");
                                    }
                                    else {
                                        numRowRandom=(int)(Math.random()*20)+1;
                                        numColumnRandom=(int)(Math.random()*20)+1;
                                    }

                                }else {
                                    elementsOfMatrix[i][j]=new ElementsMatrixLaberinto(0,Color.WHITE,0);

                                }
//                        color[i][j]=Color.red;
                                System.out.println("Encuentra en ["+i+","+j+"]");
//                                System.out.println("Genera ["+numRowRandom+","+numColumnRandom+"]");
                            }
                            else {
                                if(elementsOfMatrix[i][j]!=null){
                                    if(elementsOfMatrix[i][j].getUsedInFigure()==0){
                                        if(elementsOfMatrix[i][j].getNumber()!=2 && elementsOfMatrix[i][j].getNumber()!=3 && elementsOfMatrix[i][j].getNumber()!=4){
                                            ElementsMatrixLaberinto elementsMatrix = new ElementsMatrixLaberinto(0, Color.WHITE,0);
                                            elementsOfMatrix[i][j] = elementsMatrix;
                                        }
                                    }
                                }
                                else {
                                    ElementsMatrixLaberinto elementsMatrix = new ElementsMatrixLaberinto(0, Color.WHITE,0);
                                    elementsOfMatrix[i][j] = elementsMatrix;

                                }
//                            elementsOfMatrix[i][j].setColor(Color.red);
//                            elementsOfMatrix[i][j].setNumber(0);
//                            color[i][j]=Color.white;

                            }

                        }
                    }
                }

            }
            else{
                numRowRandom=(int)(Math.random()*20)+1;
                numColumnRandom=(int)(Math.random()*20)+1;
            }


        }
        System.out.println("Termina de buscar");

        new ColorMatrix();

    }

    public static void generateMove(){
        int lastrowPosition=rowPosition,lastColumnPosition=columnPosition;
        int restrigedPositionRow=0,restrigedPositionColumn=0;
        boolean enterRestringed=false;
        if(rowPosition==20 && columnPosition==20){
            columnPosition=1;
//            System.out.println("SIIII LLEGAAA");
            rowPosition=2;
            cleanMatrix();
            caminoTomado.clear();
            elementsOfMatrix[20][20]=new ElementsMatrixLaberinto(6,Color.GREEN,1);
        }
        else{
            if(estaVolviendoALaAnterior==0){
//                System.out.println("Entra a esta versh");
                if(elementsOfMatrix[rowPosition][columnPosition-1].getNumber()==1 && elementsOfMatrix[rowPosition][columnPosition+1].getNumber()==4 && elementsOfMatrix[rowPosition+1][columnPosition].getNumber()==4 && elementsOfMatrix[rowPosition-1][columnPosition].getNumber()==4){
                    rowPosition++;
                    caminoTomado.add(new RoadTaked(0,0,0,1));
                }

                else
                if(elementsOfMatrix[rowPosition][columnPosition+1].getNumber()==0 || elementsOfMatrix[rowPosition][columnPosition+1].getNumber()==6){
                    columnPosition++;
                    caminoTomado.add(new RoadTaked(1,0,0,0));
                }
                else {
                    if(elementsOfMatrix[rowPosition+1][columnPosition].getNumber()==0 || elementsOfMatrix[rowPosition+1][columnPosition].getNumber()==6){
                        caminoTomado.add(new RoadTaked(0,0,0,1));
                        rowPosition++;
                    }
                    else {
                        if(elementsOfMatrix[rowPosition-1][columnPosition].getNumber()==0 || elementsOfMatrix[rowPosition-1][columnPosition].getNumber()==6){
                            caminoTomado.add(new RoadTaked(0,0,1,0));
                            rowPosition--;
                        }
                        else {
                            if(elementsOfMatrix[rowPosition][columnPosition-1].getNumber()==0 || elementsOfMatrix[rowPosition][columnPosition-1].getNumber()==6){
                                caminoTomado.add(new RoadTaked(0,1,0,0));
                                columnPosition--;
                            }
                            else {
                                    estaVolviendoALaAnterior=1;
                            }
                         }
                    }

                }
            }
//            System.out.println(mostrarElemento(caminoTomado));

            if(estaVolviendoALaAnterior==1){
//                System.out.println("Si viene al estar volviendo");
                if(caminoTomado.size()>0){
//                    System.out.println("Entra donde quiero");
                    RoadTaked roadTaked=caminoTomado.get(caminoTomado.size()-1);
                    if(roadTaked.isLeft==1){
                        elementsOfMatrix[rowPosition][columnPosition-1]=new ElementsMatrixLaberinto(0,Color.WHITE,1);
                        columnPosition--;
                        System.out.println("Entra en la izquierda");
                    }
                    else {
                        if(roadTaked.isRight==1){
                            elementsOfMatrix[rowPosition][columnPosition+1]=new ElementsMatrixLaberinto(0,Color.WHITE,1);
                            columnPosition++;
                            System.out.println("Entra en la derecha");

                        }
                        else {
                            if (roadTaked.isLow == 1) {
                                elementsOfMatrix[rowPosition+1][columnPosition]=new ElementsMatrixLaberinto(0,Color.WHITE,1);
                                rowPosition++;
                                System.out.println("Entra abajo");

                            }
                            else {
                                if(roadTaked.isTop==1){
                                    elementsOfMatrix[rowPosition-1][columnPosition]=new ElementsMatrixLaberinto(0,Color.WHITE,1);
                                    rowPosition--;
                                    System.out.println("Entra arriba");

                                }
                            }
                        }
                    }
                    caminoTomado.remove(caminoTomado.get(caminoTomado.size()-1));
                }
                else {
                    estaVolviendoALaAnterior=0;
                }
//                elementsOfMatrix[rowPosition][columnPosition]=
            }
        }
        elementsOfMatrix[lastrowPosition][lastColumnPosition]=new ElementsMatrixLaberinto(4,Color.MAGENTA,1);
        elementsOfMatrix[rowPosition][columnPosition]=new ElementsMatrixLaberinto(1,Color.BLUE,1);;


        new ColorMatrix();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        generateMove();
        repaint();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int space=0;
        int spaceVertical=0;
        for(int i=0;i<elementsOfMatrix.length;i++){
            for(int j=0;j<elementsOfMatrix[0].length;j++){
                if(elementsOfMatrix[i][j].getNumber()==0){
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.drawRect(100+space,100+spaceVertical,20,20);
                }
                if(elementsOfMatrix[i][j].getNumber()==1) {
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.fillRect(100+space,100+spaceVertical,20,20);

                }
                if(elementsOfMatrix[i][j].getNumber()==2){
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.fillRect(100+space,100+spaceVertical,20,20);
                }
                if(elementsOfMatrix[i][j].getNumber()==3){
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.fillRect(100+space,100+spaceVertical,20,20);
                }
                if(elementsOfMatrix[i][j].getNumber()==4){
//                    System.out.println("Si dibuja el purpura ");
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.drawRect(100+space,100+spaceVertical,20,20);
                }
                if(elementsOfMatrix[i][j].getNumber()==6){
//                    System.out.println("Si dibuja el purpura ");
                    g.setColor(elementsOfMatrix[i][j].getColor());
                    g.fillRect(100+space,100+spaceVertical,20,20);
                }

                space+=22;
            }
            spaceVertical+=22;
            space=0;

        }
        tm.start();
    }

    public static String showMatrix(ElementsMatrixLaberinto[][] elementInMatrix){
        String cad="";
        for(int i=0;i<elementInMatrix.length;i++){

            for (int j=0;j<elementInMatrix[0].length;j++)
            {
                cad+=elementInMatrix[i][j].getNumber()+"   ";
            }
            cad+="\n";
        }
        return cad;
    }
/*
    public static boolean isAlreadyHappened(int i,int j){
        boolean isHappened=false;
        for(int c=0;c<mistakeElements.size();c++){
            if(i==mistakeElements.get(c).getI() && j==mistakeElements.get(c).getJ()){
                isHappened=true;
            }
        }
        return isHappened;
    }*/

    public static void cleanMatrix(){
        for(int i=0;i<elementsOfMatrix.length;i++){
            for(int j=0;j<elementsOfMatrix[0].length;j++){
                if(elementsOfMatrix[i][j].getNumber()==4){
                    elementsOfMatrix[i][j]=new ElementsMatrixLaberinto(0, Color.white,0);
                }

            }
        }

    }

    public static void generateFigures(int typeOfFigure,int row,int column){
        int width=(int)(Math.random()*10)+1;
        int height=(int)(Math.random()*10)+1;
        int matrix[][]=new int[width][height];
        if(typeOfFigure==0){
            Cuadrado cuadrado=new Cuadrado(width,height);
            matrix=cuadrado.getMatrix();
        }
        else {
            if(typeOfFigure==1) {
                EscuadraDownLeft escuadraDownLeft=new EscuadraDownLeft(width,height);
                matrix=escuadraDownLeft.getMatrixCuadrado();
            }
            else {
                if(typeOfFigure==2) {
                    EscuadraDownRight escuadraDownRight=new EscuadraDownRight(width,height);
                    matrix=escuadraDownRight.getMatrixCuadrado();

                }
                else {
                    if(typeOfFigure==3) {
                        EscuadraTopLeft escuadraTopLeft=new EscuadraTopLeft(width,height);
                        matrix=escuadraTopLeft.getMatrix();
                    }
                    else {
                        if(typeOfFigure==4) {
                            EscuadraTopRight escuadraTopRight=new EscuadraTopRight(width,height);
                            matrix=escuadraTopRight.getMatrix();
                        }
                        else {
                            if(typeOfFigure==5) {
                                EseDerecha eseDerecha=new EseDerecha(width,height);
                                matrix=eseDerecha.getMatrixCuadrado();

                            }
                            else {
                                if(typeOfFigure==6) {
                                    EseIzquierda eseIzquierda=new EseIzquierda(width,height);
                                    matrix=eseIzquierda.getMatrixCuadrado();

                                }
                            }
                        }
                    }
                }
            }
        }
        int c=0;
        int f=0;
        System.out.println("Las filas y columnas de la figura "+width+" "+height);
        for(int i=row;i<row+width;i++){
            for(int j=column;j<column+height;j++){
                if(matrix[f][c]==1){
                    if(i<elementsOfMatrix.length-2 && j<elementsOfMatrix[0].length-2){
                        ElementsMatrixLaberinto elementsMatrix=new ElementsMatrixLaberinto(2,Color.RED,1);
                        elementsOfMatrix[i][j]=elementsMatrix;
                    }
                }
                c++;
            }
            f++;
            c=0;
        }
    }

    public static boolean verifyWithoutFigures(int row,int column,int height,int width)
    {
        boolean verify=false;
//        for(int i=0)
        return  verify;
    }
    public static String mostrarElemento(java.util.List<RoadTaked> road){
        String cad="";
        for(int i=0;i<road.size();i++){
            cad+="["+road.get(i).isLeft+","+road.get(i).isRight+","+road.get(i).isTop+","+road.get(i).isLow+"]\n";
        }
        return cad;

    }
}
