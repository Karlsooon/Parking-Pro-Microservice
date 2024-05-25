package com.example.paringproentity.mapper;


import com.example.paringproentity.model.dto.ParkingRequest;
import com.example.paringproentity.model.dto.ParkingResponse;
import com.example.paringproentity.model.entity.Parking;
import com.example.paringproentity.nearestParkingRequest.LatLong;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper(componentModel = "spring")
@Repository
public interface ParkingMapper {

    ParkingMapper INSTANCE = Mappers.getMapper(ParkingMapper.class);


//    @Mapping(target = "id", ignore = true)
    Parking toParking(ParkingRequest parkingRequest);


    ParkingRequest toParkingRequest(Parking parking);

    List<ParkingRequest> toParkingRequestList(List<Parking> parkings);


    ParkingResponse toParkingResponse(Parking parking);

    List<ParkingResponse> toParkingResponseList(List<Parking> parkings);


    Parking toParking(ParkingResponse parkingResponse);

    List<Parking> toParkingList(List<ParkingResponse> parkingResponses);

    default Parking fromLatLongToParking(LatLong latLong) {
        if (latLong == null) {
            return null;
        }

        // Implement your custom mapping logic here
        Parking parking = new Parking();
        parking.setLatitude(latLong.getLat());
        parking.setLongitude(latLong.getLng());

        // Set other properties as needed

        return parking;
    }

    List<Parking> fromLatLngListToParkingList(List<LatLong> latLongList);
}
