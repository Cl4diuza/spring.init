package th.co.aware.etda.ws.dopa.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;



@Entity
@Table(name = "post")
public class Post {
 
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
 
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("createdDate")
    private List<Comment> comments;
    
    public void addComment(Comment comment) {
		comment.setPost(this);
		this.comments.add(comment);
	}
    
    
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
 
    public List<Comment> getComments() {
        return comments;
    }
 
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
 
    public UserAccount getCreatedUser() {
        return createdUser;
    }
 
    public void setCreatedUser(UserAccount createdUser) {
        this.createdUser = createdUser;
    }
 
     
}
