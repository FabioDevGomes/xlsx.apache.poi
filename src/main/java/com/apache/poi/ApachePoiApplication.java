package com.apache.poi;

import com.apache.controller.FileUpload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = FileUpload.class)
public class ApachePoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApachePoiApplication.class, args);
	}

}
