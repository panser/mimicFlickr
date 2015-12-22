package ua.org.gostroy.mimicFlickr.web.model.criteria;

/**
 * Created by Sergey on 12/22/2015.
 */
public class PhotoCriteria {

    private String name = "%";
    private String description = "%";

    public PhotoCriteria() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = "%" + name + "%";
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(!description.isEmpty()) {
            this.description = "%" + description + "%";
        }
    }
}
