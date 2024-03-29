package com.example.recycleview;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

    public class HttpHandler {
        public HttpHandler() {

        }

        public String makeServiceCall(String rurl) {
            String response = null;

            try {
                URL url = new URL(rurl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();//connecting and casting
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");


                //Read response
                InputStream in = new BufferedInputStream(con.getInputStream());// storing inputstream in the buffer

                response = convertStream(in);

            } catch (MalformedURLException e) {
                Log.e("HttpHandler Class", "MalformedURLException : " + e.getMessage());
            } catch (IOException e) {
                Log.e("HttpHandler Class", "IOException : " + e.getMessage());
            }

            return response;
        }


        public String convertStream(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }

            } catch (IOException e) {
                Log.e("ConvertStream", "IOException : " + e.getMessage());
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e("ConvertStreamFinally", "IOException : " + e.getMessage());
                }
            }
            return sb.toString();
        }

}
