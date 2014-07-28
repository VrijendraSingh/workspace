
import java.net.*; 
import java.io.*; 
import javax.swing.*; 
import javax.net.ssl.HttpsURLConnection; 


class sendSMS 
{ 

	public static void main(String args[]) 
	{ 
		boolean debug=true; 

		String phone	=""; 
		String message	=""; 
		String ppgHost	="http://localhost:8800/"; 
		String username ="";
		String password ="";
		
		try
		{ 
			phone=URLEncoder.encode("9632242913", "UTF-8"); 

			if(debug) 
				System.out.println("phone------>"+phone); 
			message=URLEncoder.encode("SendMsg via Now.SMS", "UTF-8"); 

			if(debug) 
				System.out.println("message---->"+message); 
		} 
		catch (UnsupportedEncodingException e) 
		{ 
			System.out.println("Encoding not supported"); 
		} 

		String url_str=ppgHost+"?PhoneNumber="+phone+"&Text="+message; 
		// String url_str=ppgHost+"?user="+username+"&password="+password+"&PhoneNumber="+phone+"&Text="+message; 

		if(debug)                   
			System.out.println("url string->"+url_str); 

		
		try
		{		
			URL url2=new URL(url_str); 

			HttpURLConnection connection = (HttpURLConnection) url2.openConnection(); 
			connection.setDoOutput(false); 
			connection.setDoInput(true); 

			if(debug)                  
				System.out.println("Opened Con->"+connection); 
	
			String res=connection.getResponseMessage(); 
		
			if(debug) 
				System.out.println("Get Resp  ->"+res); 
	
			int code = connection.getResponseCode () ; 
		
			if ( code == HttpURLConnection.HTTP_OK ) 
			{ 
				connection.disconnect() ; 
			}
		}
		catch(IOException e)
		{
			System.out.println("unable to create new url"+e.getMessage());
		}

	

	} // main
} 