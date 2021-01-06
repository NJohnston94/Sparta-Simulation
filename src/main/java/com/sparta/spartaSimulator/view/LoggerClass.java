package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.CentreManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerClass {
    private static final Logger LOGGER = Logger.getLogger();

    public static void logTrace(String message){
        LOGGER.info(message);
    }
    public static void logError(String message){
        LOGGER.error(message);
    }
}
