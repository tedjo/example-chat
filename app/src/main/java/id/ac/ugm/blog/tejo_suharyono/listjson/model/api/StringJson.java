package id.ac.ugm.blog.tejo_suharyono.listjson.model.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by MrTejo on 27/03/2017.
 */

public class StringJson implements JsonDeserializer<String> {

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.toString();
    }
    // untuk clas stringjson ini sendiri saya kurang tau karena saya baru mempelajari parsing data dengan model MVC yg belum pernah saya pelajari.
}
