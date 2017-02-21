package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try
        {
            URL url=new URL("http://otobi.com/admin/assets/img/product_thumb/BDDB001LBAB001.jpg");
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            int resoponseCode=conn.getResponseCode();
            if(resoponseCode== HttpURLConnection.HTTP_OK)
            {
                String fileName=new String();
                String contentType=conn.getContentType();
                int contentLength=conn.getContentLength();
                String urlString="http://otobi.com/admin/assets/img/product_thumb/BDDB001LBAB001.jpg";
                fileName=urlString.substring(urlString.lastIndexOf("/")+1,urlString.length());
                System.out.println("Content-type = "+contentType);
                System.out.println("Content-length = "+contentLength);
                System.out.println("File-name = "+fileName);
                InputStream input=conn.getInputStream();
                FileOutputStream output=new FileOutputStream(fileName);
                int bytesRead=-1;
                byte[]buffer=new byte[100000];
                while((bytesRead=input.read(buffer))!=-1)
                {
                    System.out.println(bytesRead);
                    output.write(buffer,0,bytesRead);
                }
                output.close();
                input.close();
            }
        }
        catch (IOException io)
        {
            System.out.println("Failed to download");
        }
    }
}
