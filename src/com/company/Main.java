package com.company;

import jdk.jshell.execution.Util;
import utils.ArrayUtils;
import utils.SwingUtils;

import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        if (args.length != 2 && args.length != 3){
            System.err.println("Введены неправильные аргументы");
            return;
        }
        if (!"console".equals(args[0]) & !"window".equals(args[0])){
            System.err.println("Выберите вид программы");
            return;
        }
        int[][] array = ArrayUtils.readIntArray2FromFile(args[1]);

        if (array.length == 0) {
            System.err.println("В исходном файле не содержится массив");
            return;
        }

        if ("console".equals(args[0])) {
            Console console = new Console();
            console.moveLines(args[2], array);

        } else if ("window".equals(args[0])) {
           SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                 (new Form(array)).setVisible(true);
                }
            });
        }
    }
}
