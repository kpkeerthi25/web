import java.io.*;
import java.net.*;

public class ChatCl
{
	public static void main(String args[]) throws Exception
	{
		Socket sock = new Socket("127.0.0.1",3000);
		
		BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		
		InputStream istream = sock.getInputStream();
		BufferedReader recread = new BufferedReader (new InputStreamReader(istream));
		
		String Rmsg, Smsg;
		
		while(true)
		{
			Smsg = keyread.readLine();
			pwrite.println(Smsg);
			pwrite.flush();
			if((Rmsg = recread.readLine())!=null)
			{
				System.out.println(Rmsg);
			}
		}
	}
}
