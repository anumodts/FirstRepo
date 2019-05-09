package com.boraji.tutorial.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
   public static void main(String[] args) {
	   System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "{}");
      SpringApplication.run(MainApp.class, args);
   }
}