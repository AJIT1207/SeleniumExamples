package seleniumex;

import org.testng.annotations.Test;

public class Exceptiontimeout {

	@Test
	public void infinitelooptest()
	{

		int i = 1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
}
