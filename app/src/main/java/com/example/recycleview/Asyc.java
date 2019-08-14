package com.example.recycleview;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;


    public class Asyc extends AsyncTask<String,Void,String> {




        @Override
        protected void onPreExecute() {


            super.onPreExecute();


        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            // prog.setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... strings) {

            String jsonurl = strings[0];

            HttpHandler sh = new HttpHandler();

            String json = sh.makeServiceCall(jsonurl);
            System.out.println("This is JSON: "+json);

            return json;
        }
    }

