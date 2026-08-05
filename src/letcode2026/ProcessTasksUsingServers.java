package letcode2026;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProcessTasksUsingServers {

    public record Tupla(int valor, int indice) {
    }

    public record Triplet(int duracion, Tupla tupla){
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {

        Queue<Tupla> serverQueue = new PriorityQueue<>(
                Comparator.comparingInt(Tupla::valor)
                        .thenComparingInt(Tupla::indice)
        );

        Queue<Triplet> serverInUse = new PriorityQueue<>(
                Comparator.comparingInt(Triplet::duracion)
        );


        int[] ans = new int[tasks.length];
        int index = 0;
        int currentTime = 0;

        for (int server : servers) {
            serverQueue.add(new Tupla(server, index));
            index++;
        }

        index = 0;
        while(index < tasks.length){
            currentTime = Math.max(currentTime, index);
            if(!serverInUse.isEmpty()){
                //revisamos si algun server de inUse ya se libero y podemos moverlos al serverQueue
                while(!serverInUse.isEmpty() && serverInUse.peek().duracion <= currentTime){
                    Triplet end = serverInUse.poll();
                    serverQueue.add(end.tupla);
                }
            }
            while(serverQueue.isEmpty()){
                currentTime = serverInUse.peek().duracion;
                while(!serverInUse.isEmpty() && serverInUse.peek().duracion <= currentTime){
                    Triplet end = serverInUse.poll();
                    serverQueue.add(end.tupla);
                }
            }
            Tupla tup = serverQueue.poll();
            int duration = tasks[index]+currentTime;
            serverInUse.add(new Triplet(duration,tup));
            ans[index] = tup.indice;
            index++;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(assignTasks(new int[]{3,3,2}, new int[]{1,2,3,2,1,2})));
    }
}
