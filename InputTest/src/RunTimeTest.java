import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
	
public class RunTimeTest {

        public static void main(String[] args)
        {
        	Test2();
        }
                
        public static void Test2() 
        {
        	File wd = new File("/home/irismanager/cappuccino2.3/");
//        	System.out.println(wd);
        	Process proc = null;
        	try {
        		proc = Runtime.getRuntime().exec("/bin/bash", null, wd);
        	}
        	catch (IOException e) {
        	   e.printStackTrace();
        	}
        	if (proc != null) 
        	{        	    	
        	   BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        	   PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
        	   out.println("repo sync");
        	   out.println("repo forall -c \"git tag\"");
        	   out.println("exit");
        	   try {
        		   ArrayList<String> allTags = new ArrayList<String>(); 
        	      String line;
        	      while ((line = in.readLine()) != null) {
        	    	  System.out.println(line);
        	    	  allTags.add(line);
        	      }
        	      ArrayList<String> tags = new ArrayList<String>();
        	      tags.add(allTags.get(0));
        	      
        	      for(String readTag : allTags){
        	    	  boolean isExist = false;
        	    	  for(String tagList : tags){
        	    		  if(readTag.equals(tagList)){
        	    			  isExist = true;
        	    			  break;
        	    		  }

        	    	  }
        	    	  if(!isExist)
        	    	  {
        	    		 tags.add(readTag);  
        	    	  }
    	    		  
        	      }
        	      for(String tag : tags)
        	      {
//        	    	  System.out.println(tag);
        	      }
        	     

        	      proc.waitFor();
        	      in.close();
        	      out.close();
        	      proc.destroy();
        	   }
        	   catch (Exception e) {
        	      e.printStackTrace();
        	   }
        	}
        }
        
        public static void Test1()
        {
        	try
	        {
	        	String comstr = "ls -l";
	        	String [] command = { "/bin/bsh", "-c", comstr }; //리눅스에서
	        	//String [] command = { "/bin/csh", "-c", comstr }; // Unix에서
	        	//String [] command = { "command.com", "/c", comstr }; // 윈도우에서
	
	        	Process proc = Runtime.getRuntime ( ).exec ( command );
	        	proc.waitFor ( );
	        	
	        	if ( proc.exitValue ( ) != 0 )
	        	{
		        	BufferedReader err = new BufferedReader ( new InputStreamReader ( proc.getErrorStream ( ) ) );
		        	while ( err.ready ( ) )
		        	System.out.println ( err.readLine ( ) );
		        	err.close ( );
	        	}
	        	else
	        	{
		        	BufferedReader out = new BufferedReader ( new InputStreamReader ( proc.getInputStream ( ) ) );
		        	while ( out.ready ( ) )
		        	System.out.println ( out.readLine ( ) );
		        	out.close ( );
	        	}
	
	        	proc.destroy ( );
        	}
        	catch ( Exception e ) { System.out.println ( e ); }
        }
        
        
        public void InteractiveTest() 
        {
        	// 반드시 배열로 해야한다. 문자열로 하면 단지 전체를 하나의 프로그램으로 인식한다.
        	String [] command = { "ping", "203.252.134.126" };
        	try
        	{
	        	Process p = Runtime.getRuntime ( ).exec ( command );
	        	byte [] msg = new byte [128];
	        	int len;
	
	        	while ( ( len = p.getInputStream ().read ( msg ) ) > 0 )
	        	System.out.print ( new String( msg, 0, len ) );
	
	        	String rs = " ";
	        	byte [] rb = new byte [] { (byte)' ' } ; //rs.getBytes();
	        	OutputStream os = p.getOutputStream ( );
	        	os.write ( rb );
	        	os.close ( );
        	}
        	catch ( Exception e ) { e.printStackTrace ( ); }
        }
        
