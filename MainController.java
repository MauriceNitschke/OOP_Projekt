package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.w3c.dom.Document;

import OOP.BrowserTest;
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class MainController extends Application{

	
	
	public static void main(String[] args) {
		
		launch(args);
	
		
	   
			
		
	}
	
	
	 public void start(Stage primaryStage) {
	     
	 
	      WebView webView = new WebView();
	 
	      WebEngine webEngine = webView.getEngine();
	      webEngine.setJavaScriptEnabled(true);
	    
	      
	      webEngine.load("file:///C:/Users/Maurice/Documents/webpage.html");
	     
	      
	      //Eventlistener
			MainController eventlistener = new MainController();
			webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
	            if (newState == Worker.State.SUCCEEDED) {
			   
			        JSObject window = (JSObject) webEngine.executeScript ("window");
			        window.setMember ("java", eventlistener);
			        
			        
			    }
			});
	 
			Scene scene = new Scene(webView);
			
			// Titel setzen
		    primaryStage.setTitle("Buchungstool");
		 
		    // Stage anzeigen
		    primaryStage.setScene(scene);
		    primaryStage.show();
			
	 }
	 
	 public String login(String sData, String sPassword) {
		 //getting input form the js (form.username.value) -> calling  java.login(username,password);
		 
		System.out.println(sData + "; "+ sPassword);
		
		//testing if username and the respective pw are registered
		//could be done by creating a file, that stores all account infos and the respective rights...
		//test can check by looping over array/vector of this file's elements and checking...
		
		 if (sData.trim().equals("admin")&& sPassword.equals("1234")) {
			String sSuccess ="Access granted!";
			 System.out.println(sSuccess);
			 return sSuccess;
		} else {
			String sError = "Password or Username is wrong. Please try again!";
			System.out.println(sError);
			return sError;
		}
		 
	 }
	 
	 public void createAcc() {
		 System.out.println("button works");
		 
	 }
	 
}
