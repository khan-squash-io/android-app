package app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;
import io.khan.squash.R;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String TWITTER_KEY = "wnuGRAYEaUxf8akYAcA0yko90";
    private static final String TWITTER_SECRET = "FvpJ4s2fCSF4eSKgDJJIrRlWMphaYQ1H2M3n7LquexHclCCXek";

    private int frameIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        if (!Fabric.isInitialized()) {
            TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);

            Digits.Builder digitsBuilder = new Digits.Builder().withTheme(R.style.CustomDigitsTheme);
            Fabric.with(MainActivity.this, new TwitterCore(authConfig), digitsBuilder.build());
        }


        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);

        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d(TAG, "Sign in with Digits failure", exception);
            }
        });


        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getDataForOnboarding(), getApplicationContext());

        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int oldElementIndex, int newElementIndex) {
                frameIndex = newElementIndex;
                Toast.makeText(getApplicationContext(), "Swiped from " + oldElementIndex + " to " + newElementIndex, Toast.LENGTH_SHORT).show();
            }
        });

        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                // Probably here will be your exit action
                Toast.makeText(getApplicationContext(), "Swiped out right", Toast.LENGTH_SHORT).show();
            }
        });


        final FrameLayout selected = (FrameLayout) findViewById(R.id.onboardingContentIconContainer);
        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, frameIndex + " Frame Selected", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(i);
            }
        });





    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Courts", "Find a Squash Court",
                Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key);



        PaperOnboardingPage scr2 = new PaperOnboardingPage("Score", "Record your game, upload",
                Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("History", "View your past games",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart);

        PaperOnboardingPage scr4 = new PaperOnboardingPage("Purchase", "Purchase a Squash ball",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);


        return elements;
    }
}