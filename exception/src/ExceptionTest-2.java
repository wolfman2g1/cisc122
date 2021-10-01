//***********************************************************
// EXCEPTIONTEST.JAVA
//
//  Author: 	R. Butler
//	This program demonstrates the definition and use
//	of exceptions including classes and exception
//	handlers.
//***********************************************************
//--------------------------------------------------
//	Type 1 exception class definition
//--------------------------------------------------
class TypeOneException extends Exception
{
	public TypeOneException()
	{
		super("This is a type I error ");
	}
}
//--------------------------------------------------
//	Type 2 exception class definition
//--------------------------------------------------
class TypeTwoException extends Exception
{
	public String ttName;
	public TypeTwoException(String name)
	{
		super("This is a type II error, my name is not " + name);
		ttName = name;
	}
}
//--------------------------------------------------
//	Type 3 exception class definition
//--------------------------------------------------
class TypeThreeException extends Exception
{
	public String ttName;
	public int ttAge;
	public TypeThreeException(String name, int age)
	{
		super("This is a type III error, I am " + name + " but I'm not " + age);
		ttName = name;
		ttAge = age;
	}
	public TypeThreeException(String msg, String name, int age)
	{
		super(msg);
		ttName = name;
		ttAge = age;
	}

}
//--------------------------------------------------
//	Type 4 exception class definition
//--------------------------------------------------
class TypeFourException extends TypeThreeException
{
	public String tfName;
	public int tfAge;
	public TypeFourException(String name, int age)
	{
		super("This is a type IV error, I am not " + name + " nor am I " + age, name, age);
		tfName = name;
		tfAge = age;
	}
}
//--------------------------------------------------
//	Driver class
//--------------------------------------------------
public class ExceptionTest
{
	public static void main(String[] args) throws TypeOneException, TypeTwoException, TypeThreeException, TypeFourException
	{
	 	try
		{
			switch (args[0].charAt(0))
			{
				case '1': throw new TypeOneException();
				case '2': throw new TypeTwoException("Jonny Doesky");
				case '3': throw new TypeThreeException("P. Lane Jaine", 32);
				case '4': throw new TypeFourException("Wyle E. Kyotie", 45);
				default: System.out.println("All is well");
      }
		}
		catch(TypeOneException e1)						// handler for type 1 exceptions
		{
			System.out.println(e1.toString());
		}
		catch(TypeTwoException e2)						// handler for type 2 exceptions
		{
			System.out.println(e2.toString() + " name: " + e2.ttName);
		}
		catch(TypeThreeException e3)					// handler for types 3 and 4 exceptions
		{
			System.out.println(e3.toString() + " name: " + e3.ttName + " age: " + e3.ttAge);
		}
		catch(ArrayIndexOutOfBoundsException e4)	    // handler for missing cmd line args
		{
			System.out.println("Hey, don't forget the parameter!!!");
		}
		finally
		{
			System.out.println("...and the story continues...");
		}
	}
}
