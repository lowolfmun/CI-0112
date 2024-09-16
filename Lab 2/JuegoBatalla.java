import java.util.Scanner;
public class JuegoBatalla{
    Robot[] listaRobots;
    int cantidadDeRobots;
    public JuegoBatalla(){
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Cuantos robots quiere crear? (Min 2,Max 10)"+"\n");
            cantidadDeRobots = scanner.nextInt();
            if(cantidadDeRobots>=2&&cantidadDeRobots<=10){
                salir = true;
            }
            else if(cantidadDeRobots>2){
                System.out.println("Cantidad de robots insuficiente"+"\n");
            }
            else if(cantidadDeRobots>10){
                System.out.println("Cantidad de robots superior a la solicitada"+"\n");
            }
        }while(salir==false);
        listaRobots = new Robot[cantidadDeRobots];
        for(int i = 0;i<cantidadDeRobots;++i){
            listaRobots[i] = new Robot();
        }
    }

    public void iniciarBatalla(){
        int cantVivos;
        do{
            cantVivos=0;
            for(int i = 0;i<cantidadDeRobots;++i){
                boolean robotVivo = listaRobots[i].estaVivo();
                if(robotVivo == true){
                    ++cantVivos;
                }
                int robotRandom = (int)(Math.random()*cantidadDeRobots);
                boolean vivo = listaRobots[robotRandom].estaVivo();
                if(vivo == true && i != robotRandom){
                    listaRobots[i].atacar(listaRobots[robotRandom]);
                }
            }
        }while(cantVivos!=1);
    }
    
    public void mostrarGanador(){
        for(int i=0;i<cantidadDeRobots;++i){
            boolean robotVivo = listaRobots[i].estaVivo();
            if(robotVivo == true){
                System.out.println("El ganador es "+listaRobots[i].nombre);
            }
        }
    }
    
    
    public static void main(String[] args) {
        JuegoBatalla juego =new JuegoBatalla();
        juego.iniciarBatalla();
        juego.mostrarGanador();
    }
    
}