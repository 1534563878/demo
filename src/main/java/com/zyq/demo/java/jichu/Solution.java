package com.zyq.demo.java.jichu;

import java.util.Optional;
import java.util.regex.Pattern;
//避免创建不必要的内存
public class Solution {
    public static void main(String[] args) {
        System.out.println(sum1());
        System.out.println(sum2());
    }
    /* 正则表达式会创建隐式的Pattern  使用完后会销毁
  static boolean isRomanNumeral(String s) {
       return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
               + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
   }*/
    private static  final Pattern Roman = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeral(String s) {
        return Roman.matcher(s).matches();
    }


    //要优先使用基本类型而不是装箱类型，
    public static Long sum1(){
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-startTime;
        System.out.println("sum1共耗时："+time);
        return  sum;
    }
    public static Long sum2(){
        long startTime = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-startTime;
        System.out.println("sum2共耗时："+time);
        return  sum;
    }
}
