package app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;

import java.io.File;

import app.model.Media;
import app.service.ServiceFactory;
import app.service.UploadService;
import io.khan.squash.R;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreActivity extends AppCompatActivity {


    UploadService service = ServiceFactory.createRetrofitService(UploadService.class, UploadService.SERVICE_ENDPOINT);

    private static final String TAG = ScoreActivity.class.getSimpleName();
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private final static int CAMERA_RQ = 6969;

    int scorePlayerA = 0;
    int scorePlayerB = 0;

    EditText scoreAView;
    EditText scoreBView;

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


        new MaterialCamera(this)
                .start(CAMERA_RQ);
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


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    //Reset button code
    public void resetButton(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(0);
        displayForPlayerB(0);

        new MaterialCamera(this)
                .countdownMinutes(2.5f)
                .countdownImmediately(true)
                .start(CAMERA_RQ);

    }

    //Submit button code

    public void submitButton(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(0);
        displayForPlayerB(0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Received recording or error from MaterialCamera
        if (requestCode == CAMERA_RQ) {

            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Saved to: " + data.getDataString(), Toast.LENGTH_LONG).show();

                try {
                    final File file = new File(data.getData().getPath());
                    Log.v(TAG, "file = "+ file.getName());

                    RequestBody requestFile =
                            RequestBody.create(MediaType.parse("audio/mpeg"), file);

                    MultipartBody.Part body =
                            MultipartBody.Part.createFormData("title", file.getName(), requestFile);



                    Call<Media> call = service.uploadMedia(body,"4246101093");
                    Log.v(TAG,"calling service : "+ call.toString());

                    call.enqueue(new Callback<Media>() {
                        @Override
                        public void onResponse(Call<Media> media,
                                               Response<Media> response) {
                            Log.v(TAG, "response from server  : " + response.isSuccessful());
                        }
                        @Override
                        public void onFailure(Call<Media> call, Throwable t) {
                            Log.e(TAG, "failed to connect to server : " +  t.getMessage());
                        }
                    });



                } catch (Exception e){
                    Log.e(TAG, "error : "  + e.getMessage());
                }

            } else if(data != null) {
                Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

}

