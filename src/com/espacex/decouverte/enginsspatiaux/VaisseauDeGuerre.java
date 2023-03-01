package com.espacex.decouverte.enginsspatiaux;

public class VaisseauDeGuerre extends Vaisseau {

    public boolean armesDesactivees = true;

    public VaisseauDeGuerre(TypeVaisseau type){
        this.type = type;
        if (type==TypeVaisseau.CHASSEUR){
            this.tonnageMax = 0;
        } else if (type==TypeVaisseau.FREGATE) {
            this.tonnageMax = 50;
        } else if (type==TypeVaisseau.CROISEUR) {
            this.tonnageMax = 100;
        }

    };

    VaisseauDeGuerre(TypeVaisseau type,int blindage,int resistanceBouclier){
        this.type = type;
        this.blindage = blindage;
        this.resistanceDuBouclier = resistanceBouclier;
    }


    void attaque(Vaisseau cibleVaisseau, String armeUtilisee, int dureeDeLattaque){
        if (armesDesactivees == true){
            System.out.println( "Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + this.type + " attaque un vaisseau de type " + cibleVaisseau.type + " en utilisant l'arme " + armeUtilisee + " pendant " + dureeDeLattaque + " minutes");

            cibleVaisseau.resistanceDuBouclier = 0;

            cibleVaisseau.blindage = cibleVaisseau.blindage / 2;
        }
    };

    public void desctiverArmes(boolean armesDesactivees){
        if (armesDesactivees == true){
            System.out.println("Désactivation des armes d'un vaisseau de type "+this.type);
        }
    }

    @Override
    void activerBouclier(){
        desctiverArmes(armesDesactivees);
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }

    @Override
    public int emporterCargaison(int cargaison) {
        if (type.equals("Chasseur")){
            return cargaison;
        } else{
            if (nbPassagers < 12){
                return cargaison;
            } else {
                int tonnagePassager=2*nbPassagers;
                int tonnageRestant=tonnageMax - tonnageActuel;
                int tonnageAConsiderer = (tonnagePassager < tonnageRestant ? tonnagePassager : tonnageRestant);
                if (cargaison>tonnageAConsiderer){
                    tonnageActuel = tonnageMax;
                    return cargaison-tonnageAConsiderer;
                } else {
                    tonnageActuel+=cargaison;
                    return 0;
                }
            }
        }
    }

    
}

