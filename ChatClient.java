import java.net.*; 
import java.io.*;
import java.util.*;

class ChatClient
{
public static void main(String[] args)
{
 Socket socket = null;
Scanner scan = new Scanner(System.in); 
String yourMsg, serverMsg; 
InputStream inputStream = null; 
OutputStream outputStream = null;
DataInputStream dataInputStream = null; 
DataOutputStream dataOutputStream = null; 
try
{
socket = new Socket("localhost", 7313); 
System.out.println("Connected..."); 
inputStream = socket.getInputStream(); 
outputStream = socket.getOutputStream();
dataInputStream = new DataInputStream(inputStream); 
dataOutputStream = new DataOutputStream(outputStream);
while(true)
{
serverMsg = dataInputStream.readUTF();
if(serverMsg.equals("exit"))
{
break;
}
System.out.println("Server: " + serverMsg); 
System.out.print("You: ");
yourMsg = scan.nextLine(); 
dataOutputStream.writeUTF(yourMsg); 
if(yourMsg.equals("exit")){
break;
}
}
socket.close();
}
catch(IOException e)
{ 
System.out.println(e);
}
}
}