        public String readOutput()
        {
        	String command = "ls";
        	String data = null;
        	StringBuffer strbuf = new StringBuffer ( );
        	BufferedReader br = null;
        	try
        	{ Process proc = Runtime.getRuntime ( ).exec ( command );
        	br = new BufferedReader ( new InputStreamReader ( proc.getInputStream ( ) ) );
        	String line;
        	while ( ( line = br.readLine ( ) ) != null )
        	strbuf.append ( line + " " );
        	br.close ( );
        	}
        	catch ( Exception e ) { System.out.println ( e ); }
        	data = strbuf.toString ( );
        	
        	return data;
        }
        public void LinuxTest()
        {
        	try
        	{
	        	String comstr = "chmod 777 test.txt";
	        	String [] command = { "/bin/bsh", "-c", comstr };
	
	        	Process proc = Runtime.getRuntime ().exec ( command );
	        	proc.waitFor ( );
	
	        	if ( proc.exitValue ( ) != 0 )
	        	System.out.println ( "에러..." );
	
	        	proc.destroy ( );
	       	}
	        catch ( Exception e ) 
	        { 
	        	System.out.println ( e ); 
	        }
        }


        public void WindowTest()
        {
            try
            {
                String [] cmd = {"cmd.exe","/c","dir"} ;
                Process m ;
                String S = "" ;

                m = Runtime.getRuntime().exec(cmd) ;

                BufferedReader in =
                new BufferedReader(new InputStreamReader(
                m.getInputStream()));

                while((S=in.readLine()) != null)
                {
                        System.out.println(S) ;
                }
            }
            catch(Exception ex)
            {
                    ex.printStackTrace () ;
            }
        }
        
        public void StringTest() 
        {
        	// Unix에서
        	String [] command = { "/bin/csh", "-c", "finger | grep -v 639" };
        	// 윈도우에서
//        	String [] command = { "command.com", "/c", "finger | grep -v 639" };
        	//getInputStream ( ) 스트림으로 결과값을 받아올 때 형변환해서 받을 수 없다.
        	
            Process proc ;

            try
            {
				proc = Runtime.getRuntime().exec(command) ;
	        	String data = "";
	        	BufferedReader out = new BufferedReader ( new InputStreamReader ( proc.getInputStream ( ) ) );
	        	data = out.readLine ( ); //int count = Integer.parseInt ( out.readLine ( ) );는 안된다.
	        	out.close ( );
	        	int count = Integer.parseInt ( data );
			} 
            catch (Exception e)
			{
				e.printStackTrace();
			}
        }
        
        
        
