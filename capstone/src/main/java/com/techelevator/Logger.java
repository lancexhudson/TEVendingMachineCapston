package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Logger {

    File file = new File("Log.txt");

    public void writeLog(BigDecimal firstNumber, BigDecimal newBalance) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            {
                  writer.println(LocalDateTime.now() + " $" + firstNumber + " $" + newBalance);
                  writer.close();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        }
    }


}
