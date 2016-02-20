package com.corelib;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Timer.java
 *
 * Timer class.
 *
 * @author	Eric Potvin
 * @version 1.0
 */
public class Timer {

	public final static int MINUTES_IN_HOUR = 60;
	public final static int SECONDS_IN_MINUTE = 60;
	private final static String SEPARATOR = ":";

	/**
	 * Convert seconds to hours:minutes:seconds
	 *
	 * @param int Seconds
	 * @return Formated time (hh:mm:ss)
	 */
	public static String convertSecondsToMinutes(int sec) {
		int seconds = sec % Timer.SECONDS_IN_MINUTE;
		int minutes = (sec / Timer.SECONDS_IN_MINUTE) % Timer.MINUTES_IN_HOUR;

		return String.format("%02d", minutes) +
			Timer.SEPARATOR + 
			String.format("%02d", seconds);
	}

}