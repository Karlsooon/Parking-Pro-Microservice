package com.almasova.googlePlacesAPI.model.dto;

import com.almasova.googlePlacesAPI.model.entity.Parking;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor

public class CommentResponse {
    private Long id;
    @NotBlank
    private String author;
    @NotBlank
    private String text;
    private double rating;
    private LocalDateTime createdAt;

}
