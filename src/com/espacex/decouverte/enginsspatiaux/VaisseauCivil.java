package com.espacex.decouverte.enginsspatiaux;

public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(TypeVaisseau type){
        this.type = type;
        if (type==TypeVaisseau.CARGO ) {
            this.tonnageMax = 500;
        } else if (type==TypeVaisseau.VAISSEAU_MONDE ) {
            this.tonnageMax = 2000;
    }

};


    VaisseauCivil(TypeVaisseau type, int blindage, int resistanceBouclier){
        this.type = type;
        this.blindage=blindage;
        this.resistanceDuBouclier=resistanceBouclier;
    }

    @Override
    public int emporterCargaison(int cargaison) {
        int tonnageRestant=tonnageMax - tonnageActuel;
        if (cargaison > tonnageRestant){
            tonnageActuel = tonnageMax;
            return cargaison - tonnageRestant;
        } else {
            tonnageActuel = tonnageActuel + cargaison;
            return 0;
        }
    }

}
