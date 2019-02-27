package th.co.aware.etda.ws.dopa.service;

import java.util.List;

import th.co.aware.etda.ws.dopa.entity.Post;
import th.co.aware.etda.ws.dopa.web.form.CommentForm;
import th.co.aware.etda.ws.dopa.web.form.PostForm;

public interface PostService {
	void save(PostForm postForm);
	
	void saveComment(CommentForm commentForm);
	
	List<Post> listPost(String userId);

}
