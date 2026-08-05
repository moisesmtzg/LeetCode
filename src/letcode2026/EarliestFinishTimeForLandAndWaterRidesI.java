package letcode2026;

public class EarliestFinishTimeForLandAndWaterRidesI {
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int sizeL = landStartTime.length;
        int sizeW = waterStartTime.length;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<sizeL; i++){
            for(int j=0; j<sizeW; j++){
                // 1. Caso: Tierra (i) primero, luego Agua (j)
                // Empiezas Tierra en landStartTime[i], termina en landStartTime[i] + landDuration[i]
                int endTierra = landStartTime[i] + landDuration[i];
                // Agua empieza en max(apertura, fin de Tierra)
                int finTierraLuegoAgua = Math.max(endTierra, waterStartTime[j]) + waterDuration[j];

                // 2. Caso: Agua (j) primero, luego Tierra (i)
                // Empiezas Agua en waterStartTime[j], termina en waterStartTime[j] + waterDuration[j]
                int endAgua = waterStartTime[j] + waterDuration[j];
                // Tierra empieza en max(apertura, fin de Agua)
                int finAguaLuegoTierra = Math.max(endAgua, landStartTime[i]) + landDuration[i];

                // El mejor tiempo para ESTA pareja específica
                int mejorDeEstaPareja = Math.min(finTierraLuegoAgua, finAguaLuegoTierra);

                // Actualizamos el mínimo global
                min = Math.min(min, mejorDeEstaPareja);
            }
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(earliestFinishTime(new int[]{2,8},new int[]{4,1},new int[]{6}, new int[]{3}));
    }
}
