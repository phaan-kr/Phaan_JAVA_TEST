import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author seungho83.shin
 *DefaultHander를 상속받아서 Parsing하는 class
 */
public class OPMLParser extends DefaultHandler
{  
    private String urlString;
    private StringBuilder text;
    private Feed item;
    private ArrayList <Feed> items;
    
    public OPMLParser(String url)
    {
        this.urlString = url;
        this.text = new StringBuilder();
    }
   
    public void parse() throws Exception
    {
        try
        {       	
	        String result = "";
	        StringBuffer out = new StringBuffer();
	        
	        while(result.equals(""))
	        {            
	            InputStream urlInputStream = null;
	            URL url = new URL(urlString);
	            
	            URLConnection conn = url.openConnection();
	            conn.connect();          
	            urlInputStream = url.openConnection().getInputStream();
	
	        	byte[] b = new byte[1024];
	            for (int n; (n = urlInputStream.read(b)) != -1;) 
	            {
	                out.append(new String(b, 0, n));
	            }
	            result = out.toString();

	            if (urlInputStream != null)
	            { 
	            	urlInputStream.close();
	            }
	         }
	        
        	 FileWriter fileOut = new FileWriter("result.xml");//resultDirectory+
        	 BufferedWriter fileBuff = new BufferedWriter(fileOut);
	         fileBuff.write(result);	

	         fileBuff.close();
	         fileOut.close();
	         
	         SAXParserFactory spf = null;
	         SAXParser sp = null;
             spf = SAXParserFactory.newInstance();
             if (spf != null)
             {
                sp = spf.newSAXParser();//saxParserFactory에서 saxParser를 만든다.
                File rssFeed = new File("result.xml");//없으면 생성됨.
                sp.parse(rssFeed, this);//file이랑 handler
                rssFeed.delete();
             }
        }       
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
    }
   
    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     * xml 시작태그일 경우에 , qName(qualified)-- tag이름
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
    	if (qName.equalsIgnoreCase("outline") && attributes.getValue(3) != null)
        {
            item = new Feed();
            addItem(item);
            
        	System.out.println("attr value: " +attributes.getValue(3));

        }

    }
   
    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     *xml  끝나는 tag일 경우에 
     */
//    public void endElement(String uri, String localName, String qName)
//    {      
//        if (qName.equalsIgnoreCase("item"))
//        {
//            item = null;
//        }
//        else if (qName.equalsIgnoreCase("title"))
//        {
//        	
//            if (this.item != null) this.item.title = this.text.toString().trim();
//        }      
//        else if (qName.equalsIgnoreCase("link"))
//        {
//            if (item != null) item.link = text.toString().trim();
//        }              
//        else if (qName.equalsIgnoreCase("content:encoded"))
//        {
//            if (item != null) item.content = text.toString().trim();
//        } 
//       
//        text.setLength(0);
//    }
   
    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     * 태그 사이의 character 전체
     */
    public void characters(char[] ch, int start, int length)
    {
        text.append(ch, start, length);
    }
   

    public void addItem(Feed feed)
    {
        if (getFeeds() == null)
        {
            setFeeds(new ArrayList<Feed>());
        }
        getFeeds().add(feed);
    }
   
	public void setFeeds(ArrayList<Feed> feeds) {
		this.items = feeds;
	}

	public ArrayList <Feed> getFeeds() {
		return items;
	}
	
    public class Feed
    {
        public  String title;
        public  String link;
        public String content; 
    }
}