package December_24;

class Solution {
    public String addSpaces(String s, int[] spaces) {
      int n=s.length();
      int m=spaces.length;
      int i=0;
      int j=0;
      StringBuilder sb=new StringBuilder();
      while(i<n&&j<m){
        if(i!=spaces[j]){
            sb.append(s.charAt(i));
            i++;
        }
        else {
            sb.append(" ");
            j++;
        }
      }
      while(i<n){
        sb.append(s.charAt(i));
        i++;
      }  
      return sb.toString();
    }
}
