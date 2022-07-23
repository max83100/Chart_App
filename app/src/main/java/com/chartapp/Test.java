package com.chartapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.chartapp.bottom.Bottom;
import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;



public class Test extends AppCompatActivity {
    BannerAdView mBannerAdView;
    BannerAdView mBannerAdView1;
    BannerAdView mBannerAdView2;
    BannerAdView mBannerAdView3;
    BannerAdView mBannerAdView4;
    BannerAdView mBannerAdView5;
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        MobileAds.initialize(this, new InitializationListener() {
            @Override
            public void onInitializationCompleted() {
                Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized");
            }
        });
        final AdRequest adRequest = new AdRequest.Builder().build();
        mBannerAdView =  findViewById(R.id.banner_ad_view);
        mBannerAdView.setAdUnitId("R-M-1760873-1");
        mBannerAdView.setAdSize(AdSize.BANNER_300x300);
        mBannerAdView.loadAd(adRequest);


        mBannerAdView1 =  findViewById(R.id.banner_ad_view1);
        mBannerAdView1.setAdUnitId("R-M-1760873-1");
        mBannerAdView1.setAdSize(AdSize.BANNER_320x50);
        mBannerAdView1.loadAd(adRequest);


        mBannerAdView2 =  findViewById(R.id.banner_ad_view2);
        mBannerAdView2.setAdUnitId("R-M-1760873-1");
        mBannerAdView2.setAdSize(AdSize.BANNER_300x300);
        mBannerAdView2.loadAd(adRequest);

        mBannerAdView3 =  findViewById(R.id.banner_ad_view3);
        mBannerAdView3.setAdUnitId("R-M-1760873-1");
        mBannerAdView3.setAdSize(AdSize.BANNER_320x50);
        mBannerAdView3.loadAd(adRequest);







        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try
                {
                    int logoTimer = 0;
                    while(logoTimer < 10000)
                    {
                        sleep(100);
                        logoTimer = (int) (logoTimer + Math.random()*100);
                    };


                    startActivity(new Intent(getApplicationContext(), Test.class));
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        logoTimer.start();
    }




}