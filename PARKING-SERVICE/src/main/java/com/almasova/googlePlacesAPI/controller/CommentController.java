package com.almasova.googlePlacesAPI.controller;

import com.almasova.googlePlacesAPI.model.dto.CommentRequest;
import com.almasova.googlePlacesAPI.model.dto.CommentResponse;
import com.almasova.googlePlacesAPI.model.entity.Comment;
import com.almasova.googlePlacesAPI.service.CommentService;
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
    public ResponseEntity<String> create(@RequestBody CommentRequest commentRequest, @RequestParam double lat, @RequestParam double lng){
        commentService.create(commentRequest, lat, lng);
        return ResponseEntity.ok("created");
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
}
