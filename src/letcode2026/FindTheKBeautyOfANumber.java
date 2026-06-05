package letcode2026;

public class FindTheKBeautyOfANumber {

    public static int divisorSubstrings(int num, int k){
        String sNum = String.valueOf(num);
        int size = sNum.length();
        int kBeauty = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size;i++){
            //vamos poniendo numeros
            sb.append(sNum.charAt(i));
            //revisamos que hay en la ventana
            //hacemos la logica
            if(sb.toString().length() == k){
                int nAux = Integer.parseInt(sb.toString());
                if(nAux != 0 && num%nAux==0){
                    kBeauty++;
                }
                //movemos ventana
                //ya que vamos a insertar un caracter nuevo
                //solo tenemos que quitar el de inicio
                sb.deleteCharAt(0);
            }
        }
        return kBeauty;
    }

    public static void main(String[] args){
        System.out.println(divisorSubstrings(430043, 2));
    }
}
