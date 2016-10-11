package app.service;

/**
 * Created by marcrisney on 10/4/16.
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceFactory {

    final static private OkHttpClient getClient() {

        String credential = Credentials.basic("test", "test");

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        return response.request().newBuilder().header("Authorization", credential).build();
                    }
                }).build();

        return httpClient;
    }

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz    Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T service = retrofit.create(clazz);

        return service;
    }

}