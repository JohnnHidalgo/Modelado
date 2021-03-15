package ColorMatrix.Laberinto;

public class EscuadraDownLeft extends FiguraLaberinto {
    public EscuadraDownLeft(int width, int hegiht) {
        super(width, hegiht);
    }
    public int[][] getMatrixCuadrado(){
        int [][] matrix=new int[super.getWidth()][super.getHegiht()];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(i==0 || j==matrix[0].length-1){
                    matrix[i][j]=1;
                }
                else {
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }

}
