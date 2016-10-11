package app.service;

import app.model.Media;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

public interface UploadService {

    String SERVICE_ENDPOINT = "https://api-upload-khan-squash.herokuapp.com";

    @GET("/hello")
    Observable<Media> getHello();

    @Multipart
    @POST("/1/media/{phoneNumber}")
    Call<Media> uploadMedia(@Part MultipartBody.Part filePart, @Path("phoneNumber") String phoneNumber);

}
