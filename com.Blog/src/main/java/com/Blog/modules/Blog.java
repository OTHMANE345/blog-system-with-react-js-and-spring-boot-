package com.Blog.modules;

import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@NamedQuery(name = "Blog.getAllBlog",query = "select c from Blog c ")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Setter
@Table(name ="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "UserId")
    private String UserId;

    @Column(name = "Username")
    private String Username;


    @Column(name = "description", length = 65555)
    private String description;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;


    public Blog() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
