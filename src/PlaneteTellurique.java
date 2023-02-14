public class PlaneteTellurique extends Planete implements Habitable{

    int totalVisiteurs;
    Vaisseau[][] baieDaccostage;


    PlaneteTellurique(String nom,long diametre,int TailleBaie){
        super(nom,diametre);
        this.baieDaccostage =new Vaisseau[TailleBaie][TailleBaie];
    }

    public boolean restePlaceDisponible(Vaisseau vaisseau){
        int indexZone =0;
        switch (vaisseau.type){
            case CARGO:
            case VAISSEAU_MONDE:
                indexZone = 1;
        }
        for (int index =0; index<baieDaccostage[indexZone].length; index++){
            if (baieDaccostage[index][indexZone] == null){
                return true;
            }
        }
        return false;
    }

    @Override
    public void acceuillirVaisseaux(Vaisseau... vaisseaux) {
        for (int indexVaisseau=0; indexVaisseau<vaisseaux.length; indexVaisseau++){

            int indexZone =0;
            switch (vaisseaux[indexVaisseau].type){
                case CARGO:
                case VAISSEAU_MONDE:
                    indexZone = 1;
            }

            if (restePlaceDisponible(vaisseaux[indexVaisseau]) == true) {

                for (int index=0; index<baieDaccostage[indexZone].length; index++){
                    if (baieDaccostage[indexZone][index] == null){
                        baieDaccostage[indexZone][index] = vaisseaux[indexVaisseau];
                        break;
                    }

                if (vaisseaux[indexVaisseau] instanceof VaisseauDeGuerre){
                    VaisseauDeGuerre vaisseauTransfomerEnVaisseauDeGuerre =(VaisseauDeGuerre)vaisseaux[indexVaisseau];
                    vaisseauTransfomerEnVaisseauDeGuerre.desctiverArmes(vaisseauTransfomerEnVaisseauDeGuerre.armesDesactivees);
                }

                totalVisiteurs = totalVisiteurs + vaisseaux[indexVaisseau].nbPassagers;

                }


            }
        }




    }
}
