import java.net.*; 
import java.io.*;

class RCEServer 
{

public static void main(String[] args) 
{ 
ServerSocket server;
Socket client;
OutputStream os;
InputStream is;
InputStream commandInputStream; 
DataInputStream dis; 
DataOutputStream dos;
String[] command; 
Process process;
ProcessBuilder pB = new ProcessBuilder(); 
try
{
server = new ServerSocket(7313); 
System.out.println("Server started..."); 
client = server.accept();
System.out.println("Client connected: " + client.getInetAddress()); 
os = client.getOutputStream();
is = client.getInputStream();
 dis = new DataInputStream(is);
dos = new DataOutputStream(os); 
String cmd = dis.readUTF();
cmd = cmd.trim(); command = cmd.split(" ");
process = pB.command(command).start(); 
commandInputStream = process.getInputStream(); 
BufferedReader buff = new BufferedReader(new
InputStreamReader(commandInputStream));
 String read;
String result = "";
while ((read = buff.readLine()) != null)
{ 
result = read + "\n" + result;
}
dos.writeUTF(result); 
dos.flush();
System.out.println("Command: " + cmd + " successfully."); 
System.out.println("Server exited");
server.close();
}
catch(IOException e)
{
System.out.println(e.getMessage());
}
}
}
