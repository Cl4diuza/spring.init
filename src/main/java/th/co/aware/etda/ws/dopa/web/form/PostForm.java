package th.co.aware.etda.ws.dopa.web.form;

import javax.validation.constraints.NotEmpty;

public class PostForm {
	 
    private String userId;
 
    @NotEmpty
    private String content;
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public String getUserId() {
        return userId;
    }
 
    public void setUserId(String userId) {
        this.userId = userId;
    }
 
    @Override
    public String toString() {
        return "PostForm [userId=" + userId + ", content=" + content + "]";
    }
 
     
}
