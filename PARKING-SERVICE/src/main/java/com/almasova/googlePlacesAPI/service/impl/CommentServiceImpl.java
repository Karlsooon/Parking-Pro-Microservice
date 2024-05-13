package com.almasova.googlePlacesAPI.service.impl;

import com.almasova.googlePlacesAPI.exception.CommentNotFoundException;
import com.almasova.googlePlacesAPI.exception.ParkingNotFoundException;

import com.almasova.googlePlacesAPI.repository.CommentRepository;
import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import com.almasova.googlePlacesAPI.service.CommentService;

import com.example.paringproentity.mapper.CommentMapper;
import com.example.paringproentity.mapper.ParkingMapper;
import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;
import com.example.paringproentity.model.entity.Parking;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;

    @Override
    public List<CommentResponse> findAll() {
        List<CommentResponse> commentResponses = commentMapper.toCommentResponseList(commentRepository.findAll());
        return commentResponses;
    }

    @Override
    public CommentResponse findById(Long id) {
        Comment comment = get(id);
        return commentMapper.toCommentResponse(comment);

    }

    @Override
    public Comment create(CommentRequest commentRequest) {
        Parking parking = parkingRepository.findById(commentRequest.getParkingId()).orElseThrow(()->new ParkingNotFoundException(commentRequest.getParkingId()));
        if(parking!=null) {
            Comment comment = commentMapper.toComment(commentRequest);
            comment.setCreatedAt(LocalDateTime.now());
            return commentRepository.save(comment);
        }
        else{
            return null;
        }
    }

    @Override
    public void update(CommentRequest commentRequest, Long id) {
        Comment exictedComment = get(id);
        Comment updatedComment=commentMapper.toComment(commentRequest);
        updatedComment.setId(exictedComment.getId());
        updatedComment.setParkingId(exictedComment.getParkingId());
        updatedComment.setCreatedAt(LocalDateTime.now());
         commentRepository.save(updatedComment);
    }

    @Override
    public void delete(Long id) {
        Comment comment = get(id);
        commentRepository.deleteById(id);
    }

    @Override
    public Comment get(Long id){
        return commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException(id));
    }

    @Override
    public List<CommentResponse> getCommentsOfParking(Long id){
        List<Comment> comments  = commentRepository.findAllByParkingId(id);
        List<CommentResponse> commentResponses = commentMapper.toCommentResponseList(comments);
        return commentResponses;
    }
}
