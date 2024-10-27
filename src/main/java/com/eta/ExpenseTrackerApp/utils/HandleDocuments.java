package com.eta.ExpenseTrackerApp.utils;

import com.eta.ExpenseTrackerApp.entity.Income;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class HandleDocuments {

    public static boolean handleDocuments(Income income){
        if (income.getDocument() != null) {
            // Get the Base64 string, split by comma to remove the data URL part
            String base64String = income.getDocument().split(",")[1];

            // Determine file type and set file extension accordingly
            String fileType = income.getDocument().split(";")[0]; // Get the data type (e.g., data:image/png)
            String fileExtension = "." + fileType.split("/")[1];

            byte[] decodedBytes = Base64.getDecoder().decode(base64String);

            // Create a unique filename or define a specific path
            String fileName = "D:\\Deepak\\Movies\\document" + System.currentTimeMillis() + fileExtension;

            try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
                fos.write(decodedBytes);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
