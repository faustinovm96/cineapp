package net.itinajero.app.crudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		
		contxt.close();
	}
}
