package com.syntax.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Draft {

    public static String startOz(String str) {
        if (str.length()>0) {
            String result = "";
            if (str.indexOf("oz") == 0) {
                return str.substring(0, 2);
            } else if (str.charAt(0) == 'o') {
                return result + str.charAt(0);
            } else if (str.charAt(1) == 'z') {
                return result + str.charAt(1);
            } else {
                return result;
            }
        }
        return str;
    }


    public static void main(String[] args) {
        String str="";
        System.out.println(startOz(str));
    }
}


