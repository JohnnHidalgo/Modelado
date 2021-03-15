package ColorMatrix.Laberinto;

public class Cuadrado extends  FiguraLaberinto{
    public Cuadrado(int width, int hegiht) {
        super(width, hegiht);
    }


    public int[][] getMatrix(){
        int [][] matrix=new int[super.getWidth()][super.getHegiht()];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=1;
            }
        }
        return matrix;
    }
}
