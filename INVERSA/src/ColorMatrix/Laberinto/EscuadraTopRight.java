package ColorMatrix.Laberinto;

public class EscuadraTopRight extends FiguraLaberinto {
    public EscuadraTopRight(int width, int hegiht) {
        super(width, hegiht);
    }

    public int[][] getMatrix(){
        int [][] matrix=new int[super.getWidth()][super.getHegiht()];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==matrix.length-1 || j==matrix[0].length-1){
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
