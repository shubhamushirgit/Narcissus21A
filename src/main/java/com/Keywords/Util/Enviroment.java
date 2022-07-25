package com.Keywords.Util;

import java.io.IOException;

public class Enviroment {

	public static String getUrl(String enviroment) throws IOException {
		if (enviroment.equalsIgnoreCase("dev")) {
			return PropUtil.getEnviroment("dev.url");
		} else if (enviroment.equalsIgnoreCase("qa")) {
			return PropUtil.getEnviroment("Qa.url");
		} else if (enviroment.equalsIgnoreCase("qamarriage")) {
			return PropUtil.getEnviroment("qamarriage.url");
		} else {
			return "URL Not Found";
		}
	}

	public static String getBrowserName() throws IOException {
		return PropUtil.getEnviroment("browser");
	}

}
