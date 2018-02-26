/*
* Solution to problem: https://leetcode.com/problems/reverse-integer/
*/
class Solution {
    public int reverse(int x) {
      boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x= -1 * x;
        }
        if(x==0 || x < -2147483647 || x > 2147483647) return 0;
        String ans = "";
        while(x>0){
            int unit = x % 10;
            ans += unit;
            x=x/10;
        }
        if(Long.valueOf(ans) > 2147483647){
            return 0;
        }
        else if(isNegative){
            return -1 * Integer.valueOf(ans);
        }else{
            return Integer.valueOf(ans);
        }
    }
}