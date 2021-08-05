import java.io.*;
import java.util.regex.*;
class EmpCodeException extends Exception
{
	public EmpCodeException(String s)
	{
		super(s);
	}
}

class BasicException extends Exception
{
	public BasicException(String s)
	{
		super(s);
	}
}

class JobException extends Exception
{
	public JobException(String s)
	{
		super(s);
	}
}

public class Q9
{

BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  String eno,job,name;
 	 float basic,da,hra,net;
	void getData()
	{
		
		try
		{
		Enovalidate en=new Enovalidate(); 
		System.out.println("Enter employee number: ");
		eno=br.readLine();
		
		en.isValid(eno);
		
		System.out.println("Enter employee Name: ");
		name=br.readLine();
		
		
		System.out.println("Enter employee designation:");
		job=br.readLine();
		
		
		if(!(job.matches("analyst")||job.matches("manager")||job.matches("clerk")))
			throw new JobException("Enter valid Designation(manager,analyst or clerk )");
			
		
		System.out.println("Enter basic salary :");
		basic=Float.parseFloat(br.readLine());

		if(basic>=2000 && basic <=7000)
			throw new BasicException("Salary shouldn't be between 2000 and 7000");
		
		calculate();
		disp();


		}
		catch(EmpCodeException e)
		{
			System.out.println(e);
		}
		catch(JobException e)	
		{
			System.out.println(e);
		}
		catch(BasicException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
	void calculate()
	{
		da=0.45f*basic;
		hra=0.15f*basic;
		net=basic+da+hra;
	}
	void disp()
	{
	System.out.println("\nEmployee Details\n Employee number: "+eno+"\nName: "+name+"\nDesignation: "+job+"\n Basic salary: "+basic+"\nDA: "+da+"\nHRA: "+hra+"\nNet Salary: "+net);
	}
	
	
public static void  main(String[] args)throws IOException
{
	Q9 p=new Q9();
	p.getData();
	
}
}

class Enovalidate
{
	public static void isValid(String eno)throws EmpCodeException
	{
		if(!((eno.length()>=5)	&&(eno.length()<=10)))
		{
			throw new EmpCodeException("Employee number must contain atleast 5 charecters");
		}
		if(eno.contains(" "))
		{
			throw new EmpCodeException("Employee number shouldn't include any space");
		}
		if(true)
		{
			int cnt=0;
			for(int i=0;i<=9;i++)
			{	String str1=Integer.toString(i);
				if(eno.contains(str1)){
					cnt=1;
			} 
			}
			if(cnt==0)
				throw new EmpCodeException("Employee number should contain atleast one number");
		}
		if(true)
		{
			int cnt=0;
			for(int i=65;i<=90;i++){
				char c=(char)i;
				String str=Character.toString(c);
				if(eno.contains(str)){
					cnt=1;
				}
			}
			if(cnt==0)
			{
				throw new EmpCodeException("Employee number should contain atleast one Capital letter");
			}
		}
	}
			
}
		
