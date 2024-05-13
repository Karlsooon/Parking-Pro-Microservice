package com.example.commentservice.service.impl;


import com.example.commentservice.exception.CommentNotFoundException;
import com.example.commentservice.repository.CommentRepository;
import com.example.commentservice.service.CommentService;
import com.example.paringproentity.mapper.CommentMapper;
import com.example.paringproentity.mapper.ParkingMapper;
import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
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
            Comment comment = commentMapper.toComment(commentRequest);
            comment.setCreatedAt(LocalDateTime.now());
            return commentRepository.save(comment);
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
