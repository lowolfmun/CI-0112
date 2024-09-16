import java.util.Scanner;
public class Robot{
    String nombre;
    int puntosDeVida;
    int ataque;
    int defensa;
    public Robot(){
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del robot: ");
        nombre = scanner.nextLine();
        do{
            System.out.println("Ingrese la cantidad de vida al robot (Min: 50,Max: 100): "+"\n");
            puntosDeVida = scanner.nextInt();
            if(puntosDeVida>49 && puntosDeVida<101){
                salir = true;
            }
            else if(puntosDeVida<50){
                System.out.println("La candidad de vida es inferior al minimo solicitado"+"\n");
            }
            else if(puntosDeVida>100){
                System.out.println("La cantidad de vida es superior al maximo solicitado"+"\n");
            }
        }while(salir==false);
        salir = false;
        do{
            System.out.println("Ingrese la cantidad de ataque del robot (Min: 10,Max: 20): "+"\n");
            ataque = scanner.nextInt();
            if(ataque>9 && ataque<21){
                salir = true;
            }
            else if(ataque<10){
                System.out.println("La candidad de ataque es inferior al minimo solicitado"+"\n");
            }
            else if(ataque>20){
                System.out.println("La cantidad de ataque es superior al maximo solicitado"+"\n");
            }
        }while(salir==false);
        salir=false;
        do{
        System.out.println("Ingrese la cantidad de defensa del robot (Min: 0, Max: 10): "+"\n");
        defensa = scanner.nextInt();
            if(defensa>=0 && defensa<11){
                salir = true;
            }
            else if(defensa<0){
                System.out.println("La candidad de defensa es inferior al minimo solicitado"+"\n");
            }
            else if(defensa>10){
                System.out.println("La cantidad de defensa es superior al maximo solicitado"+"\n");
            }
        }while(salir==false);
        System.out.println("Robot: "+nombre+"\n"+"Vida: "+puntosDeVida+"\n"+"Ataque: "+ataque+"\n"+"Defensa: "+defensa+"\n"+"\n");
    }

    public void atacar(Robot otroRobot){
        if(puntosDeVida!=0 && otroRobot.puntosDeVida != 0){
            otroRobot.puntosDeVida = otroRobot.puntosDeVida - (ataque-otroRobot.defensa);
            System.out.println(nombre+" ataco a "+otroRobot.nombre);
        }
    }
    public boolean estaVivo(){
        boolean vivo = false;
        if(puntosDeVida>0){
            vivo = true;
        }      
        return vivo;
    }
}