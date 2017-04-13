package id.ac.ugm.blog.tejo_suharyono.listjson.model.api;

import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by MrTejo on 27/03/2017.
 */

public class DataApiManager {
    private UrlApi mUrlApi;

    // di sini menggukanan libary gson sendiri untuk mengambil data dari model json itu di dalam url link yg di simpan di class helperUrl
    public UrlApi getDataApi() {

        if(mUrlApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringJson());

            mUrlApi = new RestAdapter.Builder()
                    .setEndpoint(HelperUrl.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(UrlApi.class);
        }
        return mUrlApi;
    }
}
