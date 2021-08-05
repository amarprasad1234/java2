import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class MyException extends Exception
{  
}
public class prgm4
{	
  	void splitString(String str)
	{
		try
		{
			Pattern pattern = Pattern.compile("/");
	    	Matcher matcher = pattern.matcher(str);
	    	boolean matchFound = matcher.find();
	    	if(!matchFound) 
	      		throw new MyException(); 
	      	else
	      	{
	      		String str1[]=str.split("/");
	      		for(String a:str1)
	      			System.out.println(a +" Index :"+str.indexOf(a));
	      	}
     	}
     	catch(MyException e)
     	{
     		System.out.println("/ Not Found");
     	}
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String str="come/on/bro";
		prgm4 p=new prgm4();
		p.splitString(str);
	}
}