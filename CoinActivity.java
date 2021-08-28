package com.shiv.shambhu.activity;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.shiv.shambhu.R;
import com.shiv.shambhu.app.AppActivity;

public class CoinActivity extends AppActivity {

    private final String TAG = "CoinActivity";
    //creating Object of RewardedAd
    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        //initializing the Google Admob SDK
        MobileAds.initialize(this, initializationStatus -> {
            //Showing a simple Toast Message to the user when The Google AdMob Sdk Initialization is Completed
            Toast.makeText(CoinActivity.this, "AdMob Sdk Initialize " + initializationStatus.toString(), Toast.LENGTH_LONG).show();

        });

        // Initializing the Button  objects to their respective views from activity_main.xml file
        //creating Object of Buttons
        Button loadAdBtn = findViewById(R.id.loadRewardedBtn);
        Button showAdBtn = findViewById(R.id.showRewardedBtn);

        //OnClickListener listeners for loadAdBtn and showAdBtn buttons
        loadAdBtn.setOnClickListener(view -> {
            //calling the loadRewardedAd method to load  the Rewarded Ad
            loadRewardedAd();
        });

        showAdBtn.setOnClickListener(view -> {
            //calling the showRewardedAd method to show the Rewarded Ad
            showRewardedAd();
        });
    }

    private void loadRewardedAd() {
        // Creating  an Ad Request
        AdRequest adRequest = new AdRequest.Builder().build();
        //Initializing the RewardedAd  objects
        // load Rewarded Ad with the Request
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    // creating  RewardedAdLoadCallback for Rewarded Ad with some 2 Override methods
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.getMessage());
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd mRewardedAd) {
                        rewardedAd = mRewardedAd;
                        Log.d(TAG, "Ad was loaded.");
                        Toast.makeText(CoinActivity.this, "Rewarded Ad is loaded", Toast.LENGTH_LONG).show();
                    }
                });

        // Showing a simple Toast message to user when Rewarded an ad is Loading
        Toast.makeText(CoinActivity.this, "Rewarded Ad is loading ", Toast.LENGTH_LONG).show();
    }

    private void showRewardedAd() {
        if (rewardedAd != null) {
            Activity activityContext = CoinActivity.this;
            //showing the ad Rewarded Ad if it is loaded
            rewardedAd.show(activityContext, rewardItem -> {
                // Handle the reward.
                Log.d(TAG, "The user earned the reward.");
                int rewardAmount = rewardItem.getAmount();
                String rewardType = rewardItem.getType();
            });
        } else {
            Log.d(TAG, "The rewarded ad wasn't ready yet.");
            //Load the Rewarded ad if it is not loaded
            loadRewardedAd();

            // Showing a simple Toast message to user when Rewarded ad is not loaded
            Toast.makeText(CoinActivity.this, "Rewarded Ad is not Loaded ", Toast.LENGTH_LONG).show();
        }
    }
}
