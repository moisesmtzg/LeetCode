package letcode2026;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num){
        Map<Integer, Character> mp = new HashMap<>();
        mp.put(1,'I');
        mp.put(5,'V');
        mp.put(10,'X');
        mp.put(50,'L');
        mp.put(100,'C');
        mp.put(500,'D');
        mp.put(1000,'M');

        StringBuilder sb = new StringBuilder();

        int aux = 0;
        while(num > 0){
            System.out.println(num);
            if (num > 1000){
                int mnum = num/1000;
                char m = mp.get(1000);
                while (aux < mnum){
                    sb.append(m);
                    num -=1000;
                    aux++;
                }
            }
            System.out.println(num);
            if(num > 900){
                int sc = num/900;
                char m = mp.get(1000);
                char c = mp.get(100);
                aux = 0;
                while(aux < sc){
                    sb.append(c);
                    sb.append(m);
                    num -=900;
                    aux++;
                }
            }
            System.out.println(num);
            if(num > 500){
                int dnum = num/500;
                char d = mp.get(500);
                aux = 0;
                while(aux < dnum){
                    aux++;
                    sb.append(d);
                    num-=500;
                }
            }
            System.out.println(num);
            if(num > 400){
                int dnum = num/400;
                char c = mp.get(100);
                char d = mp.get(500);
                aux = 0;
                while(aux < dnum){
                    aux++;
                    sb.append(c);
                    sb.append(d);
                    num-=400;
                }
            }
            System.out.println(num);
            if(num >100){
                int cnum = num/100;
                char c = mp.get(100);
                aux = 0;
                while(aux < cnum){
                    aux++;
                    sb.append(c);
                    num-=100;
                }
            }
            System.out.println(num);
            if(num >90){
                int cnum = num/90;
                char x = mp.get(10);
                char c = mp.get(100);
                aux = 0;
                while(aux < cnum){
                    aux++;
                    sb.append(x);
                    sb.append(c);
                    num-=90;
                }
            }
            System.out.println(num);
            if(num > 50){
                int lnum = num/50;
                char l = mp.get(50);
                aux = 0;
                while(aux < lnum){
                    aux++;
                    sb.append(l);
                    num-=50;
                }

            }
            System.out.println(num);
            if(num > 40){
                int lnum = num/40;
                char l = mp.get(50);
                char x = mp.get(10);
                aux = 0;
                while(aux < lnum){
                    aux++;
                    sb.append(x);
                    sb.append(l);
                    num-=40;
                }

            }
            System.out.println(num);
            if(num > 10){
                int xnum = num/10;
                char x = mp.get(10);
                aux = 0;
                while(aux < xnum){
                    aux++;
                    sb.append(x);
                    num-=10;
                }
            }
            System.out.println(num);
            if(num == 9){
                int xnum = num/9;
                char i = mp.get(1);
                char x = mp.get(10);
                aux = 0;
                while(aux < xnum){
                    aux++;
                    sb.append(i);
                    sb.append(x);
                    num-=9;
                }
            }
            System.out.println(num);
            if(num > 5){
                int vnum = num/5;
                char v = mp.get(5);
                aux = 0;
                while(aux < vnum){
                    aux++;
                    sb.append(v);
                    num-=5;
                }
            }
            System.out.println(num);
            if(num == 4){
                int inum = num/4;
                char v = mp.get(5);
                char i = mp.get(1);
                aux = 0;
                while(aux < inum){
                    aux++;
                    sb.append(i);
                    sb.append(v);
                    num-=4;
                }
            }
            System.out.println(num);
            if(num > 1){
                int inum = num;
                char i = mp.get(1);
                aux = 0;
                while(aux < inum){
                    aux++;
                    sb.append(i);
                    num-=1;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[]args){
        System.out.println(intToRoman(3749));
    }
}
