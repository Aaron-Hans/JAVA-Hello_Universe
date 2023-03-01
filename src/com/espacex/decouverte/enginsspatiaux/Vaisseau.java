package com.espacex.decouverte.enginsspatiaux;

public abstract class Vaisseau {
    public TypeVaisseau type;
    public int nbPassagers;
    int blindage;
    int resistanceDuBouclier;
    public int tonnageMax;
    int tonnageActuel;

    public Vaisseau(){};



    void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type);
    };

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type);
    };
    public abstract int emporterCargaison(int cargaison);
}

