package com.almasova.parkingpromodel.nearestParkingRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public  class LatLong{
    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    public LatLong(double lat, double lng){
        this.lat=lat;
        this.lng=lng;
    }
}
