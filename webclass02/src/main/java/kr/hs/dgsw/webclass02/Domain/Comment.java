package kr.hs.dgsw.webclass02.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor // public Comment(){}
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private String content;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modified;
    private String storedPath;
    private String originalName;

    public Comment(long userId, String comment, String storedPath, String originalName){
        this.userId = userId;
        this.content = comment;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }

    public Comment(Comment c){
        this.id = c.getId();
        this.userId = c.getUserId();
        this.content = c.getContent();
        this.created = c.getCreated();
        this.modified = c.getModified();
        this.storedPath = c.getStoredPath();
        this.originalName = c.getOriginalName();
    }
}