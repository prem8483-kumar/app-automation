package co.huru.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;

public abstract class AppiumUtils {

	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
					.withIPAddress(ipAddress).usingPort(port).build();
				service.start();
				return service;
	}

}
