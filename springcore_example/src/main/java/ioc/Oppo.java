package ioc;

public class Oppo implements Phone{

	public  Oppo()
	{
		System.out.println("Constructor has been called from oppo..");
	}
	public void calling()
	{
		System.out.println("Calling from Oppo..");
	}
	public void internet()
	{
		System.out.println("Data from Oppo..");
	}
}