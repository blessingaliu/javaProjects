package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringMasteryApplication {

	// DI using XML (added dependency to pom.xml and config in applicationContext.xml)
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// controller from bean
		FlooringController controller = context.getBean("controller", FlooringController.class);

		controller.runApplication();
	}

}
