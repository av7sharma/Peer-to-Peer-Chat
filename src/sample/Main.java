package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    ServerSocket server;
    Socket ssocket=null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        server = new ServerSocket(5000);
        new Thread(new Runnable() {
            @Override
            public void run() {try{
                ssocket = server.accept();//creating server socket.
                System.out.println("COnnecteed");


            }catch(Exception e){}
            }
        }).start();
        //sersocket = server.accept();
        Parent root = FXMLLoader.load(getClass().getResource("connect.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
