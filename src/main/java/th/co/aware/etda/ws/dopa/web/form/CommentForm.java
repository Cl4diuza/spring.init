package th.co.aware.etda.ws.dopa.web.form;

import javax.validation.constraints.NotEmpty;

public class CommentForm {
    private String postId;
    private String userId;
 
    @NotEmpty
    private String content;
 
    public String getPostId() {
        return postId;
    }
 
    public void setPostId(String postId) {
        this.postId = postId;
    }
 
    public String getUserId() {
        return userId;
    }
 
    public void setUserId(String userId) {
        this.userId = userId;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    @Override
    public String toString() {
        return "CommentForm [postId=" + postId + ", userId=" + userId + ", content=" + content + "]";
    }
 
}