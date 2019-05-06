package com.ucsdextandroid1.snapmap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActiveUserLocationResponseDeserializer implements JsonDeserializer<ActiveUserLocationResponse> {
    @Override
    public ActiveUserLocationResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        ActiveUserLocationResponse response = new ActiveUserLocationResponse();

        List<UserLocationData> locations = new ArrayList<>();

        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()){
            UserLocationData locationData = context.deserialize(entry.getValue(), UserLocationData.class);

            locationData.setUserId(entry.getKey());
            locations.add(locationData);
        }

        response.setUserLocations(locations);

        return response;
    }
}
