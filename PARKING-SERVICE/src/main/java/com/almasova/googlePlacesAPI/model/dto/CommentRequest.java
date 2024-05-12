package com.almasova.googlePlacesAPI.model.dto;

import com.almasova.googlePlacesAPI.model.entity.Parking;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class CommentRequest {
    @NotBlank
    private String author;
    @NotBlank
    private String text;
    @Min(1)
    @Max(5)
    private double rating;
    private Long parkingId;

}
