package com.example.paringproentity.mapper;


import com.example.paringproentity.model.dto.CommentRequest;
import com.example.paringproentity.model.dto.CommentResponse;
import com.example.paringproentity.model.entity.Comment;
import com.example.paringproentity.model.entity.Parking;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentRequest toCommentRequest(Comment comment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Comment toComment(CommentRequest commentRequest);

    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toCommentResponseList(List<Comment> comments);
}
