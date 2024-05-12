package com.almasova.googlePlacesAPI.service.impl;

import com.almasova.googlePlacesAPI.exception.CommentNotFoundException;
import com.almasova.googlePlacesAPI.exception.ParkingNotFoundException;
import com.almasova.googlePlacesAPI.mapper.CommentMapper;
import com.almasova.googlePlacesAPI.mapper.ParkingMapper;
import com.almasova.googlePlacesAPI.model.dto.CommentRequest;
import com.almasova.googlePlacesAPI.model.dto.CommentResponse;
import com.almasova.googlePlacesAPI.model.entity.Comment;
import com.almasova.googlePlacesAPI.model.entity.Parking;
import com.almasova.googlePlacesAPI.repository.CommentRepository;
import com.almasova.googlePlacesAPI.repository.ParkingRepository;
import com.almasova.googlePlacesAPI.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ParkingRepository parkingRepository;
    private final ParkingMapper parkingMapper;

    @Override
    public List<CommentResponse> findAll() {
        List<CommentResponse> commentResponses = commentMapper.entitiesToResponses(commentRepository.findAll());
        return commentResponses;
    }

    @Override
    public CommentResponse findById(Long id) {
        Comment comment = get(id);
        return commentMapper.entityToResponse(comment);

    }

    @Override
    public void create(CommentRequest commentRequest, double lat, double lng) {
        Parking parking = parkingRepository.findByLatitudeAndLongitude(lat, lng);
        if(parking!=null) {
            Comment comment = commentMapper.requestToEntity(commentRequest, parkingRepository);
            comment.setParking(parking);
            comment.setCreatedAt(LocalDateTime.now());
            commentRepository.save(comment);
        }
        else{
            return;
        }
    }

    @Override
    public void update(CommentRequest commentRequest, Long id) {
        Comment exictedComment = get(id);
        Comment updatedComment=commentMapper.requestToUpdate(commentRequest);
        updatedComment.setId(exictedComment.getId());
        updatedComment.setParking(exictedComment.getParking());
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
}
