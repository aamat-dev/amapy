package fr.aamat.view;

public enum Vues {
    MenuPrincipal("MenuPrincipal"),
    Ruche("Ruche"),
    Connection("Connection");

    private String name = "";

    //Constructeur
    Vues(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
