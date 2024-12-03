package org.example.weatherapi.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@Repository
public class City {
   private JsonNode results;
   private double generationtime_ms;
   private String name;


    public int getId() {
            JsonNode id = results.get(0);
           return id.path("id").asInt();
    }


    public double getLat(){
        JsonNode list = results.get(0);
        return list.path("latitude").asDouble();
    }
    public double getLon(){
        JsonNode list = results.get(0);
        return list.path("longitude").asDouble();

    }

    public City() {

    }

}

