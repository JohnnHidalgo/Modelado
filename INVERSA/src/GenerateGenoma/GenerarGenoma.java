package GenerateGenoma;

public class GenerarGenoma {

    public static void main(){





    }


    public static Integer[][] generatePoblacion(){
        int poblacion=(int)(Math.random()*29)+1;
        Integer[][] elements=new Integer[poblacion][5];
        for(int i=0;i<poblacion;i++){
            Integer[] vec=generateVector();
            elements[i]=vec;
        }
        return elements;
    }

    public static Integer[] generateVector(){
       Integer[] vec=new Integer[5];
       int random=(int)(Math.random()*5);
       int cont=0;
       for(int i=0;i<vec.length;i++){
           if(cont<random){
               if(cont<random){
                  int position=(int)(Math.random()*5);
                  vec[position]=1;
               }
           }
       }
       return vec;
    }

    public static void showMatrix(Integer[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

            }
        }

    }
}
