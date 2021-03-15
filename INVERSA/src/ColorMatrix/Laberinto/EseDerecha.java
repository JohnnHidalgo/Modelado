package ColorMatrix.Laberinto;

public class EseDerecha extends FiguraLaberinto{
    public EseDerecha(int width, int hegiht) {
        super(width, hegiht);
    }

    public int[][] getMatrixCuadrado(){
        int [][] matrix=new int[3][2];
        matrix[0][0]=1;
        matrix[1][0]=1;
        matrix[1][1]=1;
        matrix[2][1]=1;
        return matrix;
    }

}
