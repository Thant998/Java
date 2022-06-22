import java.text.DateFormat; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Locale;

public class DateToStringDemo{
	public static class DateUtils { 
		private static final DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
		public static synchronized Date toDate(String date) throws ParseException { 
			return format.parse(date); 
		} 
	}
public static void main(String args[]) {
	String string = "February 6, 2014"; 
	Date date; 
	try { 
		date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(string); 
		System.out.println(date); 
	} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
	 String source = "01/09/2014"; 
	 try { 
		date = new SimpleDateFormat("MM/dd/yyyy").parse(source); 
		System.out.println(date); 
		 } catch (ParseException e) {
			 e.printStackTrace();
		 } 
	String birthday = "04 JAN 2014 20:30"; 
	try {
	 date = new SimpleDateFormat("dd MMM yyyy HH:mm").parse(birthday); 
	 System.out.println(date);
	 } catch (ParseException e) { 
		e.printStackTrace(); 
	} 
	 String weddingday = "30-01-2011";
	 try { 
	date = new SimpleDateFormat("dd-mm-yyyy").parse(weddingday); 
	System.out.println(date); 
	 } catch (ParseException e) {
		 e.printStackTrace();
}
}
}

