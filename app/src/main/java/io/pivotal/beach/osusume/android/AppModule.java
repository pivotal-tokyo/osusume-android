package io.pivotal.beach.osusume.android;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.pivotal.beach.osusume.android.api.OsusumeApiClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private static String BASE_URL = "http://osusume.cfapps.io";

    @Provides
    @Singleton
    OsusumeApiClient provideOsusumeApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(OsusumeApiClient.class);
    }
}