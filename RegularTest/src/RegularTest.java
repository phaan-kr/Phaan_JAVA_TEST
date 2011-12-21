import java.util.regex.Pattern;


public class RegularTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		boolean[] b = {Pattern.matches("[a-z]*-[a-z]*-[a-z][\\d]+-[a-z]*-[a-z]*-[a-z]*_[\\d]+", "gingerbread-tegra-k32-lge-cappuccino-xmm_20110609"),  
//							 Pattern.matches("[A-Za-z]*.[A-Z][\\d]+\\.[\\d]+\\.[\\d]+\\.[\\d]+.*", "android-1.0"),
//					 		 Pattern.matches("[a-z]*-[a-z]*[\\d]+-[a-z]*-[a-z]*-[a-z]*_[\\d]*", "gingerbread-omap4-lge-cappuccino-xmm_20110609"),
//					 		 Pattern.matches("[a-z]*-[a-z]*-[a-z][\\d]+-[a-z]*-[a-z]*-[a-z]*_[\\d]+", "gingerbread-tegra-k32-lge-cappuccino-xmm_20110609")};
		
		boolean[] b = {Pattern.matches("ssh://.*/.*", "ssh://165.243.137.39:29457")};
		
		String test = "ssh://165.243.137.39:29457/lge_omap3";
		String test1 = test.replace("ssh://", "");
		
		if(test1.contains("/"))
		{

			System.out.println(test1.indexOf("/"));
			System.out.println(test1.length());
			if(test1.indexOf("/")!=test1.length()-1)
			{
				System.out.println(test1.substring(test1.indexOf("/")+1, test1.length()));
			}
		}
		
		System.out.println();
		
		for(int i=0; i<b.length; i++)
		{
			if(b[i])
			{
				System.out.println("pattern["+i+"] : true");
			}
			else
			{
				System.out.println("pattern["+i+"] false");
			}
		}
		
		

	}
	

}
