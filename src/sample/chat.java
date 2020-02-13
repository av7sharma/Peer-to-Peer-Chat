package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class chat {


    @FXML
    TextArea text;

    @FXML
    VBox box;

    int i=0;

    TextArea message[] = new TextArea[100];

    public void lol () throws IOException {
        System.out.println("Connected7 ");
        while(true){
            String s = connect.datain.readUTF();
            if(s!= null){
                message[i].setText(s);
                box.getChildren().add(message[i++]);
            }
        }
    }

    public void send(ActionEvent actionEvent) throws IOException {
        System.out.println("Connected6 ");
        String str = text.getText();
        if(str!=null){
            //sending message
            connect.dataout.writeUTF(str);
            System.out.println("Connected8 ");
            message[i].setText(str);
            box.getChildren().add(message[i++]);
            text.setText("");
        }
    }
}