/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yavuzk;

import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author yavuz
 */
@WebService(serviceName = "NewWebService1")
public class NewWebService1 {

    /**
     * This is a sample web service operation
     */
    
    
    @WebMethod(operationName = "GetTwitPic")
    public String GetTwitPic(@WebParam(name = "username") String username){
    
        String kul_foto="";
        String site="https://twitter.com/"+username;
        try{
        Connection.Response twitter_response=Jsoup.connect(site).timeout(60000).execute();
        Document doc=twitter_response.parse();
        Elements fotograf_elementi=doc.select("img.ProfileAvatar-image");
        
        if(!fotograf_elementi.isEmpty())
            {
                kul_foto=fotograf_elementi.first().attr("src");
            }
        }catch(IOException ex){
            kul_foto="yavuz255";
        }
        return kul_foto;
    }
    @WebMethod(operationName = "GetInsPic")
    public String GetInsPic(@WebParam(name = "username") String username){
        String kul_foto="";
        String kul_gonderi="";
        String site="https://instagram.com/"+username;
        try{
            Connection.Response innstagram_response=Jsoup.connect(site).timeout(60000).execute();
            Document doc=innstagram_response.parse();
            Elements fotograf_elementi=doc.select("meta[property=og:image]");
            Elements gonderi=doc.select("meta[property=og:description]");
            if(!fotograf_elementi.isEmpty())
                {
                    kul_foto=fotograf_elementi.first().attr("content");
                    kul_gonderi=gonderi.first().attr("content");
                }
        
        }catch(IOException ex){
            kul_foto="hata var";
        }
        
        
        return kul_foto;
    }
    
    
}
