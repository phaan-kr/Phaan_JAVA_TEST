import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class RSSParser extends DefaultHandler
{  
    private String urlString;
    private StringBuilder text;
    private Feed item;
    private ArrayList <Feed> items;
    
    /**
     * 주어진 url의 xml을 parsing. 
     * @param url : xml을 받아올 url
     */
    public RSSParser(String url)
    {
        this.urlString = url;
        this.text = new StringBuilder();
    }
   
    /**
     * SAX parser를 이용해 url에서 xml을 읽어들여서 parsing
     * @throws Exception
     */
    public void parse() throws Exception
    {
        SAXParserFactory spf = null;
        SAXParser sp = null;

        try
        {       	
	        String result = "";
	        StringBuffer out = new StringBuffer();
	        
	        while(result.equals(""))//url의 xml을 읽어오지 못하면 blank string을 가져오게 되는데, 읽어올 때까지 반복하기 위해서 사용.
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
	            if (urlInputStream != null) urlInputStream.close();
	        }

           
        	FileWriter fileOut = new FileWriter("result.xml");
        	BufferedWriter fileBuff = new BufferedWriter(fileOut);
	       fileBuff.write(result);	
	       fileBuff.close();
	       fileOut.close();
            
           spf = SAXParserFactory.newInstance();
           if (spf != null)
            {
                sp = spf.newSAXParser();
                File rssFeed = new File("result.xml");
                sp.parse(rssFeed, this);
            }
        }       
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
    }
   
    /**
     * DefaultHandler에서 상속받은 method
     * 시작태그일 때 동작을 기술
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
    	if (qName.equalsIgnoreCase("item"))
        {
            item = new Feed();
            addItem(item);
        }
    }
   
    /**
     * DefaultHandler에서 상속받은 method
     * 닫는태그일 때의 동작을 기술
     */
    public void endElement(String uri, String localName, String qName)
    {      
        if (qName.equalsIgnoreCase("item"))
        {
            item = null;
        }
        else if (qName.equalsIgnoreCase("title"))
        {
            if (this.item != null)
        	{
        		this.item.title = text.toString().trim();
        	}
        }
        else if (qName.equalsIgnoreCase("link"))
        {
            if (item != null) 
        	{
        		item.link = text.toString().trim();
        	}
        }              
        else if (qName.equalsIgnoreCase("content:encoded"))
        {
            if (item != null) 
            {
            	item.content = text.toString().trim();
            }
        } 
       
        text.setLength(0);
    }
    
    /**
     * startElement와 endElement 사이에 있는 문자열들을 반환.
     */
    public void characters(char[] ch, int start, int length)
    {
        text.append(ch, start, length);
    }
   
    /**
     * rss feed list에 읽어온 feed를 add.
     * @param feed : rss feed들의 list
     */
    public void addItem(Feed feed)
    {
        if (getFeeds() == null)
        {
            items = new ArrayList<Feed>();
        }
        getFeeds().add(feed);
    }
   
	/**
	 * 
	 * @return 읽어온 feedlist를 반환 
	 */
	public ArrayList <Feed> getFeeds() {
		return items;
	}
	
	/**
	 * 하나의 feed를 읽어올 때 IRIS에서 필요한 tag들을 저장.
	 * 현재 title, link, content:encoded tag의 내용들을 사용함.
	 * @author seungho83.shin
	 *
	 */
    public class Feed
    {
        public  String title;
        public  String link;
        public String content; 
    }
}