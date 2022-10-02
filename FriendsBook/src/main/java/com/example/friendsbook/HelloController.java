package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
}