package power_control;

public class Seller implements User {
	private int power;

	public Seller(int power)
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
		if(power==1||power==2)     
		{
			ChangePwd c=new ChangePwd();
			return c;
		}
		return null;
	}
	public AddPro addpro()
	{
		if(power==2)      
		{
			AddPro a=new AddPro();
			return a;
		}
		return null;
	}
	public DeletePro Deletepro()
	{
		if(power==2)      
		{
			DeletePro d=new DeletePro();
			return d;
		}
		return null;
	}
	public UpdatePro updatepro()
	{
		if(power==2)       
		{
			UpdatePro u=new UpdatePro();
			return u;
		}
		return null;
	}
	public SeletePro seletepro()
	{
		if(power==2)       
		{
			SeletePro s=new SeletePro();
			return s;
		}
		return null;
	}
}
