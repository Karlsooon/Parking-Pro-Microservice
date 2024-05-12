package com.almasova.googlePlacesAPI.mapper;

import com.almasova.googlePlacesAPI.model.dto.ParkingRequest;
import com.almasova.googlePlacesAPI.model.dto.ParkingResponse;
import com.almasova.googlePlacesAPI.model.entity.Parking;
import com.almasova.googlePlacesAPI.service.impl.GooglePlacesApiServiceImpl;
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

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "current", constant = "0"),
            @Mapping(target = "commentList", ignore = true)
    })
    Parking toParking(ParkingRequest parkingRequest);


    ParkingRequest toParkingRequest(Parking parking);

    @Mapping(target = "commentList", ignore = true)
    List<ParkingRequest> toParkingRequestList(List<Parking> parkings);

    @Mappings({
            @Mapping(target = "current", source = "parking.current", defaultValue = "0"),
            @Mapping(target = "commentResponseList", source = "commentList")// Set current to 0 if null
    })
    ParkingResponse toParkingResponse(Parking parking);

    @Mapping(target = "commentResponseList", source = "commentList")
    List<ParkingResponse> toParkingResponseList(List<Parking> parkings);

    @Mappings({
            @Mapping(target = "current", source = "parkingResponse.current", defaultValue = "0"),
            @Mapping(target = "commentList", source = "commentResponseList")// Set current to 0 if null
    })
    Parking toParking(ParkingResponse parkingResponse);

    @Mapping(target = "commentResponseList", source = "commentList")
    List<Parking> toParkingList(List<ParkingResponse> parkingResponses);

    List<Parking> fromLatLngToParkingList(List<GooglePlacesApiServiceImpl.LatLong> latLongList);
}
