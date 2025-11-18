class matrix{
    static void printProduct(int[][] arr,int rowsize,int columnsize){
        for(int i=0;i<rowsize;i++){
            for(int j=0;j<columnsize;j++){
                System.out.println(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static void doproduct(int row1,int col1,
                          int[][] A1,int row2,
                          int col2,int[][] A2){
                              int i,j,k;
                              System.out.println("\nMatrix A:");
        printProduct(A1, row1, col1);
        System.out.println("\nMatrix B:");
        printProduct(A2, row2, col2);
        if (row2 != col1) {

            System.out.println(
                "\nMultiplication Not Possible");
            return;
        }
        int C[][] = new int[row1][col2];

        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A1[i][k] * A2[k][j];
            }
        }
        System.out.println("\nResultant Matrix:");
        printProduct(C, row1, col2);
}

public static void main(String[] args)
    {

        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;

        int A[][] = { { 1, 1, 1 },
                      { 2, 2, 2 },
                      { 3, 3, 3 },
                      { 4, 4, 4 } };

        int B[][] = { { 1, 1, 1, 1 },
                      { 2, 2, 2, 2 },
                      { 3, 3, 3, 3 } };

        doproduct(row1, col1, A, row2, col2, B);
    }
}
