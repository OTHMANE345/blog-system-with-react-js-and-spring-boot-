
package com.Blog.Wrapper;
        import org.springframework.web.multipart.MultipartFile;

public class Productwrapper  {


    private String description;
    private String UserId;

    private String name;

    private MultipartFile image;

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}