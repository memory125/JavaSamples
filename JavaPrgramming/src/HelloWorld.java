import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.*;
import java.util.*;

public class HelloWorld {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		LocalDateTime _localDateTime = LocalDateTime.now();
		LocalTime _localTime = LocalTime.now();
		
		// math
		double a = Math.pow(2.0, 3.0);
		double b = Math.sin(6.66);
		double c = Math.cos(3.0);
		double d = Math.log(5.6);
		
		//util
		ArrayList<String> _arrayList = new ArrayList<String>();  
		LinkedList<String> _list = new LinkedList<String>();
		
		for (int i = 0; i <= 100; i++)
		{
			String _strContent = String.format("ID %d", i);
			
			_arrayList.add(_strContent);
			_list.add(_strContent);
		}
		
		// format
		String _strLocalDateTime = 	String.format("Current Date is %s", _localDateTime.toString());
		String _strLocalTime = 	String.format("Current Time is %s", _localTime.toString());
		String _strMath = String.format("a = %f, b = %f, d = %f, d = %f", a, b, c, d);
	
		
		// out
		System.out.println(_strLocalDateTime);
		System.out.println(_strLocalTime);
		System.out.println(_strMath);
		
		System.out.println("ArrayList Size: " + _arrayList.size());
		System.out.println("LinkedList Size: " + _list.size());
		
		
		// read file
		
		/*try
		{
			File _file = new File(".\\TestFile.txt");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		
		System.out.println("Java File Reading Test...... ");
		
		File _file = new File(".\\TestFile.txt");	
		if (_file.exists())
		{
			String _fileStrContents = txt2String(_file);
			System.out.println("File contents are: " + _fileStrContents);
		}
		else
		{
			System.out.println("File is not exist! ");
		}
		
	}
	
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader _bufReader = new BufferedReader(new FileReader(file));                     //构造一个BufferedReader类来读取文件
            String _lineContent = null;
            while((_lineContent = _bufReader.readLine()) != null){                                     //使用readLine方法，一次读一行
                result.append(System.lineSeparator() + _lineContent);
            }
            _bufReader.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
