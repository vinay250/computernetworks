import java.net.*; 
import java.io.*; 
import java.util.*;

class ChatServer
{
public static void main(String[] args)
{ 
ServerSocket serverSocket = null; 
Socket client = null;
Scanner scan = new Scanner(System.in); 
String yourMsg, clientMsg; 
OutputStream outputStream = null; 
InputStream inputStream = null;
DataOutputStream dataOutputStream = null; 
DataInputStream dataInputStream = null; 
try 
{
serverSocket = new ServerSocket(7313);
System.out.println("Server started...");
client = serverSocket.accept(); 
System.out.println("Client connected..."); 
outputStream = client.getOutputStream(); 
inputStream = client.getInputStream();
dataOutputStream = new DataOutputStream(outputStream); 
dataInputStream = new DataInputStream(inputStream); 
dataOutputStream.writeUTF("Hi from server"); 
while(true)
{
clientMsg = dataInputStream.readUTF(); 
if(clientMsg.equals("exit"))
{
break;
}
System.out.println("Client: " + clientMsg);
System.out.print("You:");
yourMsg = scan.nextLine(); 
dataOutputStream.writeUTF(yourMsg); 
if(yourMsg.equals("exit"))
{
break;
}
}
serverSocket.close();
}
catch(IOException e)
{ 
System.out.println(e);
}
}
}
 
