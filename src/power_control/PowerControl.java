package power_control;

public class PowerControl {
	
	private int power;

	public PowerControl(int power)
	{
		this.power=power;
	}
	public Login login()
	{
		if(power==1||power==2)       //��ͨ�û�
		{
			Login l=new Login();
			return l;
		}
		return null;
	}
	public Register register()
	{
		if(power==1||power==2)       //��ͨ�û�
		{
			Register r=Register.getInstance();
			return r;
		}
		return null;
	}
	public ChangePwd changepwd()
	{
		if(power==1||power==2)       //��ͨ�û�
		{
			ChangePwd c=new ChangePwd();
			return c;
		}
		return null;
	}
	public AddPro addpro()
	{
		if(power==2)       //��ͨ�û�
		{
			AddPro a=new AddPro();
			return a;
		}
		return null;
	}
	public DeletePro Deletepro()
	{
		if(power==2)       //��ͨ�û�
		{
			DeletePro d=new DeletePro();
			return d;
		}
		return null;
	}
	public UpdatePro updatepro()
	{
		if(power==2)       //��ͨ�û�
		{
			UpdatePro u=new UpdatePro();
			return u;
		}
		return null;
	}
	public SeletePro seletepro()
	{
		if(power==2)       //��ͨ�û�
		{
			SeletePro s=new SeletePro();
			return s;
		}
		return null;
	}
}
