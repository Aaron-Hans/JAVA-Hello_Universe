package com.espacex.decouverte.enginsspatiaux;

public enum TypeVaisseau {
    CHASSEUR("Chasseur"),
    FREGATE("Frégate"),
    CROISEUR("Croiseur"),
    CARGO("Cargo"),
    VAISSEAU_MONDE("Vaisseau-Monde");

    String nomTypeVaisseau;

    TypeVaisseau(String nomTypeVaisseau){
        this.nomTypeVaisseau = nomTypeVaisseau;
    }
}
