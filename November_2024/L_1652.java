//brute force approach
// if(-ve index) --> circular move (i+n)%n

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int res[]=new int[n];
        if(k>0){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=1;j<=k;j++){
                    sum+=code[(i+j)%n];
                }
                res[i]=sum;
            }
        }else if(k<0){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=-1;j>=k;j--){
                    sum+=code[(i+j+n)%n];
                }
                res[i]=sum;
            }
        }
        return res;
    }
}


//sliding window approach O(n)



class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int res[]=new int[n];
        if(k==0)return res;
        int i=-1;int j=-1;
        if(k>0){
            i=1;
            j=k;
        }else{
            i=n-Math.abs(k);
            j=n-1;
        }
        int windowSum=0;
        for(int pointer=i;pointer<=j;pointer++){
            windowSum+=code[pointer];
        }
        for(int x=0;x<n;x++){
            res[x]=windowSum;
            windowSum-=code[i%n];
            i++;
            windowSum+=code[(j+1)%n];
            j++;
        }
        return res;
    }
}