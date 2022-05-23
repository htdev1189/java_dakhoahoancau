package htdev.model;

public class ModelPost {
    private int id;
    private String name;
    private String slug;
    private int category;
    private String content;

    public ModelPost(int id, String name, String slug, int category, String content) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.category = category;
        this.content = content;
    }

    public ModelPost(String name, String slug, int category, String content) {
        this.name = name;
        this.slug = slug;
        this.category = category;
        this.content = content;
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
