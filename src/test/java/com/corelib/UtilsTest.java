package com.corelib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.*;

/**
 * Unit test for Utils.
 */
public class UtilsTest
{
	@Test
	public void testUtilsCapitalize()
	{
		String original = "Awesome";

		String str1 = "awesome";
		assertTrue(original.equals(Utils.capitalize(str1)));

		String str2 = "Awesome";
		assertTrue(original.equals(Utils.capitalize(str2)));

	}

	@Test
	public void testUtilsPadRight()
	{
		String source = "Awesome";

		String shouldBe = "Awesome";
		assertTrue(shouldBe.equals(Utils.padRight(source, 7)));

		shouldBe = "Awesome   ";
		assertTrue(shouldBe.equals(Utils.padRight(source, 10)));

		shouldBe = "Awesome        ";
		assertTrue(shouldBe.equals(Utils.padRight(source, 15)));
	}

	@Test
	public void testUtilsPadLeft()
	{
		String source = "Awesome";

		String shouldBe = "Awesome";
		assertTrue(shouldBe.equals(Utils.padLeft(source, 7)));

		shouldBe = "   Awesome";
		assertTrue(shouldBe.equals(Utils.padLeft(source, 10)));

		shouldBe = "        Awesome";
		assertTrue(shouldBe.equals(Utils.padLeft(source, 15)));
	}

	@Test
	public void testUtilsConvertPXToDP()
	{
		float density;
		int pixel;

		density = 1;
		pixel = 10;
		assertTrue(Utils.convertPXToDP(density, pixel) == 11);

		density = 2.5f;
		pixel = 50;
		assertTrue(Utils.convertPXToDP(density, pixel) == 126);
	}

	@Test
	public void testCopyStream() throws IOException
	{
		InputStream inputStream = new ByteArrayInputStream("test data".getBytes());
		OutputStream outputStream = new ByteArrayOutputStream();

		boolean result = Utils.copyStream(inputStream, outputStream);
		assertTrue(result);

		inputStream.close();

		outputStream.flush();
		outputStream.close();
	}
}