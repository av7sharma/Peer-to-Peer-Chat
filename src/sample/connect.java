package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class connect {


    @FXML
    TextField ip, port;

    public static DataInputStream datain=null;
    public static DataOutputStream dataout=null;
    public static ObjectOutputStream objout=null;
    public static ObjectInputStream objin=null;

    public void join(javafx.event.ActionEvent actionEvent) {
        try {
            Socket socket = new Socket(ip.getText(), Integer.parseInt(port.getText()));
            System.out.println("Connected1 ");
            dataout = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected2 ");
            datain = new DataInputStream(socket.getInputStream());
            System.out.println("Connected3 ");
            /*objin = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected4 ");
            objout = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Connected5 ");
            */Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));
            Stage stage=(Stage) ((Node)actionEvent .getSource()).getScene().getWindow();
            Scene pr = new Scene(root);
            stage.setScene(pr);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }}