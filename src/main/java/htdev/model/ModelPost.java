package htdev.model;

public class ModelPost {
    private int id;
    private String name;
    private String slug;
    private int category;
    private String content;
    private String image;
    private String des;

    public ModelPost(int id, String name, String slug, int category, String content,String image, String des) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.category = category;
        this.content = content;
        this.image = image;
        this.des = des;
    }

    public ModelPost(String name, String slug, int category, String content,String image, String des) {
        this.name = name;
        this.slug = slug;
        this.category = category;
        this.content = content;
        this.image = image;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
