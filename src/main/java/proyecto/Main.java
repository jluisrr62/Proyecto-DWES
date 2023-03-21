package proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import proyecto.persistence.TablasBD;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		TablasBD tablas = new TablasBD();
//		tablas.crearTablas();
		
		SpringApplication.run(Main.class, args);
	}

}
