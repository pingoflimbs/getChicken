package transaction_History;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Get_Transaction_History 
{
	public static void main(String[] args) 
	{	
		HttpJob httpjob = new HttpJob();
		
		System.out.println(httpjob.getTransaction("BTC", "KRW"));
		JSONParser obj = new JSONParser();
		obj.getClass().toString();
	}

}

class HttpJob
{
	public HttpJob()
	{
		
	}
	
	String getTransaction(String coin, String currency)
	{
		StringBuilder sb = new StringBuilder();
		
		String coinName = "BTC";
		try {
			URL url = new URL("https://api.bithumb.com/public/transaction_history/" + coinName + "_" + currency);
			// ��û url �ּ�
	
			URLConnection conn = url.openConnection();
	
			conn.setDoInput(true);
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
	
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}			
	
		} catch (Exception e) {
	
			e.printStackTrace(); // ���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ���.
		}
		
		return sb.toString();
	}
}
