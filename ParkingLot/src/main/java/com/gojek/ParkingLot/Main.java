package com.gojek.ParkingLot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParseInputs parseInputs = new ParseInputs();
        switch (args.length) {
            case 0:
                System.out.println("Please enter 'quit' to quit");
                System.out.println("Waiting for input...");
                // Run infinite loop for Interactive shell
               
                for (;;) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("quit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                        	parseInputs.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("There has been an error in reading the input from console.");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                // Case when input is a file
            	parseInputs.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
        }

	}

}
