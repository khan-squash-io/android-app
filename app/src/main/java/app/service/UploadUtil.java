package app.service;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

import app.model.Media;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marcrisney on 10/12/16.
 */

public class UploadUtil {

    private static final String TAG = UploadUtil.class.getSimpleName();

    public static void uploadMedia(InputStream is) throws Exception {

        UploadService service = ServiceFactory.createRetrofitService(UploadService.class, UploadService.SERVICE_ENDPOINT);
        byte[] data = IOUtils.toByteArray(is);

        RequestBody requestFile = RequestBody.create(MediaType.parse("audio/mpeg"), data);
        MultipartBody.Part body = MultipartBody.Part.createFormData("title", "video.mp4", requestFile);


        Call<Media> call;
        call = service.uploadMedia(body, "4246101093");
        Log.v(TAG, "calling service : " + call.toString());

        call.enqueue(new Callback<Media>() {
            @Override
            public void onResponse(Call<Media> media,
                                   Response<Media> response) {
                Log.v(TAG, "response from server  : " + response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Media> call, Throwable t) {
                Log.e(TAG, "failed to connect to server : " + t.getMessage());
            }
        });
    }
}
