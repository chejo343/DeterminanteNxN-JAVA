
package ecuacionesgauss;

/**
 *
 * @author Chejo
 */
public class EcuacionesGauss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] matrix=new double[4][4];
        //fila 1
        matrix[0][0]=4;
        matrix[0][1]=3;
        matrix[0][2]=2;
        matrix[0][3]=-2;
        //fila 2
        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=2;
        matrix[1][3]=-2;
        //fila 3
        matrix[2][0]=3;
        matrix[2][1]=-6;
        matrix[2][2]=-2;
        matrix[2][2]=3;
        //fila 4
        matrix[3][0]=2;
        matrix[3][1]=-1;
        matrix[3][2]=4;
        matrix[3][2]=5;
        System.out.print(determinanteNXN(matrix,4));
    }
    
    //metodo recursivo que halla el determinate de una matriz con tamaño especificado
    private static double determinanteNXN(double[][] matrix,int size){
        long total=0;
        if(size>2){
            for(int i=0; i<size; i++){
                if(i%2==0){
                    total+=matrix[0][i]*determinanteNXN(reducir(matrix,i,size-1),size-1);
                }else{
                    total-=matrix[0][i]*determinanteNXN(reducir(matrix,i,size-1),size-1);
                }
            }
        }
        if(size==2){
            return determinante2X2(matrix);
        }
        return total;
    }
    
    //metodo que se utiliza para reducir la matriz quitando la primera fila y la columna que se especifique
    private static double[][] reducir(double[][] matrix,int indexDelete, int newSize){
        double[][] newMatrix=new double[newSize][newSize];
        int r=0,c=0;
        for(int i=1; i<newSize+1; i++){
            for(int j=0; j<newSize+1; j++){
                if(j!=indexDelete){
                    newMatrix[r][c]=matrix[i][j];
                    c++;
                }
            }
            c=0;
            r++;
        }
        return newMatrix;
    }
    
    //metodo que resuelve un determinante de 2x2
    private static double determinante2X2(double[][] matrix){
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
    }
}
