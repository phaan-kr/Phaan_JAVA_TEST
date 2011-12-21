import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest {

    public static void main(String[] args) 
    {
    	DateTest dateTest = new DateTest();
    	dateTest.updateTest();
    }
    
    public void updateTest()
    {
        Calendar runTime = Calendar.getInstance();
        runTime.setTime(new Date());
        
        /**
         * 
         */
        runTime.set(Calendar.DAY_OF_MONTH, runTime.get(Calendar.DAY_OF_MONTH));//runTime.get(Calendar.DAY_OF_MONTH)+1
        runTime.set(Calendar.HOUR_OF_DAY, runTime.get(Calendar.HOUR_OF_DAY));//+1
        runTime.set(Calendar.MINUTE, runTime.get(Calendar.MINUTE)+10);
        runTime.set(Calendar.SECOND, 0);
        
        String DATE_FORMAT = "MM/dd HH:mm";
        SimpleDateFormat sdf =
            new SimpleDateFormat(DATE_FORMAT);
        
        System.out.println(sdf.format((runTime.getTime())));
    }
    
    public void millisTest()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

//        for(int i =1; i<30; i++)
//        {
        	cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
        	cal.set(Calendar.HOUR_OF_DAY, 0);
        	cal.set(Calendar.MINUTE, 0);
        	cal.set(Calendar.SECOND, 0);
    
        	Calendar cal2 = Calendar.getInstance();
        	
        	long millis = cal.getTimeInMillis() - cal2.getTimeInMillis() ;
        	
        	String test = String.format("%d hour, %d min, %d sec",
        			TimeUnit.MILLISECONDS.toHours(millis),
        			TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
        		    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        		);

//        	time = time/(long)(1000*60*60);
        	
        	System.out.println(test);
        	System.out.println(cal.getTime());
            cal.setTime(new Date());
            
            //       cal.set(cal.YEAR, cal.MONTH, cal.DATE+1)
//          System.out.println(format.format(date));        
//          date.setDate(date.getDate()+2);
//          System.out.println(format.format(date));
//          date.setDate(date.getDate()-30);
//          System.out.println(format.format(date));
    }
    
    public void fileTest()
    {
//    	java.io.File tempFile = new java.io.File("C:\\fileCreateTest.txt");
//    	if(!tempFile.exists()){
//				FileWriter fileOut;
//				try {
//					
//					fileOut = new FileWriter("C:\\fileCreateTest.txt");
//    		        BufferedWriter fileBuff = new BufferedWriter(fileOut);
//    		        fileBuff.write("");	
//    		        fileBuff.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//    		System.out.println("k");
//    	}
////    }
//}
//    }
    }
}