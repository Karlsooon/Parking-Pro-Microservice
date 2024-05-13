package com.almasova.commentservice.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Long id){
        super("Comment with id: %s was not found".formatted(id));
    }
}
