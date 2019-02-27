package th.co.aware.etda.ws.dopa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment {
 
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;
 
    @Column
    private String content;
 
    @Column(name = "createddate")
    private Timestamp createdDate;
 
    @ManyToOne
    @JoinColumn(name = "createduser")
    private UserAccount createdUser;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
	@JsonIgnore
    private Post post;
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public Timestamp getCreatedDate() {
        return createdDate;
    }
 
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
 
    public UserAccount getCreatedUser() {
        return createdUser;
    }
 
    public void setCreatedUser(UserAccount createdUser) {
        this.createdUser = createdUser;
    }

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
    
    
 
}