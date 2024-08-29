public class Array {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,5,6},{7,8,9}};
        int c[][] = new int[3][3];
        System.out.println("Elements of the array: ");
        for (int i =0; i<matrix.length; i++){
            for (int j = 0; j<matrix.length; j++){
                c[i][j] =0;
                for (int k=0;k<matrix.length;k++){
                    c[i][j] += matrix[i][k]*matrix[k][j];
                    System.out.println(c[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
