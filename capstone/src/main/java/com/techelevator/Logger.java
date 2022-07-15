package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    File file = new File("Log.txt");

    public void writeLog(BigDecimal firstNumber, BigDecimal newBalance, String logDescription) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            {
                  writer.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss a")) + " " + logDescription + " $" + firstNumber + " $" + newBalance);
                  writer.close();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        }
    }


}
