package com.sqq.common;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author qianqian.sun 2018/6/7
 * 描述：Dijkstra 双栈算术表达式求值
 */
public class Evaluate {
    public static Double eval(String[] exp) {
        Stack<String> ops = new Stack<>();
        Stack<Double> val = new Stack<>();

        for (String s : exp) {
            if ("(".equals(s)) {
                ;
            } else if (Arrays.asList("+", "-", "*", "/", "sqrt").contains(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                String op = ops.pop();
                Double v = val.pop();
                if ("+".equals(op)) v = val.pop() + v;
                else if ("-".equals(op)) v = val.pop() - v;
                else if ("*".equals(op)) v = val.pop() * v;
                else if ("/".equals(op)) v = val.pop() / v;
                else if ("sqrt".equals(op)) v = Math.sqrt(v);
                val.push(v);
            } else {
                val.push(Double.parseDouble(s));
            }
        }
        return val.pop();
    }

    public static void main(String[] args) {
        String express = "( sqrt ( ( 1 + 2 ) * 3 ) )";
        Double val = eval(express.split(" "));
        System.out.println(String.format("%s = %f", express, val));
    }
}
