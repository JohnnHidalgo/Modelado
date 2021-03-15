package RedesDePetri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RedDePetriSimple extends JPanel implements ActionListener {

    Timer tm=new Timer(5,this);
    Material material=new Material(100,105);
    int pointInTheProcessX=110;
    int pointInTheProcessY=110;
    int addpointAditional=0;
    int goTop=0;
    int estaBajando=0;
    int estaSubiendo=0;
    int oneTime=0;
    int oneTimeInProcessment=0;
    int oneTimeEstaBajando=0;
    int isStarting=0;
    int oneTimeIncidenceMatrix=0;
    int contador=0;
    int[][] aNegativeMatrix=new int[4][2];
    int[][] aPositiveMatrix=new int[4][2];
    int[][] matrixResult=new int[4][2];


    public static void main(String args[]){
        RedDePetriSimple redDePetriSimple=new RedDePetriSimple();
        JFrame jFrame=new JFrame();
        jFrame.setSize(600,400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(redDePetriSimple);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(isStarting==0){
            System.out.println("Iniciando proceso de maquina");
            isStarting=1;
        }
        if(material.getX()>=100 && material.getX()<200){
            pointInTheProcessX=120;
            pointInTheProcessY=115;
        }

        if(material.getX()>=220 && material.getX()<=280){
            if(goTop==1){
                pointInTheProcessX=295;
                pointInTheProcessY=35;
            }
            else {
                pointInTheProcessX=300;
                pointInTheProcessY=115;
            }
        }

        if(material.getX()>=400 && material.getX()<=450){
            pointInTheProcessX=470;
            pointInTheProcessY=115;
        }

        if(material.getX()>=220 && oneTimeInProcessment==0){
            System.out.println("Procesando producto");
            oneTimeInProcessment=1;
        }
        if(material.getX()+50>=380 && material.getX()<400){
//            System.out.println("LLEGA DONDE QUIERO");
            if(oneTime==0){
                Random random=new Random();
                int numAleatorio=random.nextInt(2)+1;
//                numAleatorio=1;
                if(numAleatorio==2){
//                    System.out.println("Si genera aleatorio es "+numAleatorio);
                    System.out.println("Maquina en reparación");
                    goTop=1;
                    estaSubiendo=1;
                }
                else {
                    System.out.println("Terminando de procesar el producto");
//                    System.out.println("No genera aleatorio es "+numAleatorio);
                    goTop=0;
                }
                oneTime=1;
            }
        }

        if(goTop==1){
            if(estaBajando==1){
                if(oneTimeEstaBajando==0){
                    System.out.println("Maquina en reparación - Proceso de nuevo producto en camino");
                    oneTimeEstaBajando=1;
                }
                if(material.getX()<=220){
                    estaBajando=0;
                    material.setY(115);
                    goTop=0;
                    oneTime=0;
                    oneTimeInProcessment=0;
                    oneTimeEstaBajando=0;
                    addpointAditional=0;
                }
                else {
//                    System.out.println("Esta entrando aca");
                    addpointAditional=1;
                    material.setX(material.getX()-1);
                    material.setY(material.getY()+1);
                }
            }
            else {
                if(estaSubiendo==1){
                    if(material.getX()<280 && material.getY()<50){
                        estaBajando=1;
                        estaSubiendo=0;
                    }
                    else {
//                        System.out.println("LLego aqui");
                        material.setX(material.getX()-1);
                        material.setY(material.getY()-1);
                    }
                }
            }
        }
        else {
//            System.out.println("Se sigue moviendo");
            material.setX(material.getX()+1);
        }

        if(material.getX()+20>=450){
            pointInTheProcessX=120;
            pointInTheProcessY=115;
            material.setX(100);
            oneTimeInProcessment=0;
            material.setY(105);
            oneTime=0;
            contador++;
            System.out.println("Producto terminado\nNuevo proceso en camino");

        }
        if(oneTimeIncidenceMatrix==0){
            aNegativeMatrix[0][0]=1;
            aNegativeMatrix[0][1]=0;
            aNegativeMatrix[1][0]=0;
            aNegativeMatrix[1][1]=0;
            aNegativeMatrix[2][0]=1;
            aNegativeMatrix[2][1]=1;
            aNegativeMatrix[3][0]=0;
            aNegativeMatrix[3][1]=0;

            aPositiveMatrix[0][0]=0;aPositiveMatrix[0][1]=0;
            aPositiveMatrix[1][0]=1;aPositiveMatrix[1][1]=0;
            aPositiveMatrix[2][0]=0;aPositiveMatrix[2][1]=1;
            aPositiveMatrix[3][0]=0;aPositiveMatrix[3][1]=1;

            System.out.println("Matriz a positiva\n"+showMatrix(aPositiveMatrix));
            System.out.println("Matriz a negativa\n"+showMatrix(aNegativeMatrix));
            System.out.println("Matriz de incidencia es\n"+showMatrix(getRestaMatrix(aPositiveMatrix,aNegativeMatrix)));
            oneTimeIncidenceMatrix=1;
        }


//        material.setX(material.getX()+1);
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawOval(100,100,50,50);
        g.drawLine(150,125,200,125);

        //FLECHA
        g.drawLine(195,120,200,125);
        g.drawLine(195,130,200,125);
        g.drawRect(200,100,20,50);

        //FLECHA
        g.drawLine(275,120,280,125);
        g.drawLine(275,130,280,125);
        g.drawLine(220,125,280,125);
        g.drawOval(280,100,50,50);

        //FLECHA
        g.drawLine(224,115,220,125);
        g.drawLine(228,123,220,125);
        g.drawLine(220,125,280,55);
        g.drawOval(280,20,50,50);

        //FLECHA
        g.drawLine(335,55,330,55);
        g.drawLine(331,63,330,55);
        g.drawLine(330,55,380,125);

        //FLECHA
        g.drawLine(330,125,380,125);
        g.drawLine(375,122,380,125);
        g.drawLine(372,128,380,125);
        g.drawRect(380,100,20,50);

        //FLECHA
        g.drawLine(400,125,450,125);
        g.drawLine(445,120,450,125);
        g.drawLine(445,130,450,125);

        g.drawOval(450,100,50,50);
        g.setColor(Color.blue);
        g.drawRect(material.getX(),material.getY(),40,40);
//        tm.start();
        g.setColor(Color.black);
        if(addpointAditional==1){
            g.fillOval(120,120,15,15);
        }
        if(estaSubiendo==1){
            pointInTheProcessX=295;
            pointInTheProcessY=35;
            g.fillOval(pointInTheProcessX,pointInTheProcessY,15,15);
            g.fillOval(470,115,15,15);
        }
        else {
            g.fillOval(pointInTheProcessX,pointInTheProcessY,15,15);

        }
        g.drawString("1", 175,120);
        g.drawString("1", 240,120);
        g.drawString("1", 250,80);
        g.drawString("1", 345,120);
        g.drawString("1", 425,120);
        g.drawString(""+contador,470,115);
        g.drawString("P1",95,95);
        g.drawString("P2",275,95);
        g.drawString("P3",275, 15);
        g.drawString("P4",445,95);
        tm.start();





    }

    public static String showMatrix(int[][] elementInMatrix){
        String cad="";
        for(int i=0;i<elementInMatrix.length;i++){

            for (int j=0;j<elementInMatrix[0].length;j++)
            {
                cad+=elementInMatrix[i][j]+"   ";
            }
            cad+="\n";
        }
        return cad;
    }

    public static int[][]getRestaMatrix(int matriz1[][],int matriz2[][]){
        int resultado[][]=new int[matriz1.length][matriz1[1].length];
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
                resultado [x][y] = matriz1[x][y] - matriz2[x][y];
            }
        }
        return resultado;
    }

}
