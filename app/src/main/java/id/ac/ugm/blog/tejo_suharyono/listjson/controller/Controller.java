package id.ac.ugm.blog.tejo_suharyono.listjson.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import id.ac.ugm.blog.tejo_suharyono.listjson.model.api.DataApiManager;
import id.ac.ugm.blog.tejo_suharyono.listjson.model.data.ItemDataModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by MrTejo on 27/03/2017.
 */

public class Controller {
    private static final String TAG = Controller.class.getSimpleName();
    private CallListener mListener;
    private DataApiManager mApiManager;

    public Controller(CallListener listener) {
        mListener = listener;
        mApiManager = new DataApiManager();
    }

    public interface CallListener {
        void onFetchComplete();
        void onFetchFailed();
        void onFetchProgress(ItemDataModel itemDataModel);
    }

    public void startFetching() {
        mApiManager.getDataApi().getItemData(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);

                try {
                    JSONArray array = new JSONArray(s);
                    for(int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        ItemDataModel itemDataModel = new ItemDataModel.Builder()
                                .setMessage(object.getString("message"))
                                .setSender(object.getString("sender"))
                                .setIs_from_me(object.getString("is_from_me"))
                                .setTime(object.getString("time"))
                                .build();

                        mListener.onFetchProgress(itemDataModel);
                    }
                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }
                mListener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }
}
