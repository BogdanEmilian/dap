package com.endava.tmd.dap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DapApplication {

	public static void main(String[] args) {

		try
		{
			SpringApplication.run(DapApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
