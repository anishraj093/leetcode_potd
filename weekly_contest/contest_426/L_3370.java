class Solution {
    public int smallestNumber(int n) {
        int cnt=0;
        while(n!=0){
            cnt++;
            n>>=1;
        }
        int sum=0;
        int fac=1;
        while(cnt-->0){
            sum+=fac;
            fac<<=1;
        }
        return sum;
    }
}