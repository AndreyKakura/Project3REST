package com.kakura.springcourse;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    private static final String URL_REGISTER_SENSOR = "http://localhost:8080/sensors/registration";
    private static final String URL_ADD_MEASUREMENT = "http://localhost:8080/measurements/add";
    private static final String URL_GET_MEASUREMENTS = "http://localhost:8080/measurements";
    public static void main(String[] args) {
        String name = "TestSensor1";
        registerSensor(URL_REGISTER_SENSOR, name);

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
           addMeasurement(URL_ADD_MEASUREMENT, (random.nextDouble() * 100 - 50), random.nextBoolean(), name);
        }

        showMeasurements(URL_GET_MEASUREMENTS);

    }


    private static void registerSensor(String url, String name) {
        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("name", name);
        doPostRequest(url, jsonToSend);
    }

    private static void addMeasurement(String url, double value, boolean raining, String name) {
        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("value", value);
        jsonToSend.put("raining", raining);
        jsonToSend.put("sensor", Map.of("name", name));
        doPostRequest(url, jsonToSend);
    }

    private static void showMeasurements(String url) {
        RestTemplate restTemplate = new RestTemplate();
        MeasurementsResponse response = restTemplate.getForObject(url, MeasurementsResponse.class);

        response.getMeasurements().forEach(measurementDTO -> {
            System.out.println(measurementDTO);
        });
    }

    private static void doPostRequest(String url, Map<String, Object> jsonToSend) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);
    }
}
