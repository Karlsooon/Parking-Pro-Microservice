package com.almasova.parkingpromodel.mapper;


import com.almasova.parkingpromodel.model.dto.CommentRequest;
import com.almasova.parkingpromodel.model.dto.CommentResponse;
import com.almasova.parkingpromodel.model.entity.Comment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentRequest toCommentRequest(Comment comment);


    Comment toComment(CommentRequest commentRequest);

    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toCommentResponseList(List<Comment> comments);
}
