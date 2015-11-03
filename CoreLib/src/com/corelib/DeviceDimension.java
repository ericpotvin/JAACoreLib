package com.corelib;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * DeviceDimension.java
 *
 * Get the device dimension informations
 *
 * @author	Eric Potvin
 * @version 1.0
 */
public class DeviceDimension {

	/**
	 * Maximum pixels for small devices (portrait)
	 */
	final static private int MAX_PORTRAIT_WIDTH = 550;
	/**
	 * Maximum pixels for small devices (landscape)
	 */
	final static private int MAX_LANDSCAPE_WIDTH = 850;

	public static boolean isSmall(Activity activity, int orientation) {

		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		return width < 550 && orientation == Configuration.ORIENTATION_PORTRAIT
			? true
			: width < 850 && orientation == Configuration.ORIENTATION_LANDSCAPE;
	}
}
