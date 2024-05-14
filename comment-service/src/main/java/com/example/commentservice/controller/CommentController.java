package com.example.commentservice.controller;


import com.example.commentservice.feign.ParkingFeignClient;
import com.example.commentservice.service.CommentService;
import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;
import com.example.parkingproutils.resttemplate.ParkingRestBuilder;
import com.example.parkingproutils.webclient.ParkingWebClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;
    private final ParkingRestBuilder parkingRestBuilder;
    private final ParkingWebClientBuilder parkingWebClientBuilder;
    private final ParkingFeignClient parkingFeignClient;
    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAllComments(){
        return ResponseEntity.ok(commentService.findAll());
    }
    @GetMapping("/info/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.findById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Comment> create(@RequestBody CommentRequest commentRequest){
        long parkingId = commentRequest.getParkingId();
//        if(parkingWebClientBuilder.parkingExist(parkingId)){
//            return ResponseEntity.ok(commentService.create(commentRequest));
//        }
        if(parkingFeignClient.getParking(parkingId)!=null){
            return ResponseEntity.ok(commentService.create(commentRequest));
        }

        return new ResponseEntity("parking with id %s not found".formatted(parkingId), HttpStatus.NOT_ACCEPTABLE);

    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CommentRequest commentRequest){
        commentService.update(commentRequest, id);
        return ResponseEntity.ok("updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        commentService.delete(id);
        return ResponseEntity.ok("Comment with id: " + id + " was deleted");
    }
    @GetMapping("/parking/{id}")
    public ResponseEntity<List<CommentResponse>> getCommentsOfParking(@PathVariable long id){
        return ResponseEntity.ok(commentService.getCommentsOfParking(id));
    }
}
