package app.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.io.File;
import java.io.InputStream;
import java.util.Calendar;

import app.Constants;
import app.utils.UploadUtil;
import app.utils.MediaUtil;
import io.khan.squash.R;

public class ScoreActivity extends AppCompatActivity {

    private static final String TAG = ScoreActivity.class.getSimpleName();

    private static String[] PERMISSIONS_SELFIE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    EditText scoreAView;
    EditText scoreBView;

    BottomBar bottomBar;

    private String videoFileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreAView = (EditText) findViewById(R.id.player_a_score);
        scoreAView.setEnabled(true);
        scoreAView.setCursorVisible(false);
        scoreBView = (EditText) findViewById(R.id.player_b_score);
        scoreBView.setCursorVisible(false);
        scoreBView.setEnabled(true);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(getOnTabSelectListener());
        bottomBar.setOnTabReselectListener(getOnTabReSelectListener());

    }
    /*
    * Player A Code Started
    * */

    public void playerAOneScore(View view) {

        scorePlayerA = scorePlayerA + 1;
        displayForPlayerA(scorePlayerA);
    }

    public void playerATwoScore(View view) {
        scorePlayerA = scorePlayerA + 2;
        displayForPlayerA(scorePlayerA);
    }

    public void playerAThreeScore(View view) {
        scorePlayerA = scorePlayerA + 3;
        displayForPlayerA(scorePlayerA);
    }

    private void displayForPlayerA(int score) {
        scoreAView.setText("" + score);
    }

    /*
    * Player B Code Started
    * */
    public void playerBOneScore(View view) {
        scorePlayerB = scorePlayerB + 1;
        displayForPlayerB(scorePlayerB);
    }

    public void playerBTwoScore(View view) {
        scorePlayerB = scorePlayerB + 2;
        displayForPlayerB(scorePlayerB);
    }

    public void playerBThreeScore(View view) {
        scorePlayerB = scorePlayerB + 3;
        displayForPlayerB(scorePlayerB);
    }

    private void displayForPlayerB(int score) {
        scoreBView.setText(String.valueOf(score));
    }




    //Reset button code
    public void resetButton(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(0);
        displayForPlayerB(0);

    }

    //Submit button code

    public void submitButton(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(0);
        displayForPlayerB(0);
    }


    public OnTabSelectListener getOnTabSelectListener() {
        return new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    Log.v(TAG, "starting camera ....");
                    dispatchTakePictureIntent();

                }
                if (tabId == R.id.tab_nearby) {
                    Log.v(TAG, "starting video ....");
                    dispatchTakeVideoIntent();

                }
            }
        };

    }


    public OnTabReselectListener getOnTabReSelectListener() {
        return new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    Log.v(TAG, "starting camera ....");
                    dispatchTakePictureIntent();

                }
                if (tabId == R.id.tab_nearby) {
                    Log.v(TAG, "starting video ....");
                    dispatchTakeVideoIntent();

                }
            }
        };
    }

    private void dispatchTakePictureIntent() {

        if ((ContextCompat.checkSelfPermission(ScoreActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(ScoreActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                && (ContextCompat.checkSelfPermission(ScoreActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
            } else {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, Constants.IMAGE_CAPTURE);

            } else {
                Toast.makeText(getApplicationContext(), "Some Permissions Denied", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private void dispatchTakeVideoIntent() {

        //set name & path to video file
        String fileName = "video." + File.separator + Calendar.getInstance().getTimeInMillis() + ".mp4";

        videoFileName = Environment.getExternalStorageDirectory() + fileName;
      //  //check if folder exists, else, create it
      //  File path = new File(Environment.getExternalStorageDirectory() + "/videos/");
      //  if (!path.exists())
       //     path.mkdirs();

        //create the intent
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        //Add extra to save video
        Uri output = Uri.fromFile(new File(videoFileName));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 15);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Constants.REC_VIDEO);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            Uri uri = MediaUtil.handleIntent(data, requestCode);
            final InputStream inputStream = MediaUtil.getMediaStream(this, uri);

            AsyncTask<Void, Void, Void> t = new AsyncTask<Void, Void, Void>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        UploadUtil.uploadMedia(inputStream);
                    } catch (Exception e) {
                        Log.e(TAG, "Error uploading video... " + e.toString());
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void result) {
                    super.onPostExecute(result);
                }
            };
            t.execute();

        } catch (Exception e) {
            Log.e(TAG, "Error uploading video... " + e.toString());
        }
    }
}
