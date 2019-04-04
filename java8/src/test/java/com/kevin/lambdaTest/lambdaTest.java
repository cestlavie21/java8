package com.kevin.lambdaTest;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class lambdaTest {

    @Test
    public void lambdaTest() {

        File file = new File("D:\\msi");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        System.out.println(files[0].getName());
    }

    @Test
    public void lambdaTest1() {

        File[] files = new File("D:\\msi").listFiles(File::isHidden);

        System.out.println(files[0].getName());

    }
}
