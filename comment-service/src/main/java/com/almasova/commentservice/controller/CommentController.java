package com.almasova.commentservice.controller;


import com.almasova.commentservice.service.CommentService;
import com.almasova.parkingpromodel.model.dto.CommentRequest;
import com.almasova.parkingpromodel.model.dto.CommentResponse;
import com.almasova.parkingpromodel.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;
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

        return ResponseEntity.ok(commentService.create(commentRequest));
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
