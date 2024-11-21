//brute force approach 1.fill the guard position  2. fill the wall position
//3.mark the top of guard position if not wall and not guard so on.

class Solution {
    void fill(int[][] matrix,int i,int j){
        int m=matrix.length;
        int n=matrix[0].length;
        //fill the top position
        for(int a=i-1;a>=0;a--){
            if(matrix[a][j]!=2&&matrix[a][j]!=1)matrix[a][j]=3;
            else break;
        }
        //fill the bottom position
        for(int a=i+1;a<m;a++){
            if(matrix[a][j]!=2&&matrix[a][j]!=1)matrix[a][j]=3;
            else break;
        }
        //fill the left position
        for(int a=j-1;a>=0;a--){
            if(matrix[i][a]!=2&&matrix[i][a]!=1)matrix[i][a]=3;
            else break;
        }
        //fill the right position
        for(int a=j+1;a<n;a++){
            if(matrix[i][a]!=2&&matrix[i][a]!=1)matrix[i][a]=3;
            else break;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       int matrix[][]=new int[m][n];
       //fill the guard position
       for(int arr[]:guards){
        int i=arr[0];
        int j=arr[1];
        matrix[i][j]=1;
       } 
       //fill the wall position
       for(int arr[]:walls){
        int i=arr[0];
        int j=arr[1];
        matrix[i][j]=2;
       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==1){
                fill(matrix,i,j);
            }
        }
       }
       int cnt=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0)cnt++;
        }
       }
       return cnt;
    }
}