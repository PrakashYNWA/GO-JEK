package com.gojek.ParkingLot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ParseInputs {
	
	Commands commands;
    static Carpark carpark;
    public ParseInputs() {
        commands = new Commands();
        carpark = new Carpark();
    }
    
    public void parseTextInput(String inputString) {
    	String[] inputs = inputString.split(" ");
        switch (inputs.length) {
            case 1:
                try {
                    Method method = commands.commandsMap.get(inputString);
                    if (method != null) {
                        method.invoke(carpark);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Method method = commands.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(carpark, inputs[1]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Method method = commands.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(carpark, inputs[1], inputs[2]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
    
    
    public void parseFileInput(String filePath) {
       
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseTextInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
    

}
