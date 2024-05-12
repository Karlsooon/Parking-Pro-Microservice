package com.almasova.googlePlacesAPI.mapper;

import com.almasova.googlePlacesAPI.model.dto.CommentRequest;
import com.almasova.googlePlacesAPI.model.dto.CommentResponse;
import com.almasova.googlePlacesAPI.model.entity.Comment;
import com.almasova.googlePlacesAPI.model.entity.Parking;
import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "parking", source = "request.parkingId", qualifiedByName = "parkingIdToParking")
    Comment requestToEntity(CommentRequest request, @Context ParkingRepository parkingRepository);

    @Mapping(target = "parking", ignore = true)
    Comment requestToUpdate(CommentRequest request);

    @Named("parkingIdToParking") // Ensure the value matches the method name
    default Parking parkingIdToParking(Long parkingId, @Context ParkingRepository parkingRepository) {
        return parkingId != null ? parkingRepository.findById(parkingId).orElse(null) : null;
    }

    CommentResponse entityToResponse(Comment comment);

    List<CommentResponse> entitiesToResponses(List<Comment> comments);

    @InheritInverseConfiguration
    Comment toComment(CommentResponse commentResponse);
}
