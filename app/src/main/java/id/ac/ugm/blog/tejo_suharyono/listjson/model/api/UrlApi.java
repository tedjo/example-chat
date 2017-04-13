package id.ac.ugm.blog.tejo_suharyono.listjson.model.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by MrTejo on 27/03/2017.
 */

public interface UrlApi {

    @GET("/messages.json")//
    void getItemData(Callback<String>ItemData);
}
