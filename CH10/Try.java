import java.util.Date;
import java.util.Calendar;
public class Try {
	public static void main(String[] args){
		Date t = new Date();
		System.out.println(String.format("%tc",t));
		Calendar c = Calendar.getInstance();
		c.set(2017,1,1);
		System.out.println(c.getTimeInMillis());
	}
}
