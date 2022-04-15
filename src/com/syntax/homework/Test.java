package com.syntax.homework;

import com.syntax.seleniumUtil.OpenBrowser;

public class Test {
    public static void main(String[] args) {
        OpenBrowser.openBrowser("http://amazon.com");
        OpenBrowser.driver.quit();
    }
}
