public class LeetReversestring {
    
}
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

// recursion method

class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
          
    }

    public static void helper(char[] s,int st,int end){
        if(st>=end) return;

        char temp = s[st];
        s[st]= s[end];
        s[end] = temp;
        helper(s,st + 1,end - 1);
    }
    

}
