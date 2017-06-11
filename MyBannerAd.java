package com.infancyit.trueghoststoriesofmanitoba;

import android.app.Activity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by mmrs on 08-Jun-16.
 */
public class MyBannerAd {


    Activity activity;

    public MyBannerAd(Activity activity) {
        this.activity = activity;
    //    MobileAds.initialize(activity, "ca-app-pub-3940256099942544~3347511713");
        AdView adView = (AdView) activity.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.setAdSize(AdSize.SMART_BANNER);   //ad size must be match parent
		adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        adView.loadAd(adRequest);
    }
}
