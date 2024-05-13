package com.almasova.parkingpromodel.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor

public class CommentResponse {
    private Long id;
    private String author;
    private String text;
    private double rating;
    private LocalDateTime createdAt;

}
