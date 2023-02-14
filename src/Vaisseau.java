public abstract class Vaisseau {
    TypeVaisseau type;
    int nbPassagers;
    int blindage;
    int resistanceDuBouclier;
    int tonnageMax;
    int tonnageActuel;

    Vaisseau(){};



    void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type);
    };

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type);
    };
    abstract int emporterCargaison(int cargaison);
}

