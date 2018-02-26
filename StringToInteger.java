/**
* Solution to problem: https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {
    public int myAtoi(String str) {
         if(str.isEmpty() || str.equals(null)){
            return 0;
        }
        if(str.length()==1){
            if(str.toCharArray()[0]>=48 && str.toCharArray()[0]<=57){
                return Integer.valueOf(str);
            }else{
                return 0;
            }
        }
        str = str.trim();
        int start = 0;
        char[] chars = str.toCharArray();
        boolean isNegative = false;
        StringBuilder builder = new StringBuilder();
        if(chars[0]=='-'){
            isNegative = true;
            start = 1;
        }else if(chars[0]=='+'){
            start=1;
        }
        if(chars[start]>=48 && chars[start]<=57){
            for(int i=start;i<chars.length;i++){
                if(chars[i]>=48 && chars[i]<=57){
                    builder.append(chars[i]);
                }
                else if(!builder.toString().isEmpty()){
                    break;
                }
            }
        }else{
            return 0;
        }
        if(!builder.toString().isEmpty() &&
                builder.toString().length() < 19 && Long.valueOf(builder.toString()) <= 2147483647
                && Long.valueOf(builder.toString()) >= -2147483648){
            if(isNegative){
                return (int) (-1 * Long.valueOf(builder.toString()));
            }else{
                return Integer.valueOf(builder.toString());
            }
        }else{
            if(isNegative){
                return -2147483648;
            }else{
                return 2147483647;
            }
        }
    }
}