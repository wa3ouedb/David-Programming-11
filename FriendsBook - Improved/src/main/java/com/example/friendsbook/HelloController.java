package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {
    public Button btnSave;
    public TextField txtFieldAge;
    public TextField txtFieldPhone;
    public TextField txtFieldName;
    public ListView listFriends;
    public Label lblDetail;
    public Label lblPhone;
    public Label lblAge;
    public Button btnDelete;
    public Button btnLoadFile;
    public Button btnSaveFile;

    public Stage stage;
    public void saveFriend(ActionEvent actionEvent) {

        if (txtFieldName.getText().equals("")||txtFieldPhone.getText().equals("")||txtFieldAge.getText().equals("")){
            return;
        }

        String name = txtFieldName.getText();
        String phoneNumber = txtFieldPhone.getText();
        int age = Integer.parseInt(txtFieldAge.getText());

        Friend friend = new Friend(name, phoneNumber, age);

        listFriends.getItems().add(friend);
        txtFieldName.setText("");
        txtFieldAge.setText("");
        txtFieldPhone.setText("");
    }


    public void friendSelected(MouseEvent mouseEvent) {
        Friend friend = (Friend) listFriends.getSelectionModel().getSelectedItem();
        setSelectedFriend(friend);
    }
    public void setSelectedFriend(Friend friend){
        lblDetail.setText(friend.getName());
        lblPhone.setText("Phone #: " + friend.getPhoneNumber());
        lblAge.setText("Age: " + friend.getAge());
    }
    public void deleteFriend(ActionEvent actionEvent) {
        if (listFriends.getItems().isEmpty()){
            return;
        }
        int deleteIndex = listFriends.getSelectionModel().getSelectedIndex();
        listFriends.getItems().remove(deleteIndex);

        if (listFriends.getSelectionModel().getSelectedIndex()>=0){
            setSelectedFriend((Friend) listFriends.getSelectionModel().getSelectedItem());
        }
        else {
            lblDetail.setText("Detail");
            lblPhone.setText("Phone #");
            lblAge.setText("Age");
        }
    }
    public void loadFriendsFile(File f ) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        listFriends.getItems().clear();
        while ((line = br.readLine()) != null) {
            String  friendsParameters [] = line.split(",");
            Friend newFriend = new Friend (friendsParameters[0], friendsParameters[1],Integer.parseInt(friendsParameters[2]));
            listFriends.getItems().add(newFriend);
        }
        br.close();

    }

    public void saveFriendsFile(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        for (Object o: listFriends.getItems()) {
            Friend f = (Friend)o;
            line =  f.getName() + "," + f.getPhoneNumber() + "," + f.getAge() + "\r";
            bw.write(line);
        }
        bw.close();
    }


    public void loadFriendGroup(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null){
            loadFriendsFile(file);
        }
    }

    public void SaveFriendGroup(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser1 = new FileChooser();
        File file1 = fileChooser1.showSaveDialog(stage);
        if (file1 != null){
            saveFriendsFile(file1);
        }
    }
}