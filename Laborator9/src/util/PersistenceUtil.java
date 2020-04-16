package util;

public class PersistenceUtil {
	
	private static PersistenceUtil obj;
	
	private PersistenceUtil() 
	{
		System.out.println("Instance creasted");
	}
	
	public void PersistenceUtil getInstance() 
	{
		if (obj == null)
		{
			obj = new PersistenceUtil();
		}
		return obj;
	}
	
	
}
