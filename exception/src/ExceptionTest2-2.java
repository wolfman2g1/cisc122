//***********************************************************
// EXCEPTIONTEST2.JAVA
//
// Author: 	R. Butler
//	This program demonstrates the definition and use
//	of exceptions including classes and exception
//	handlers.
//***********************************************************
//--------------------------------------------------
//	Type 5 exception class definition
//--------------------------------------------------
class TypeFiveException extends Exception
{
	public TypeFiveException()
	{
		super("This is a type V error ");
	}
}
//--------------------------------------------------
//	Type 6 exception class definition
//--------------------------------------------------
class TypeSixException extends Exception
{
	public String ttName;
	public TypeSixException(String name)
	{
		super("This is a type VI error, my name is not " + name);
		ttName = name;
	}
}
//--------------------------------------------------
//	Type 7 exception class definition
//--------------------------------------------------
class TypeSevenException extends Exception
{
	public String ttName;
	public int ttAge;
	public TypeSevenException(String name, int age)
	{
		super("This is a type VII error, I am " + name + " but I'm not " + age);
		ttName = name;
		ttAge = age;
	}
	public TypeSevenException(String msg, String name, int age)
	{
		super(msg);
		ttName = name;
		ttAge = age;
	}	
}
//--------------------------------------------------
//	Type 8 exception class definition
//--------------------------------------------------
class TypeEightException extends TypeSevenException
{
	public String tfName;
	public int tfAge;
	public TypeEightException(String name, int age)
	{
		super("This is a type VIII error, I am not " + name + " nor am I " + age, name, age);
		tfName = name;
		tfAge = age;
	}
}
//--------------------------------------------------
//	Driver class
//--------------------------------------------------
public class ExceptionTest2
{
	public static void main(String[] args) throws TypeFiveException, TypeSixException, TypeSevenException, TypeEightException
	{
	    ExceptionTest2 et = new ExceptionTest2();
		try
		{
			switch (args[0].charAt(0))
			{
				case '1': et.methA();
				case '2': et.methB();
				case '3': et.methC();
				case '4': et.methD();
				default: System.out.println("All is well");
        	}
		}
		catch(TypeFiveException e1)					// handler for type 1 exceptions
		{
			System.out.println(e1.toString());
		}
		catch(TypeSixException e2)						// handler for type 2 exceptions
		{
			System.out.println(e2.toString() + " name: " + e2.ttName);
		}
		catch(TypeSevenException e3)					// handler for types 3 and 4 exceptions
		{
			System.out.println(e3.toString() + " name: " + e3.ttName + " age: " + e3.ttAge);
		}
		catch(ArrayIndexOutOfBoundsException e4)	// handler for no cmd line args
		{
			System.out.println("Hey, don't forget to enter a command line parameter");
		}
		finally
		{
			System.out.println("...and the story continues...");
		}
	}
	
	public void methA() throws TypeFiveException
	{
		throw new TypeFiveException();
	}
	
	public void methB() throws TypeSixException
	{
		throw new TypeSixException("Jonny Doesky");
	}
	
	public void methC() throws TypeSevenException
	{
		throw new TypeSevenException("P. Lane Jaine", 32);
	}
	
	public void methD() throws TypeEightException
	{
		try
		{
			methE();
		}
		catch (TypeEightException ef)
		{
			System.out.println("methD caught " + ef.toString());
			throw ef;
		}		
	}
	
	public void methE() throws TypeEightException
	{
		try
		{
			methF();
		}
		catch (TypeEightException ef)
		{
			System.out.println("methE caught " + ef.toString());
			throw ef;
		}
	}
	
	public void methF() throws TypeEightException
	{
		System.out.println("methF throwing type VIII exception");
		throw new TypeEightException("Wyle E. Kyotie", 45);
	}
}
