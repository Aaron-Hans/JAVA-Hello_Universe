package com.espacex.decouverte.objetsastro;

import java.util.Objects;

public abstract class Planete implements  Comparable {
    public String nom;
    long diametre;
    public Atmosphere atmosphere;
    static String forme="Sphérique";
    static int nbPlanetesDecouvertes = 0;
    public Float distanceEtoile;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planete planete = (Planete) o;
        return distanceEtoile.equals(planete.distanceEtoile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceEtoile);
    }

    static String expansion(double distance){
        if (distance < 14){
            return "Oh la la mais c'est super rapide !";
        }else{
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }


    public int compareTo(Object o) {
        Planete autrePlanete=(Planete)o;
        return ((Float)distanceEtoile).compareTo(autrePlanete.distanceEtoile);
    }



}
