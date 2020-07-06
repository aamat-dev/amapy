package fr.aamat.model;

public class Ruche {

    private Integer id;
    private String nom;
    private String description;
    private Colonie colonie;

    public Ruche() {
    }

    public Ruche(Integer id, String nom, String description, Colonie colonie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.colonie = colonie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Colonie getColonie() {
        return colonie;
    }

    public void setColonie(Colonie colonie) {
        this.colonie = colonie;
    }

    @Override
    public String toString() {
        return nom;
    }
}
