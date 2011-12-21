import java.io.File;
import java.util.ArrayList;


public class SortTest {

	public static void main(String[] args)
	{
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PathPermission.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/CursorEntityIterator.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentResolver.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderResult.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/SearchRecentSuggestionsProvider.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/IContentProvider.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/CursorWindow.h");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentQueryMap.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/database");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteDebug.cpp");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/UriMatcher.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteQuery.cpp");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/ProviderInfo.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/UriMatcher.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentService.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProvider.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/ResolveInfo.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteQuery.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentValues.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PermissionGroupInfo.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/external/sqlite.git;a=rss");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteDatabase.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteDatabase.cpp");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/CursorWindow.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteCompiledSql.cpp");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_CursorWindow.cpp");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PermissionInfo.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/CursorWindow.h");
		urls.add("http://android.git.kernel.org/?p=platform/external/sqlite.git;a=rss");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteStatement.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteStatement.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteDebug.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteProgram.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/sqlite3_exception.h");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_CursorWindow.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PermissionInfo.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentQueryMap.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentResolver.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/SearchRecentSuggestionsProvider.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/IContentProvider.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/AsyncQueryHandler.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderResult.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/ProviderInfo.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentValues.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteCompiledSql.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentService.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/jni/CursorWindow.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PermissionGroupInfo.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/android_database_SQLiteProgram.cpp");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/ResolveInfo.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderOperation.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/pm/PathPermission.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderOperation.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentInsertHandler.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/CursorEntityIterator.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/EntityIterator.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderClient.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderNative.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/DefaultDataHandler.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/DefaultDataHandler.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentUris.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/jni/sqlite3_exception.h");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentInsertHandler.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/Entity.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProvider.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/EntityIterator.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/AsyncQueryHandler.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/Entity.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderNative.java");
		urls.add("http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentUris.java");
		urls.add("https://www.codeaurora.org/gitweb/quic/la/?p=platform/frameworks/base.git;a=rss;f=core/java/android/content/ContentProviderClient.java");
		
		
		
		
		
		
		
		for(int i =0; i<urls.size(); i++)
		{
			String subOrigin = ((urls.get(i).replace("http:/", "")).replace("https:/", "")).replace("/www.", "/");
			subOrigin = (subOrigin.replace(":", "_")).replace("/", "_").replace("\\", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace("?", "_");
			 
	        File newDir = new File("export" + File.separator + "DBS" + File.separator + "Database"+File.separator+subOrigin);
	        if(!newDir.exists())
	        {
	        	newDir.mkdirs();
	        }
		}
        
//		String subOrigin = ((getOrigin().replace("http:/", "")).replace("https:/", "")).replace("/www.", "/");
//		subOrigin = (subOrigin.replace(":", "_")).replace("/", "_").replace("\\", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace("?", "_");
//		
//		 String[] splitOrigin = getOrigin().split(";");
//		 String subOrigin = splitOrigin[0].substring(splitOrigin[0].lastIndexOf("/")+1);
//		 
//		 for(int i =1; i<splitOrigin.length; i++)
//		 {
//			 String[] temp = splitOrigin[i].split("=");
//			 if(!temp[1].equals("rss"))
//			 {
//				 temp[1] = temp[1].replace("/", "_");
//				 subOrigin += "_"+temp[1];
//			 }
//		 }
		 
//		 System.out.println(subOrigin);
		 
//		ArrayList<Item> itemList = new ArrayList<Item>();
//		
//		itemList.add(new Item("WCT", "Compliance"));
//		itemList.add(new Item("WCT", "Compliance"));
//		itemList.add(new Item("WCT", "JavaScript"));
//		itemList.add(new Item("WCT", "Web UX"));
//		itemList.add(new Item("WCT", "Network"));
//		itemList.add(new Item("DBS", "Database"));
//		itemList.add(new Item("DBS", "Database"));
//		itemList.add(new Item("RIP", "Call/Network Registration"));
//		itemList.add(new Item("RIP", "SIM"));
//		itemList.add(new Item("RIP", "Message"));
//			
//		boolean sorted = false;
//		while(!sorted)
//		{
//			sorted = true; 
//			for(int i =0; i<itemList.size()-1; i++)
//			{
//				if(itemList.get(i).getProjectKey().compareTo(itemList.get(i+1).getProjectKey()) > 0)
//				{
//					itemList.add(i,itemList.get(i+1));
//					itemList.remove(i+2);
//				    sorted = false;
//				} 
//			}
//		}
//		
//		sorted = false;
//		while(!sorted)
//		{
//			sorted = true; 
//			for(int i =0; i<itemList.size()-1; i++)
//			{
//				if(itemList.get(i).getProjectKey().compareTo(itemList.get(i+1).getProjectKey()) == 0)
//				{
//					if(itemList.get(i).getModuleName().compareTo(itemList.get(i+1).getModuleName()) > 0)
//					{
//						itemList.add(i,itemList.get(i+1));
//						itemList.remove(i+2);
//					    sorted = false;
//					}
//				} 
//			}
//		}
//		
//		for(Item i : itemList)
//		{
//			System.out.println("ProjectKey: "+i.getProjectKey()+", "+"ModuleName: "+i.getModuleName());
//		}
//		
	}
	
//	public static String getOrigin(ArrayList<String> urls)
//	{
//		return urls;//"http://android.git.kernel.org/?p=platform/frameworks/base.git;a=rss;f=core/java/android/database";
//	}
}
