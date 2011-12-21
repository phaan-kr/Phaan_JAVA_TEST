public class CompareOPMLFeed 
{			   
	private static String opmlUrl;
	OPMLParser opmlParser;

	public CompareOPMLFeed (String url) 
	{
		 opmlUrl = url;
	}
		
	public void printInfo() throws Exception
	{			
		opmlParser = new OPMLParser(opmlUrl);
		opmlParser.parse();
		
		if(opmlParser.getFeeds() == null){
			System.out.println("RSSFeed is Empty");
			return;
		}
//		for(int i = 0; i < opmlParser.getFeeds().size(); i++)
//		{
//			System.out.println(opmlParser.getFeeds().get(i).title+"\n"+opmlParser.getFeeds().get(i).link+"\n");
//		}
	}

	public static void main(String[] args) throws Exception {
		
		CompareOPMLFeed opmlReader = new CompareOPMLFeed( "http://165.243.137.39/e720?a=opml");
		opmlReader.printInfo();


	}
}





