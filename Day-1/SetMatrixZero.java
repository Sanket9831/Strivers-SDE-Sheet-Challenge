class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        Arrays.fill(row,1);
        int[] col = new int[matrix[0].length];
        Arrays.fill(col,1);
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        // Set col = 0 where row element is 0
        for(int i = 0; i <matrix.length; ++i){
            if(row[i]==0){
                for(int j = 0; j < matrix[0].length; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        // set row = 0 where col element is 0
        for(int j = 0; j <matrix[0].length; ++j){
            if(col[j]==0){
                for(int i = 0; i < matrix.length; ++i){
                    matrix[i][j] = 0;
                }
            }
        }    
    }
} // TC O(N*M); SC O(N+M)

/*SPACE OPTIMIZED CODE*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // int[] row = new int[matrix.length]; --> matrix[AnyRows][0thCol]
        // Arrays.fill(row,1);
        // int[] col = new int[matrix[0].length]; --> matrix[0thRow][AnyCol]
        // Arrays.fill(col,1);
        int col0 = 1;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        
        // Setting (1,1) to (n-1, m-1) in case 
        // either row(matrix[AnyRows][0thCol]) or col(matrix[0thRow][AnyCol]) is 0
        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        // As "col0" will impact 0th row value, let's first update 0th row based on matrix[othRow][0thCol]
        if(matrix[0][0] == 0){
            for(int j = 1; j <matrix[0].length; ++j){
                    matrix[0][j] = 0;
                }
        }
        
        
        // Finally update the 0th Col based on "col0" value
        if(col0 == 0){
            for(int i = 0; i <matrix.length; ++i){
                    matrix[i][0] = 0;
                }
        }
        
    }
}

// TC O(n^2)
// SC O(1) --> Just using "col0" variable  
