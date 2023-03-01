package com.espacex.decouverte;

import com.espacex.decouverte.enginsspatiaux.TypeVaisseau;
import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauCivil;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;
import com.espacex.decouverte.objetsastro.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {

        Scanner sc =new Scanner(System.in);

        Galaxie systemSolaire = new Galaxie();
        systemSolaire.nom = "Systéme solaire";

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure",4880,1);
        PlaneteTellurique venus = new PlaneteTellurique("Venus",12100,1);
        PlaneteTellurique terre = new PlaneteTellurique("Terre",12756,2);
        PlaneteTellurique mars = new PlaneteTellurique("Mars",6792,1);
        PlaneteGazeuse jupitere = new PlaneteGazeuse("Jupitere",142984);
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne",120536);
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus",51118);
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune",49532);
        mercure.distanceEtoile = 57.9f;
        venus.distanceEtoile = 108.2f;
        terre.distanceEtoile = 149.6f;
        mars.distanceEtoile = 227.9f;
        saturne.distanceEtoile = 1427.0f;
        uranus.distanceEtoile = 2877.38f;
        neptune.distanceEtoile = 4497.07f;
        jupitere.distanceEtoile = 778.3f;

        systemSolaire.planetes.add(mercure);
        systemSolaire.planetes.add(venus);
        systemSolaire.planetes.add(terre);
        systemSolaire.planetes.add(mars);
        systemSolaire.planetes.add(jupitere);
        systemSolaire.planetes.add(saturne);
        systemSolaire.planetes.add(uranus);
        systemSolaire.planetes.add(neptune);



        for(Planete nextPlanete : systemSolaire.planetes){
            System.out.println("La planete suivante est "+nextPlanete.nom);
        }



        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAU_MONDE);

        Atmosphere atmosphereMars=new Atmosphere();

        atmosphereMars.constituants.put("CO2",95f);
        atmosphereMars.constituants.put("N2",3f);
        atmosphereMars.constituants.put("AR",1.5f);
        atmosphereMars.constituants.put("NO",0.013f);

        mars.atmosphere = atmosphereMars;

        System.out.println("L'atmpsphère de Mars est composée :");

        for (Map.Entry<String, Float> constituant :mars.atmosphere.constituants.entrySet()){
            System.out.println(constituant.getValue()+"% de "+constituant.getKey());
        }




        chasseur.nbPassagers = 2;
        fregate.nbPassagers = 24;
        fregate.tonnageMax = 50;
        croiseur.nbPassagers = 24;
        cargo.nbPassagers = 20;
        vaisseauMonde.nbPassagers = 100;

        String recommencer="non";
        do{
            System.out.println("Qu'elle vaisseau voulez-vous manipulez ?");
            String nomVaisseau = sc.nextLine();

            System.out.println("Sur qu'elle planete tellurique voulez-vous posez: Mercure, Venus, Terre ou Mars ?");
            String nomPlanete = sc.nextLine();

            System.out.println("Qu'elle tonnage souhaitez-vous embarquez ?");
            int tonnage = sc.nextInt();
            sc.nextLine();

            Vaisseau vaisseau = null;

            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(nomVaisseau);

            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseau = chasseur;
                    break;

                case FREGATE:
                    vaisseau = fregate;
                    break;

                case CROISEUR:
                    vaisseau = croiseur;
                    break;

                case CARGO:
                    vaisseau = cargo;
                    break;

                case VAISSEAU_MONDE:
                    vaisseau = vaisseauMonde;
                    break;
            }
            Planete planeteSelectionner=null;
            for (Planete p : systemSolaire.planetes){
                if (p.nom.equals(nomPlanete)){
                    planeteSelectionner = p;
                    break;
                }
            }

            if (planeteSelectionner instanceof PlaneteGazeuse){
                System.out.println("la planête selectionner n'est pas une planete Tellurique recommencez.");
                continue;
            }

            PlaneteTellurique planete =(PlaneteTellurique)planeteSelectionner;

            if (!planete.restePlaceDisponible(vaisseau)){
                System.out.println("le vaiseau "+ vaisseau.type+" et bien arriver sur la baie d'accostage");
            } else {
                int rejet = vaisseau.emporterCargaison(tonnage);
                System.out.println("le rejet et de " + rejet);
            }
            System.out.println("Voulez-vous recommencer ? (oui/non)");
            recommencer = sc.nextLine();
           }

        while (recommencer.equalsIgnoreCase("oui"));
}
}

