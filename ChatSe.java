import java.io.*;
import java.net.*;

public class ChatSe
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket sersock = new ServerSocket(3000);
		System.out.println("Server is ready");
		
		Socket sock = sersock.accept();
		
		BufferedReader keyread = new BufferedReader ( new InputStreamReader(System.in));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		
		InputStream istream = sock.getInputStream();
		BufferedReader recread = new BufferedReader (new InputStreamReader(istream));
		
		String Rmsg, Smsg;
		
		while(true)
		{
			if( (Rmsg = recread.readLine()) != null)
			{
				System.out.println(Rmsg);
			}
			
			Smsg = keyread.readLine();
			pwrite.println(Smsg);
			pwrite.flush();
		}
	}
}
