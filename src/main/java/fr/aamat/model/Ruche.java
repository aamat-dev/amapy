package fr.aamat.model;

public class Ruche {
    private Integer id;
    private String nom;
    private String description;
    private String emplacement;
    private Colonie colonie;
    private String urlImage;

    public Ruche() {
    }

    public Ruche(Integer id, String nom, String description, String emplacement, Colonie colonie, String urlImage) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.emplacement = emplacement;
        this.colonie = colonie;
        this.urlImage = urlImage;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Colonie getColonie() {
        return this.colonie;
    }

    public void setColonie(Colonie colonie) {
        this.colonie = colonie;
    }

    public String getEmplacement() {
        return this.emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String toString() {
        return this.nom;
    }
}
