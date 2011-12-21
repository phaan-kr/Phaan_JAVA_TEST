import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;


public class HTMLCleanerTest {

	static Map<String, Set<String>> repoList;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CleanerProperties props = new CleanerProperties();
		 
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		
		try 
		{
			TagNode tagNode =new HtmlCleaner(props).clean(new URL("http://google.com/"));
			
//			new PrettyXmlSerializer(props).writeToFile(tagNode, "chinadaily.xml", "utf-8");
			
			repoList = new TreeMap<String, Set<String>>();
			
			String projectName = null;
			
			//String[][] project_branch_list; 
			Object[] objArray = tagNode.evaluateXPath("//tr");
			for(int i =1; i<objArray.length; i++) //Object obj: objArray
			{
				Set<String> branchList = new TreeSet<String>();
				//project_branch_list= new String[objArray.length][];
				TagNode t = (TagNode)objArray[i];
				
//				t.getChildren().size();
//				String a = t.getText().toString().replace(" ", ""); 
//				if(!a.equals("\r\n"))
				
				if(t.getChildren().size()==5)
				{
					TagNode firstTDTag = (TagNode)t.getChildren().get(0);
					TagNode secondTDTag = (TagNode)t.getChildren().get(1);
										
					projectName = firstTDTag.getText().toString().replace("&nbsp;", " ").replace("\r\n", "").trim();
										
					for(int k = 0; k<secondTDTag.getChildren().size(); k++)
					{
						String element = secondTDTag.getChildren().get(k).toString().trim();
//						System.out.println(secondTDTag.getChildren().get(k).toString().trim());
						if(!element.equals("br") && !element.equals(""))
						{
							branchList.add(element);
						}	
					}

					repoList.put(projectName, branchList);
//					//project_branch_list[i-1][]
				}
				else if(t.getChildren().size()==4)
				{
					TagNode firstTDTag = (TagNode)t.getChildren().get(0);
					
					for(int k = 0; k<firstTDTag.getChildren().size(); k++)
					{
						String element = firstTDTag.getChildren().get(k).toString().trim();
						if(!element.equals("br") && !element.equals(""))
						{
							branchList = repoList.get(projectName);
							branchList.add(element);
						}	
					}
				}		
			}
			
			System.out.println(repoList.keySet().size());
			for(String repository:repoList.keySet())
			{
				System.out.println("ProjectName: "+repository);
				Iterator<String> branches =  repoList.get(repository).iterator();

//				while(branches.hasNext())
				// {
				// System.out.println("BranchName: "+branches.next());
				// }
				// System.out.println();
			}
		} catch (XPatherException e){
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Set<String> getProjectName() {
		return repoList.keySet();
	}
	
	public Set<String> getBranches(String projectName) {
		return repoList.get(projectName);
	}

}
