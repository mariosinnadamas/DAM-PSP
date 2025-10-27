package tema2.ejemplos;

public class RatonSimple implements Runnable {
	
	private String nombre;
	private int tiempoAlimentacion;
	private int alimentoConsumido;

	public RatonSimple(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		try {
			System.out.println("El rat�n "+ nombre +" ha comenzado a alimentarse");
			Thread.sleep(tiempoAlimentacion*1000);
			alimentoConsumido++;
			System.out.println("El rat�n "+nombre+" ha terminado de alimentarse");
			System.out.println("Alimento consumido:"+alimentoConsumido);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		this.comer();
	}
    //4 hilos de ejecución de una instancia, como ejecuta los 4 termina los 4 a la vez el valor del alimento varía
    /*
	public static void main(String[] args) {
		RatonSimple fievel=new RatonSimple("Fievel",4);
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
	}
    */
    //main para varios Threads
	public static void main(String[] args) {
		RatonSimple fievel=new RatonSimple("Fievel",4);
        //Al poner numeros ya grandes se pueden quedar hilos sin ejecutar
		for (int i=0;i<100;i++){
			new Thread(fievel).start();
		}
	}
}