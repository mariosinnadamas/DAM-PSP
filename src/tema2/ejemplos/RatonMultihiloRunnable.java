package tema2.ejemplos;
/*
La ventaja que tiene esto es que si por ejemplo tienes vaca que extiende
de animal asi puedes hacer hilos de las distintas clases hijas
*/

public class RatonMultihiloRunnable implements Runnable {
	
	private String nombre;
	private int tiempoAlimentacion;

	public RatonMultihiloRunnable(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		
		try {
			System.out.println("El rat�n "+ nombre +" ha comenzado a alimentarse");
			Thread.sleep(tiempoAlimentacion*1000);
			System.out.println("El rat�n "+nombre+" ha terminado de alimentarse");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.comer();
	}

	public static void main(String[] args) {
		RatonMultihiloRunnable fievel=new RatonMultihiloRunnable("Fievel",4);
		RatonMultihiloRunnable jerry=new RatonMultihiloRunnable("Jerry",5);
		RatonMultihiloRunnable pinky=new RatonMultihiloRunnable("Pinky",3);
		RatonMultihiloRunnable mickey=new RatonMultihiloRunnable("Mickey",6);
        //Los objetos runnable se convierten en objetos Thread para iniciar su ejecución
        //Importante en lugar de .run usar .start envolviendo en Thread
		new Thread(fievel).start();
		new Thread(jerry).start();
		new Thread(pinky).start();
		new Thread(mickey).start();

        //De esta forma funciona de manera secuencial, porque espera a que acabe un hilo para empezar otro
        /*
        fievel.run();
        jerry.run();
        pinky.run();
        mickey.run();
        */
	}
}
