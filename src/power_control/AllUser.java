package power_control;

public class AllUser implements User {
	private int power;

	public AllUser(int power)
	{
		this.power=power;
	}
	public Login login()
	{
		if(power==1||power==2)      
		{
			Login l=new Login();
			return l;
		}
		return null;
	}
	public Register register()
	{
		if(power==1||power==2)     
		{
			Register r=Register.getInstance();
			return r;
		}
		return null;
	}
	public ChangePwd changepwd()
	{
		if(power==1||power==2)       //∆’Õ®”√ªß
		{
			ChangePwd c=new ChangePwd();
			return c;
		}
		return null;
	}
}
