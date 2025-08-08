package ioc;

public class Jio implements Phone {
	
	public Jio()
	{
		System.out.println("Constructor has been called");
	}
	public void calling()
	{
		System.out.println("Calling from jio..");
	}
	public void internet()
	{
		System.out.println("Data from jio..");
	}
}