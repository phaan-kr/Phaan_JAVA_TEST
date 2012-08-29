import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * new File로 읽어오고
 * new BufferedReader(file),
 * while(line = br.readLine() != null)
 * 	line..
 * 
 * */
public class LoadFiles {
	String DIRECTORY_PATH="C:\\workspace\\RSSreader\\";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 디렉토리에 접근
        File dir = new File("C:\\workspace\\RSSreader\\ProviderInfo.java");
 
        // 디렉토리 내에서 파일명에 aa가 포함되고 확장자가 txt인 파일 필터링
        File[] files = dir.listFiles();
        
        LoadFiles loadFiles = new LoadFiles();
        
        // 결과 출력
        for(int i = 0 ; i < files.length ; i++) 
        {
            System.out.println(files[i].getName());
            loadFiles.writeToFile(loadFiles.readFromFile(files[i]), files[i].getName());
        }

        deleteDirectory(dir);
	}
	
    public static boolean deleteDirectory(File path) {
        if(!path.exists()) {
            return false;
        }
 
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectory(file); //재귀 -- 폴더랑 파일 섞여 있을 경우. 폴더에 들어가면 파일리스트를 보고 없으면 폴더 삭제할테니깐.
            } else {
                file.delete();
            }
        }         
        
        return path.delete();         
    }
    
    public void writeToFile(String contents, String RSS_CONTENTS) 
    {        
    	try
    	{
	    	FileWriter fileOut = new FileWriter(fileName(RSS_CONTENTS));
	        BufferedWriter fileBuff = new BufferedWriter(fileOut);
	        fileBuff.write(contents);	
	        fileBuff.close();
	        fileOut.close();
         } 
    	catch (IOException e) 
    	{
			e.printStackTrace();
    	}
    }
    
    public String readFromFile(File file){  	 
        String sCurrentLine = null;    
        String readFile = "";
    	try 
        {         
        	BufferedReader br =  new BufferedReader(new FileReader(file));       
            while ((sCurrentLine = br.readLine()) != null) 
            {
            	readFile += sCurrentLine+"\n";
            }
            br.close();
        } 
        catch (IOException e) 
        {   
          e.printStackTrace();     
        }    
        return readFile;
      }
    
	private String fileName(String time)
    {
        return DIRECTORY_PATH + time;
    }
}
