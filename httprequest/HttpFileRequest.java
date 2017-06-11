package com.infancyit.mmcnews.httprequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Siyam on 26-Dec-15.
 */
public class HttpFileRequest {

    private KeyValue[] headers;
    private String url;
    private boolean urlencoded;
    private int reqId;
    private HttpListener activity;
    private Bundle bundle;
    private final int request_time_out=8000;
    private RequestParams params;
    private JSONObject jsonData;
    private ProgressDialog dialog;



    public HttpFileRequest(String url,int requestId,HttpListener mActivity) {
        this.url =url;
        reqId =requestId;
        activity =mActivity;
        params = new RequestParams();

    }

    public void setParams(KeyValue... params){
        for (int i=0;i<params.length;i++)
        {
            this.params.put(params[i].getKey(),params[i].getValue());
        }

    }
    public void setFile(String name,String path) throws FileNotFoundException {
        Log.i("tanvy",path);
        File file = new File(path);
        params.put(name,file);

    }

    public void setFile(String name, InputStream path) throws FileNotFoundException {

        params.put(name,path);

    }


    public void execute(final String method)
    {

        new Thread()
        {
            public void run() {
                SyncHttpClient client = new SyncHttpClient();
                if (method.equals("post")) {
                    client.post(activity.getContext(), url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                            activity.respond(new String(responseBody), reqId, null);

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            error.printStackTrace();
                            activity.errorRespond(null, statusCode, null);
                        }
                    });
                }
            }
        }.start();





    }



}
