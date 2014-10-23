package com.venky.utils;



import org.apache.log4j.Logger;

import com.venkyold.org.utils.REPORTER;

import java.util.NoSuchElementException;

public class Reporter {

    private static Logger LOGGER = Logger.getLogger(Reporter.class)   ;
	public static void ReportInfo(String message)
	{
		LOGGER.info("Action happening "+message);
        REPORTER.Log(message);

    }
	public static void ReportAssertCondition(boolean condition)
	{
		LOGGER.info("Verifying the condition");
        REPORTER.isTrue(condition);
	}
	public static void ReportAssertEquals(String expected, String actual)
	{
		LOGGER.info("Verifying the expected "+expected+" actual "+actual);
        REPORTER.equals(expected,actual);
	}
	public void ReportVerifyCondition(boolean condition)
	{
		LOGGER.info("Verifying the condition");
		REPORTER.isTrue(condition);
	}
	public void ReportVerifyEquals(String expected, String actual)
	{
		LOGGER.info("Verifying the expected "+expected+" actual "+actual);
		REPORTER.equals(expected,actual);
	}
}