        /**
         * 5.1 프로세스의 생성 및 종료
------------------------------------------------------------------------
- “Runtime runtime = Runtime.getRuntime();”: 런타임 객체를 생성합니다.
- “Process p = runtime.exec(“프로그램경로명”);”: exec 메소드를 이용하여 프로세스를 생성합니다.
- “p.waitFor();”: 자식 프로세스가 종료될 때까지 기다립니다.
- “p.destroy();”: 부모 프로세스에서 자식 프로세스를 강제로 종료시킵니다.
- “System.exit(0);”: 부모 프로세스만 종료되고 자식 프로세스는 계속 실행됩니다.
------------------------------------------------------------------------

5.2 Runtime 클래스가 제공해 주는 주요 메소드
------------------------------------------------------------------------
- public static Runtime getRuntime(): 현재 실행되고 있는 자바 애플리케이션과 관련된 런타임 객체를 리턴해 줍니다.
- public void exit(int status): 현재 자바 가상머신을 종료합니다. status 매개변수는 종료시의 상태값을 나타내며,
일반적으로 0 이외의 값은 비정상적으로 종료되었음을 의미합니다.
- public Process exec(String command) throws IOException: 주어진 명령어를 독립된 프로세스로 실행시켜 줍니다.
exec(command, null)와 같이 실행시킨 것과 같습니다.
- public Process exec(String command, String envp[]) throws IOException:
주어진 명령어를 주어진 환경을 갖는 독립된 프로세스로 실행시켜 줍니다.
이 메소드는 명령어 문자열을 토큰으로 나누어 이 토큰들을 포함하고 있는 cmdarray라는 새로운 배열을 생성합니다.
그리고 나서 exec(cmdarray, envp)을 호출합니다.
- public Process exec(String cmdarray[]) throws IOException:
주어진 문자열 배열에 있는 명령어와 매개변수를 이용하여 독립된 프로세스로 실행시켜 줍니다.
exec(cmdarray, null)을 호출합니다.
- public Process exec(String cmdarray[], String envp[]) throws IOException:
주어진 문자열 배열에 있는 명령어와 매개변수를 이용하여 주어진 환경을 갖는 독립된 프로세스로 실행시켜 줍니다.
문자열 배열 cmdarray에는 명령어와 명령행 인자들을 나타내고 있습니다.
- public native long freeMemory(): 시스템에 남아있는 메모리의 양을 얻습니다.
이 값은 항상 totalMemory() 메소드에 의해 얻어지는 값보다 작습니다.
- public native long totalMemory(): 자바 가상머신의 최대 메모리 크기를 얻습니다.
------------------------------------------------------------------------

5.3 Process 클래스가 제공해 주는 주요 메소드
------------------------------------------------------------------------
- public abstract OutputStream getOutputStream(): 자식 프로세스의 출력 스트림을 얻습니다.
- public abstract InputStream getInputStream(): 자식 프로세스의 입력 스트림을 얻습니다.
- public abstract InputStream getErrorStream(): 자식 프로세스의 에러 스트림을 얻습니다.
- public abstract int waitFor() throws InterruptedException: 자식 프로세스가 종료될 때까지 기다립니다.
- public abstract int exitValue(): 자식 프로세스가 종료할 때의 상태값을 얻습니다.
- public abstract void destroy(): 자식 프로세스를 강제로 종료시킵니다.
------------------------------------------------------------------------

6. 메모리 관리
------------------------------------------------------------------------
public long totalMemory ( ) : 현재 할당받은 총 시스템 메모리 바이트 갯수.
public long freeMemory ( ) : 현재 남아 있는 자유 메모리 바이트 갯수(근사치).

Runtime rt = Runtime.getRuntime ( );
System.out.println ( rt.totalMemory ( ) );
System.out.println ( rt.freeMemory ( ) );
------------------------------------------------------------------------


나. 시스템 정보

static PrintStream err - The "standard" error output stream.
static InputStream in - The "standard" input stream.
static PrintStream out - The "standard" output stream.

static void arraycopy (Object src, int src_position, Object dst, int dst_position, int length)
static long currentTimeMillis () - Returns the current time in milliseconds.
static void exit (int status) - Terminates the currently running Java Virtual Machine.
static void gc () - Runs the garbage collector.
static String getenv (String name) - Deprecated from getProperty method

static Properties getProperties() - Determines the current system properties.
static String getProperty(String key) - Gets the system property indicated by the specified key.
static String getProperty(String key, String def) - Gets the system property indicated by the specified key.
static SecurityManager getSecurityManager() - Gets the system security interface.
static int identityHashCode(Object x) - Returns the same hashcode for the given object as would be returned by the default method hashCode(), whether or not the given object's class overrides hashCode().
static void load(String filename) - Loads a code file with the specified filename from the local file system as a dynamic library.
static void loadLibrary(String libname) - Loads the system library specified by the libname argument.
static String mapLibraryName(String libname) - Maps a library name into a platform-specific string representing a native library.
static void runFinalization() - Runs the finalization methods of any objects pending finalization.
static void runFinalizersOnExit(boolean value) - Deprecated. This method is inherently unsafe. It may result in finalizers being called on live objects while other threads are concurrently manipulating those objects, resulting in erratic behavior or deadlock.
static void setErr(PrintStream err) - Reassigns the "standard" error output stream.
static void setIn(InputStream in) - Reassigns the "standard" input stream.
static void setOut(PrintStream out) - Reassigns the "standard" output stream.
static void setProperties(Properties props) - Sets the system properties to the Properties argument.
static String setProperty(String key, String value) - Sets the system property indicated by the specified key.
static void setSecurityManager(SecurityManager s)

String System.getProperty ( String key ): key에 해당하는 시스템정보를 가져온다.
String System.setProperty ( String key, String value )
Properties System.getProperties ( ): 시스템 정보를 몽땅 갖고 온다.
System.setProperties ( Properties props )

사용법
------------------------------------------------------------------------
String currentDirectory = System.getProperty ( "user.dir" );
------------------------------------------------------------------------

Key값
------------------------------------------------------------------------
// 일반적으로, 보안에 걸리지 않는 표준 시스템 프로퍼티
"java.version", // 자바의 버전 ( "1.0.2", "1.1", "1.1.3", "1.2", ...)
"java.class.version", // 자바 클래스 화일 포맷 버전
"java.vendor", // 자바 가상 머쉰 판매 회사
"java.vendor.url", // 자바 가상 머쉰 판매 회사의 URL
"os.name", // 운영체제 이름 ( "Windows 95", "Windows NT", "MacOS",
// "Linux", "Solaris", "OS/2", "OSF1", ... )
"os.version", // 운영체제 버전
"os.arch", // 컴퓨터 기종 ( "x86", "sparc", ... )
"line.separator", // 시스템에서의 행 분리 문자열 ( "
", " ", " " )
"file.separator", // 화일 경로 이름내의 디렉토리 구분 문자 ("", "/")
"path.separator", // 화일 경로 이름 리스트의 구분 문자 (";", ":")

// 일반적으로, 보안에 의한 접근 제한을 받는 표준 시스템 프로퍼티 (애플릿의 경우)
"java.home", // JDK 설치 디렉토리
"java.class.path", // 패키지가 있는 디렉토리 리스트
// (일반적으로, CLASSPATH 환경변수값에 의해 영향 받음)
"user.name", // 사용자의 등록 이름
"user.home", // 사용자의 홈 디렉토리
"user.dir", // 사용자의 현재 작업 디렉토리(파일을 뺀 전체 경로)

// JDK 1.1에서 비공식적으로 추가된 지역 정보 시스템 프로퍼티
// 일반적으로, 보안에 의한 접근 제한을 받음 (애플릿의 경우)
"file.encoding", // 사용자의 디폴트 문자 인코딩 이름
"user.language", // 사용자의 언어
"user.region", // 사용자의 거주 지역 (보통, 국가)
"user.timezone", // 사용자 지역의 표준 시간대 이름

// 웹 브라우저 정보 비표준 시스템 프로퍼티
"browser", // 웹 브라우저 이름
"browser.version", // 웹 브라우저 버전
"browser.vendor", // 웹 브라우저 회사
------------------------------------------------------------------------


다. 기타

//아래는 자바서비스넷의 이원영님 자료
-----------------------------------------------------------------------------------
import java.io.*;

public class Test
{
public static void main(String[] args) throws Exception
{
Runtime rt = Runtime.getRuntime();
StringBuffer cmd = new StringBuffer();
for(int i=0;i
cmd.append(args[i] + " ");

Process p = rt.exec(cmd.toString() );
PrintWriter keyboard = new PrintWriter(p.getOutputStream());
//keyboard.println( ... );

p.waitFor(); // wait for process finishing.

BufferedReader out = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ( out.ready() )
System.out.println(out.readLine());

BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
while ( err.ready() )
System.out.println(err.readLine());

p.destroy(); //confirm
}
}
-----------------------------------------------------------------------------------
javaservice:/home/java/tmp$ javac Test.java
javaservice:/home/java/tmp$ java Test ls -alF /var

그러나 windows환경의 command.com의 경우, "command.com /c dir" 등의 방법으로
될 것으로 예상됐지만, "command.com /c dir" 의 명령이 보통의 DOS창에선 바로 exit으로
이어지나, Runtime.exec("command.com /c dir") 로 호출했을 경우, Process Thread가
끝나질 않는 군요... 결국, p.waitFor()에서 blocking 현상이 일어나네요.
어쨌거나 Unix환경에선 잘 되네요.

//아래는 이원영의 참고자료
-----------------------------------------------------------------------------------
String[] command = {"a.exe"};
Process p = Runtime.getRuntime().exec(command);

OutputStream os = p.getOutputStream();
DataOutputStream dos = new DataOutputStream(os);
dos.writeInt(...);
dos.flush();
os.close();

p.waitFor();

int rc = p.exitValue();
System.out.println("return code: "+ rc);
if(rc!=0)
{
InputStream errStream = p.getErrorStream();
DataInputStream errDataStream = new DataInputStream(errStream);
String s;
s = errDataStream.readLine();
while(s !=null)
{
System.out.println(s);
s = errDataStream.readLine();
}
}

InputStream is = p.getInputStream();
DataInputStream dis = new DataInputStream(is);

dis.readLine();
is.close();
         * 
         * */
}

