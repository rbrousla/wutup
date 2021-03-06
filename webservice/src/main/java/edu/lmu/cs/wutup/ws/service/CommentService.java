package edu.lmu.cs.wutup.ws.service;

import java.util.List;

import edu.lmu.cs.wutup.ws.model.Comment;
import edu.lmu.cs.wutup.ws.model.PaginationData;

public interface CommentService {

    Integer addComment(int objectId, Comment comment);

    void updateComment(int objectId, Comment comment);

    List<Comment> findComments(int objectId, PaginationData pagination);

    void deleteComment(int objectId, int commentId);
}
