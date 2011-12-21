import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 하루에 한 번씩, 총 3번의 rss feed를 저장.
 * 새로운  feed를 받게 되면 그 이전에 저장된 2개의 feed와 비교.
 * 받아온 feed와 2개의 feed에 없는 항목이 있으면 issue로 생성. 
 * @author seungho83.shin
 *
 */
/**
 * @author seungho83.shin
 *
 */
public class CompareRSSFeed 
{			   
	private static String rssUrl;
	RSSParser lgeUpdateParser;
	ArrayList<LGEUpdateItem> presentList;
	
	/**
	 * 
	 * @param url : 입력받은 rss url.
	 * @param params : issue 생성 및 rssFeed파일이 저장된 디렉터리를 알기 위해 필요한 parameters
	 * @param jiraHome : JIRA System의 jiraHome
	 * @param issueTypes : JIRA System의 IssueType.
	 */
	public CompareRSSFeed (String url) 
	{
		 rssUrl = url;
	}
	
	/**
	 * SAX parser를 이용해서 rssFeed를 받아오는 url의 xml을 parsing, file로 저장.
	 * @throws Exception
	 */
	public void readRss() throws Exception
	{			
		lgeUpdateParser = new RSSParser(rssUrl);
		lgeUpdateParser.parse();
		
		if(lgeUpdateParser.getFeeds() == null)
		{
			System.out.println("RSSFeed is Empty");
			return;
		}
		
		presentList = new ArrayList<LGEUpdateItem>();
		
		for(int i = 0; i < lgeUpdateParser.getFeeds().size(); i++)
		{
			LGEUpdateItem serItem = new LGEUpdateItem(lgeUpdateParser.getFeeds().get(i).title, lgeUpdateParser.getFeeds().get(i).link, getContents(lgeUpdateParser.getFeeds().get(i).content) );
			presentList.add(serItem);
		}

		writeToFile(presentList,"1. READ_PRESENT_RSS");				
		
		ArrayList<LGEUpdateItem> lastList = readFromFile("2. READ_LAST_RSS");
		ArrayList<LGEUpdateItem> beforeLastList = readFromFile("3. READ_BEFORE_LAST_RSS");
		
		createIssueFromRSSFeed(compareToBefore(lastList),compareToBefore(beforeLastList));
		
		renameFile("2. READ_LAST_RSS", "3. READ_BEFORE_LAST_RSS");
		renameFile("1. READ_PRESENT_RSS", "2. READ_LAST_RSS");
		deleteFile("1. READ_PRESENT_RSS");

		System.out.println("\n\"ReadRSSFeed.\"");
	}
		
	/**
	 * 저장된 파일들과 현재 받아온 feed를 비교.
	 * 빈 파일로 명시하지 않은 경우, 다른 내용이 있으면 string으로 저장되어서 반환되고, 그렇지 않을 경우 blank로 반환.
	 * @param time : 저장된 파일을 읽어온 string
	 * @return 저장되지 않은 rss feed
	 */
	private ArrayList<LGEUpdateItem> compareToBefore(ArrayList<LGEUpdateItem> beforeList){
		
		ArrayList<LGEUpdateItem> diffList = new ArrayList<LGEUpdateItem>(); 
		
		if(beforeList != null)
		{
			int k=0;			
			for(int i=0; i<presentList.size(); i++)//한 feed에서 받아오는 내용은 link, title, content 총 3가지 이므로, link(commit으로 고유한 값을 저장)를 비교하기 위해서 1부터 시작, 3을 더함 .
			{
				//outer:
				for(int j=0; j<beforeList.size(); j++)
				{
					if(presentList.get(i).getLink().equals(beforeList.get(j).getLink()))
					{
						break;// outer;
					}
					if(j==beforeList.size()-1)//저장된 파일의 마지막줄
					{				
						LGEUpdateItem serItem = new LGEUpdateItem(lgeUpdateParser.getFeeds().get(k).title, lgeUpdateParser.getFeeds().get(k).link, getContents(lgeUpdateParser.getFeeds().get(k).content));
						diffList.add(serItem);
					}
				}
				k++;
			}
		}
		else
		{
			diffList = null;
		}
		return diffList;
	}
	

