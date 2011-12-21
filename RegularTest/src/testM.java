//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
// 
// 
//public class testM{
//public static void main(String[] args){
// 
//public int ccnumbert=0;
//public String card_typet;
//public int montht=0;
//public int yeart=0;
//public String fullnamet;
//public int ccvt=0;
//public int costt=0;
//checkCCDetails("4343","visa","6","2000","bj","666",5000);
//}
//public int checkCCDetails(String ccnumber,String card_type,String month,String year,String fullname,String ccv,int totCst){
//Connection con=null;
//ResultSet rs=null;
//Statement stmt=null;
// 
//int flag=0;
//ccnumbert=Integer.parseInt(ccnumber);
//card_typet=card_type;
//montht=Integer.parseInt(month);
//yeart=Integer.parseInt(year);
//fullnamet=fullname;
//ccvt=Integer.parseInt(ccv);
//costt=totCst;
// 
//public int ccnumberc=0;
//public String card_typec=null;
//public int monthc=0;
//public int yearc=0;
//public String fullnamec=null;
//public int ccvc=0;
//public int bal=0;
// 
//try{
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//con=DriverManager.getConnection("jdbc:odbc:MY-PIZZA","","");
//String q="select * from Accounts where ccnumber="+ccnumbert+" ";
// 
//stmt=con.createStatement();
//rs=stmt.executeQuery(q);
//if(rs !=null){
//while( rs.next()){
// 
//ccnumberc=rs.getInt(1);
//card_typec=rs.getString(2);
//monthc=rs.getInt(3);
//yearc=rs.getInt(4);
//fullnamec=rs.getString(5);
//ccvc=rs.getInt(6);
//bal=rs.getInt(7);
//}
//}
//}catch(SQLException e){
//}
//catch(ClassNotFoundException ee){
//}
//finally{
// 
//if(rs !=null){
//rs.close();
//rs=null;
//}
//if(stmt !=null){
//stmt.close();
//stmt=null;
//}
//if(con !=null){
//con.close();
//con=null;
//}
//}//end finally*/
// 
// 
// 
//boolean i=check(ccnumberc,card_typec,monthc,yearc,fullnamec,ccvc);
//if(i==true && bal>=costt)
//flag=1;//payment succeeded
//else if (i==true && bal<costt)
//flag=2;//dettails are ok but insufficient balance
//else
//flag=3;//details are wrong
// 
// 
//return flag;
//}
// 
// 
//public boolean check(int ccnumberc,String card_typec,int monthc,int yearc,String fullnamec,int ccvc){
// 
//if(ccnumbert==ccnumberc && card_typet==card_typec && montht==monthc && yeart==yearc && fullnamet==fullnamec && ccvt==ccvc)
//return true;
//else return false;
// 
// 
//}
//}