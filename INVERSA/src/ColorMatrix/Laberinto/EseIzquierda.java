package ColorMatrix.Laberinto;

public class EseIzquierda extends FiguraLaberinto{

    public EseIzquierda(int width, int hegiht) {
        super(width, hegiht);
    }

    public int[][] getMatrixCuadrado(){
        int [][] matrix=new int[2][3];
        matrix[0][0]=1;
        matrix[0][1]=1;
        matrix[1][1]=1;
        matrix[1][2]=1;
        return matrix;
    }
}
