package th.co.aware.etda.ws.dopa.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aware.etda.ws.dopa.entity.Comment;
import th.co.aware.etda.ws.dopa.entity.Post;
import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.PostRepository;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;
import th.co.aware.etda.ws.dopa.web.form.CommentForm;
import th.co.aware.etda.ws.dopa.web.form.PostForm;

@Service("postService")
public class PostServiceImpl implements PostService {
 
    @Autowired
    private PostRepository postRepository;
 
    @Autowired
    private UserAccountRepository userRepository;
 
    @Override
    public void save(PostForm postForm) {
        UserAccount currentUser = userRepository.findById(postForm.getUserId()).get();
        
        Post post = new Post();
        String randId = UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
        post.setId(randId);
        post.setCreatedUser(currentUser);
        post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        post.setContent(postForm.getContent());
        postRepository.save(post);
    }
 
    @Override
    public List<Post> listPost(String userId) {
        return postRepository.findByCreatedUserOrderByCreatedDateDesc(userRepository.findById(userId).get());
    }
 
    @Override
    public void saveComment(CommentForm commentForm) {
        Post post = postRepository.findById(commentForm.getPostId()).get();
        if (post == null) {
            throw new IllegalArgumentException("Not found this post");
        } else {
            if (post.getComments() == null) {
                post.setComments(new ArrayList<>());
            }
 
            UserAccount commentUser = userRepository.findById(commentForm.getUserId()).get();
 
            Comment comment = new Comment();
            String randId = UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
            comment.setId(randId);
            comment.setCreatedUser(commentUser);
            comment.setContent(commentForm.getContent());
            comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            
            post.addComment(comment);
            
            postRepository.save(post);
        }
    }
 
}
