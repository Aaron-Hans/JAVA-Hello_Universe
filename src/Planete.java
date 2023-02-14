public abstract class Planete {
    String nom;
    long diametre;
    Atmosphere atmosphere;
    static String forme="Sphérique";
    static int nbPlanetesDecouvertes = 0;

    Planete(){
        nbPlanetesDecouvertes++;
    }
    Planete(String nom){
        this.nom = nom;
        nbPlanetesDecouvertes++;
    }

    Planete(String nom,long diametre){
        this.nom = nom;
        this.diametre = diametre;
    }



    int revolution(int rotation){
        int nbrTour = rotation / 360;
        return nbrTour;
    }

    int rotation(int rotation){
        int nbrTour = rotation / 360;
        return nbrTour;
    }



    static String expansion(double distance){
        if (distance < 14){
            return "Oh la la mais c'est super rapide !";
        }else{
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }


}
