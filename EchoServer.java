import java.net.*; 
import java.io.*;

class EchoServer
{
public static void main(String[] args)
{
ServerSocket serverSocket = null; 
Socket client = null;
String clientMsg;
InputStream inputStream = null; 
OutputStream outputStream = null;
DataInputStream dataInputStream = null; 
DataOutputStream dataOutputStream = null; 
try
{
serverSocket = new ServerSocket(7313); 
System.out.println("Server started..."); 
client = serverSocket.accept(); 
System.out.println("Client connected...");
inputStream = client.getInputStream(); 
outputStream = client.getOutputStream();
dataInputStream = new DataInputStream(inputStream); 
dataOutputStream = new DataOutputStream(outputStream);
clientMsg = dataInputStream.readUTF(); 
System.out.println("Echoing..."); 
dataOutputStream.writeUTF(clientMsg);
serverSocket.close();
}
catch(IOException e)
{ 
System.out.println(e);
}
}
}
