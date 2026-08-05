package letcode2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int size = positions.length;
        Robot[] robots = new Robot[size];
        for(int i =0; i< size ; i++){
            robots[i] = new Robot(i+1, healths[i], positions[i],directions.charAt(i));
        }

        Arrays.sort(robots);

        List<Robot> survivors = new ArrayList<>();
        Stack<Robot> stackRobots = new Stack<>();
        for(Robot robot: robots){
            if(robot.getDirection() == 'R'){
                stackRobots.push(robot);
            }else{
                while(!stackRobots.isEmpty() && robot.getHealth()> 0){
                    Robot robotStack = stackRobots.peek();
                    if(robot.getHealth() > robotStack.getHealth()){
                        System.out.println("L mas grande que R");
                        stackRobots.pop();
                        robot.setHealth(robot.getHealth()-1);
                    }else if(robot.getHealth() < robotStack.getHealth()){
                        System.out.println("R mas grande que L");
                        robotStack.setHealth(robotStack.getHealth()-1);
                        robot.setHealth(0);
                    }else{
                        stackRobots.pop();
                        robot.setHealth(0);
                    }
                }
                if (robot.getHealth() > 0) {
                    survivors.add(robot);
                }
            }
        }
        // 1. Agregar los que quedaron en la pila a la lista de supervivientes
        survivors.addAll(stackRobots);

        // 2. Ordenar por el ID original para cumplir con el formato de salida
        survivors.sort((a, b) -> Integer.compare(a.getId(), b.getId()));

        // 3. Extraer solo las vidas
        List<Integer> result = new ArrayList<>();
        for(Robot r : survivors){
            result.add(r.getHealth());
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(survivedRobotsHealths(new int[]{5,4,3,2,1},new int[]{2,17,9,15,10},"RRRRR"));
    }
}

class Robot implements Comparable<Robot>{
    int id;
    int health;
    int position;
    char direction;

    public Robot(int id, int health, int position, char direction){
        this.id = id;
        this.health = health;
        this.position = position;
        this.direction = direction;
    }

    public char getDirection(){
        return this.direction;
    }

    public int getPosition(){
        return this.position;
    }

    public int getHealth(){
        return this.health;
    }

    public int getId(){
        return this.id;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setPosition(int position){
        this.position = position;
    }

    @Override
    public int compareTo(Robot otherRobot) {
        int compararPos = Integer.compare(this.position, otherRobot.position);
        return compararPos;
    }

    @Override
    public String toString(){
        return "Robot id: "+this.id + " position: "+ this.position + " health:" + this.health + " direction:"+this.direction;
    }
}
