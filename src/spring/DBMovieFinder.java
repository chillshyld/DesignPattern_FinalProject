package spring;

import org.springframework.security.access.method.P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


import static org.springframework.http.HttpHeaders.USER_AGENT;

public class DBMovieFinder implements MovieFinder {
    private String apiURL;

    public DBMovieFinder(String url){
        this.apiURL = url;
    }

    @Override
    public ArrayList<Object> readMoviesFile() {
        ArrayList movieList = new ArrayList<JSONObject>();
        try{
            URL obj = new URL(this.apiURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONParser parser = new JSONParser();
            Object data =   parser.parse(response.toString());
            JSONObject movieJSON = (JSONObject) data;
            movieList = (ArrayList<JSONObject>) movieJSON.get("results");

        }catch (MalformedURLException err){
            System.out.println(err);
        }catch (IOException err){
            System.out.println(err);
        }catch (ParseException err){
            System.out.println(err);
        }


        return movieList;
    }
}
