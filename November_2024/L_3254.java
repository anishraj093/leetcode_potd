package November_2024;
import java.util.*;
//1. brute force approach store all the k subarray in a list and check it is consecutive or not

class Solution {
    int findConsecutive(List<Integer> list){
        int k=list.size();
        int firstElement=list.get(0);
        for(int i=1;i<k;i++){
            if(list.get(i)!=++firstElement)return -1;
        }
        return list.get(k-1);
    }
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            List<Integer> list=new ArrayList<>();
            int j=i;
            while(list.size()<k){
                list.add(nums[j]);
                j++;
            }
            res[i]=findConsecutive(list);
        }
        return res;
    }
}


//sliding window approach and count the continuous number if appeared

class Solution1 {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        int count=1;
        for(int i=1;i<k;i++){
            if(nums[i-1]+1==nums[i])count++;
            else{
                count=1;
            }
        }
        int i=0,j=k-1;
        if(count>=k)res[i++]=nums[j];
        else res[i++]=-1;
        j++;
        while(j<n){
            if(nums[j-1]+1==nums[j])count++;
            else count=1;
            if(count>=k)res[i++]=nums[j];
            else res[i++]=-1;
            j++;
        }
        return res;
    }
}