package ColorMatrix.Laberinto;

public class EscuadraTopLeft extends FiguraLaberinto {
    public EscuadraTopLeft(int width, int hegiht) {
        super(width, hegiht);
    }
    public int[][] getMatrix(){
        int [][] matrix=new int[super.getWidth()][super.getHegiht()];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
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
