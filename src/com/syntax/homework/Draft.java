package com.syntax.homework;

import java.util.ArrayList;

public class Draft {
    public static void main(String[] args) {
        ArrayList<String> task187 = new ArrayList<>();
        task187.add("hi");
        task187.add("yo");
        task187.add("sup");
        task187.add("yolo");
        task187.add("boop");

        for (int i = 0; i < task187.size(); i += 2) {
            task187.set(i, null);
        }

        while(task187.remove(null));{}
        System.out.println(task187);
    }
}
