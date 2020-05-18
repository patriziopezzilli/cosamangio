package com.cosamangio.service;

import com.cosamangio.dto.LatLong;
import com.cosamangio.here.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Action;
import java.util.*;

@Service
public class LocalizationService {

    private static final String curl = "https://geocoder.ls.hereapi.com/6.2/geocode.json";
    private static final String hereApiKey = "UpekVGfyI9C_HMgfAYGorsM0RXrQ2qAqPokKTHRMWJM";

    @Autowired
    private RestTemplate restTemplate;

    private List<String> latitudes = new ArrayList<String>();
    private List<String> longitudes = new ArrayList<String>();

    public LatLong getPosition(String address) {
        latitudes.clear();

        LatLong latLong = new LatLong(0.0, 0.0);
        try {
            ResponseEntity<String> hereResponse = restTemplate.getForEntity(curl + "?searchtext=" + address + "&apiKey=" + hereApiKey, String.class);

            if (hereResponse.getStatusCode().equals(HttpStatus.OK)) {
                JsonParser p = new JsonParser();
                check(p.parse(hereResponse.getBody()));

                latLong = new LatLong(
                        Double.parseDouble(latitudes.get(0)),
                        Double.parseDouble(longitudes.get(0))
                );

                System.out.print("> [SUCCESS] position found " + latLong);
            }
        } catch (Exception e) {
            System.out.println("> [ERROR] failed to retrieve position caused by " + e.getLocalizedMessage());
        }

        return latLong;
    }

    private void check(JsonElement jsonElement) {

        if (jsonElement.isJsonArray()) {
            for (JsonElement jsonElement1 : jsonElement.getAsJsonArray()) {
                check(jsonElement1);
            }
        } else {
            if (jsonElement.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> entrySet = jsonElement
                        .getAsJsonObject().entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    String key1 = entry.getKey();
                    if (key1.equals("Latitude")) {
                        latitudes.add(entry.getValue().toString());
                    } else if (key1.equals("Longitude")) {
                        longitudes.add(entry.getValue().toString());
                    }
                    check(entry.getValue());
                }
            } else {
                if (jsonElement.toString().equals("Latitude")) {
                    latitudes.add(jsonElement.toString());
                } else if (jsonElement.toString().equals("Longitude")) {
                    longitudes.add(jsonElement.toString());
                }
            }
        }
    }
}
