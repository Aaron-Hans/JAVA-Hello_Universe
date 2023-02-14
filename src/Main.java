import java.util.Scanner;
import java.util.List;

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

        systemSolaire.planetes.add(mercure);
        systemSolaire.planetes.add(venus);
        systemSolaire.planetes.add(terre);
        systemSolaire.planetes.add(mars);
        systemSolaire.planetes.add(jupitere);
        systemSolaire.planetes.add(saturne);
        systemSolaire.planetes.add(uranus);
        systemSolaire.planetes.add(neptune);

        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAU_MONDE);

        Atmosphere atmosphereUranus=new Atmosphere();
        atmosphereUranus.tauxHydrogene=83f;
        atmosphereUranus.tauxHelium=15f;
        atmosphereUranus.tauxMethane=2.5f;
        atmosphereUranus.tauxAzote=0.0f;
        uranus.atmosphere=atmosphereUranus;


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

            System.out.println("Sur qu'elle planete tellurique voulez-vous posez: 1, 2, 3 ou 4 ?");
            int nomPlanete = sc.nextInt();
            sc.nextLine();

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

            Planete p =systemSolaire.planetes.get(nomPlanete-1);

            if (p instanceof PlaneteGazeuse){
                System.out.println("la planête selectionner n'est pas une planete Tellurique recommencez.");
                continue;
            }

            PlaneteTellurique planete =(PlaneteTellurique)p;

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

