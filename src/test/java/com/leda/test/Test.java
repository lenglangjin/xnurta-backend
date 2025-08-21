package com.leda.test;

public class Test {

    public static void main(String[] args) {

        //01111010101000
        //00001100
//        int nums[] = new int[]{0,0,0,0,1,1,0,0};
        int nums[] = new int[]{0,1,1,1,1,0,1,0,1,0,1,0,0,0};
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] == 0) {
                    zero++;
                }else {
                    one++;
                }
                if(zero == one && zero+one > max){
                    max = zero+one;
                }
            }
        }
        System.out.println(max);
    }

    public void test(){
        String a = "sdf sdfs d df  sdf dddsdfsf      dd";
        int count = 0;
        for (int i = a.length()-1; i>=0 ; i--) {
            if(!" ".equals(a.charAt(i)+"")){
                count ++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }

}
