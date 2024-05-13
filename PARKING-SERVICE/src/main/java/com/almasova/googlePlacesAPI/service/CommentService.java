package com.almasova.googlePlacesAPI.service;


import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<CommentResponse> findAll();
    CommentResponse findById(Long id);
    Comment create(CommentRequest commentRequest);
    void update(CommentRequest commentRequest, Long id);
    void delete(Long id);
    Comment get(Long id);
    List<CommentResponse> getCommentsOfParking(Long id);
}
