package com.test.sort;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: sunqianqian
 * @Date: 2015/11/10
 * @Description:
 * @CodeReviewer:
 */
public class AdjustString {
    public static void main(String[] args) {
        String s = "a,b，才，d";
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(s);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            sb.append("'");
            sb.append(matcher.group());
            sb.append("'");
        }
        System.out.println(sb.toString());
    }
}
