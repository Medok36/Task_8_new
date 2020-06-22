package com.company;

import utils.ArrayUtils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Console {
    private static Scanner scanConsole = new Scanner(System.in);

    Logic logic = new Logic();

    public void moveLines(String outFile, int[][] array) throws FileNotFoundException {



        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }

        System.out.println(" Массив, «повернутый» относительно переданного на 90°:");
        array = logic.customSort(array);

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                ArrayUtils.writeArrayToFile(outFile, array);
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Массив записан в файл " + outFile + " ");
        System.out.println();
    }
}
