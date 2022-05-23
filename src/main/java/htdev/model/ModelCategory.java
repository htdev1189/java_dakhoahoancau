package htdev.model;

public class ModelCategory {
    private int id;
    private String name;
    private String slug;
    private int parent;

    public ModelCategory(int id, String name, String slug, int parent) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.parent = parent;
    }

    public ModelCategory(String name, String slug, int parent) {
        this.name = name;
        this.slug = slug;
        this.parent = parent;
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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}

