package com.example.commentservice.service;


import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;

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
