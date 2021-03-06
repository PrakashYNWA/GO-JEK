package com.gojek.ParkingLot;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseInputsTest {

	ParseInputs parseInputs = new ParseInputs();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
    @Test
    public void parseTextInput() throws Exception {
 
        parseInputs.parseTextInput("leave 1");
        assertEquals("Parkinglothasnotbeencreated", outContent.toString().trim().replace(" ", ""));
       
    }

}
