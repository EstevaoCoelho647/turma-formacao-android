package br.com.cast.turmaformacao.taskmanager.model.entities;

/**
 * Created by Administrador on 17/09/2015.
 */
public class Label {
    private Long id;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +

                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Label() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (id != null ? !id.equals(label.id) : label.id != null) return false;
        if (name != null ? !name.equals(label.name) : label.name != null) return false;
        return !(description != null ? !description.equals(label.description) : label.description != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Label(Long id) {

        this.id = id;
    }
}
