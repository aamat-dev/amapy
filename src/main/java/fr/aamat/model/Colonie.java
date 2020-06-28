package fr.aamat.model;

import java.util.Date;

public class Colonie {

    private Integer id;
    private String race;
    private Reine reine;
    private String description;
    private String origine;
    private Date dateCreation;
    private Date dateFin;

    public Colonie() {}

    public Colonie(Integer id, String race, Reine reine, String description, String origine, Date dateCreation, Date dateFin) {
        this.id = id;
        this.race = race;
        this.reine = reine;
        this.description = description;
        this.origine = origine;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getRace() { return race; }

    public void setRace(String race) { this.race = race; }

    public Reine getReine() { return reine; }

    public void setReine(Reine reine) { this.reine = reine; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getOrigine() { return origine; }

    public void setOrigine(String origine) { this.origine = origine; }

    public Date getDateCreation() { return dateCreation; }

    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Date getDateFin() { return dateFin; }

    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }


}