	/**
	 * 현재 받아온 feed와 저장되어 있는 2개의 feed를 각각 비교해서 둘 다 없는 경우에는 새로운 issue로 생성.
	 * 비교한 feed중 없는 feed만 각각 string으로 저장되어서 이 메서드로 넘어옴.
	 * 하나라도 있는 경우라면, string으로 저장되지 않기 때문에, 2개의 string에 다른 내용이 있을 경우는 이미 issue로 생성된 것이라고 판단.
	 * 
	 * @param compareToYesterday : 저장되어 있는 파일 중 나중에 받아온 파일을 읽어들인 string.
	 * @param compareToTheDayBefore : 저장되어 있는 파일 중 먼저 받아온 파일을 읽어들인 string.
	 */
	private void createIssueFromRSSFeed(ArrayList<LGEUpdateItem> compareToYesterdayList, ArrayList<LGEUpdateItem> compareToDayBeforeList) {
			
		if(compareToYesterdayList == null && compareToDayBeforeList == null)// 이전 파일들이 둘 다 빈 파일일 경우
		{
			for(LGEUpdateItem presentItem : presentList)
			{
				System.out.println(presentItem.getTitle() + "\n"
						+ presentItem.getLink() + "\n"
						+ presentItem.getContent() + "\n");
			}
		}
		else if(compareToYesterdayList == null)
		{																				// 하나만 빈 파일인 경우.
			for(LGEUpdateItem dayBeforeItem : compareToDayBeforeList)
			{
				System.out.println("empty yesterday rss feed.");
			}	
		}
		else if(compareToDayBeforeList == null)
		{
			for(LGEUpdateItem yesterdayItem : compareToYesterdayList)
			{
				System.out.println("empty daybefore rss feed.");
			}	
		}
		else
		{
			for(LGEUpdateItem yesterdayItem : compareToYesterdayList)// 두 파일에 모두 feed가 저장되어 있으면
			{
				for(LGEUpdateItem dayBeforeItem : compareToDayBeforeList)
				{
					if(yesterdayItem.getLink().equals(dayBeforeItem.getLink()))
					{
							System.out.println(yesterdayItem.getTitle() + "\n"
									+ yesterdayItem.getLink() + "\n"
									+ yesterdayItem.getContent() + "\n");
					}
				}
			}
		}	
		
	}


	/**
	 *  읽어들인 rss feed를 저장.
	 * @param contents : 저장될 feed.
	 * @param RSS_CONTENTS : 저장될 파일 명
	 */
    public void writeToFile(ArrayList<LGEUpdateItem> serItemList, String RSS_CONTENTS) 
    {        
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try 
		{
			fos = new FileOutputStream(fileName(RSS_CONTENTS));
			out = new ObjectOutputStream(fos);
			out.writeObject(serItemList);
			out.close();
			System.out.println("Object Persisted");
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
    }
	
    /**
     * 파일로 저장되어 있는 rss feed를 읽어옴 
     * @param time : 저장되어 있는 파일 명.
     * @return 읽어온 rss feed.
     */
    public ArrayList<LGEUpdateItem> readFromFile(String time){  	 
        ArrayList<LGEUpdateItem> serItem = null;

		try 
		{
			File newFile = new File(fileName(time));
			if(!newFile.exists())
			{
				return null;
			}
			else
			{
		        FileInputStream fis = null;
				ObjectInputStream in = null;
				fis = new FileInputStream(fileName(time));
				in = new ObjectInputStream(fis);
				serItem = (ArrayList<LGEUpdateItem>) in.readObject();//Object 저장 할 시에 ArrayList<SerItem>형으로 저장했으므로
				in.close();
			}
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
		}
        return serItem;
      }
        
    private void renameFile(String currentTime, String destinationTime)
    {	
    	deleteFile(destinationTime);
    	
		File currentFile = new File(fileName(currentTime));
		File destinationFile = new File(fileName(destinationTime));
		currentFile.renameTo(destinationFile);
    }
    
    private void deleteFile(String destinationTime)
    {
		File newFile = new File(fileName(destinationTime));
		if(newFile.exists())
		{
			newFile.delete();
		}
    }
    /**
     * 디렉터리 위치를 포함한 파일 명
     * @param time : 파일 명
     * @return 파일명을 반환
     */
	private String fileName(String time)
    {
        return time;
    }
	
	/**
	 *  JIRA Issue의 description 부분에 link와 <content:encoded> 태그에 있는 내용을 보여주기 위해 content:encoded의 내용을 가져옴
	 * @param content: <conetent:encoded>태그에 있는 string
	 * @return description에 들어갈 content
	 */
	private String getContents(String content){		
		StringBuilder description = new StringBuilder();
		description.append(content.substring(content.indexOf("<pre>")+6, content.indexOf("</pre>")-1).replace("\n", "___"));// link와 content를 구분하기 위해서 사용.
		return description.toString();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		CompareRSSFeed rssReader = new CompareRSSFeed( "http://git.omapzoom.org/?p=platform/frameworks/base.git;a=rss");
		rssReader.readRss();
		
	}
}





