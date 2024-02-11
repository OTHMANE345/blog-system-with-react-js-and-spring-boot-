
package com.Blog.Wrapper;
        import org.springframework.web.multipart.MultipartFile;

        import javax.persistence.Column;

public class productwrapperfordisplay  {

    private Integer id;
    private String description;
    private String UserId;

    private String name;

    private String Username;

    private String image;

    public productwrapperfordisplay() {

    }

    public productwrapperfordisplay(Integer id, String description, String userId, String name, String username, String image) {
        this.id = id;
        this.description = description;
        UserId = userId;
        this.name = name;
        Username = username;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}