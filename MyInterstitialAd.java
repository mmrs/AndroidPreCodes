package com.studio_e.ledflash;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Siyam on 22-Feb-16.
 */
public class MyInterstitialAd {

    private InterstitialAd mInterstitialAd;
    private Activity context;

    public MyInterstitialAd(Activity context) {

        this.context = context;
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-9942952222425589/1529539956");
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                requestNewInterstitial();
            }
        });
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try{
                        //   Log.i("th", "thread running");
                        Thread.sleep(10*60*1000);
                        runAd();

                    }catch (Exception e){

                    }
                }
            }
        }).start();
    }
    private void requestNewInterstitial(){
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("set my device id").build();
        //   Log.i("th","requesting  new ad");
        mInterstitialAd.loadAd(adRequest);
    }


    private void runAd(){
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
                //   else Log.i("th","ad not loaded");
            }
        });
    }
}
