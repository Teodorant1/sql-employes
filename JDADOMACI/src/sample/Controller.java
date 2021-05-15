package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;


public class Controller {

    @FXML
    private TextArea payload;
    @FXML
    private TextArea id;
    @FXML
    private TextArea criteria;
    @FXML
    private TextArea category;
    @FXML
    private Button displayall;
    @FXML
    private Button inputpayload;
    @FXML
    private Button deleteid;
    @FXML
    private Button parameterdisplay;
    @FXML
    private Button updateidwithpayload;
    @FXML
    private Button Deliveryzone;

    SqlMinion SqlMinion1 = new SqlMinion();

    @FXML
    private void insertemployee () throws SQLException {  String [] workerobject = payload.getText().split(",");
    SqlMinion1.insertworker(workerobject[0],Integer.parseInt(workerobject[1]) ,workerobject[2],Integer.parseInt(workerobject[3]));
    Deliveryzone.setText("uploaded" + payload.getText()+ "to the sql server"); };

    @FXML
    private void changeworker () throws SQLException {SqlMinion1.changeworker(Integer.parseInt(id.getText()),category.getText(),payload.getText());
    Deliveryzone.setText("Changed worker" + id.getText());}

    @FXML
    private void deleteemployee () throws SQLException {SqlMinion1.deleteemployee(Integer.parseInt(id.getText()));
    Deliveryzone.setText("Deleted worker" + id.getText());}

    @FXML
    private void pulleveryone() throws SQLException
    {Deliveryzone.setText(SqlMinion1.pullEveryone());}

    @FXML
    private void pullsomeone() throws SQLException
    {Deliveryzone.setText(SqlMinion1.pullsomeone(category.getText(),criteria.getText()));}



}





