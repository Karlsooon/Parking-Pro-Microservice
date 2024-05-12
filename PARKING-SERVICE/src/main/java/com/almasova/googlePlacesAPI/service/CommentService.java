package com.almasova.googlePlacesAPI.service;

import com.almasova.googlePlacesAPI.model.dto.CommentRequest;
import com.almasova.googlePlacesAPI.model.dto.CommentResponse;
import com.almasova.googlePlacesAPI.model.dto.ParkingResponse;
import com.almasova.googlePlacesAPI.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<CommentResponse> findAll();
    CommentResponse findById(Long id);
    void create(CommentRequest commentRequest, double lat, double lng);
    void update(CommentRequest commentRequest, Long id);
    void delete(Long id);
    Comment get(Long id);
}
