package CollegeSportsFinancing;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main extends Application {

    ArrayList<Finance> financesData = Finance.readDataFile("data/pubDataRepo.csv");

    int index = 0;
    int number1 = 100;
    double number2 = 0;

    public Main() throws IOException {
    }

    public static Map<String, Integer> getName(ArrayList<Finance> fins){
        Map<String, Integer> name = new LinkedHashMap<>();

        for(int i=0; i <= fins.size() - 1; i++){
            String first = fins.get(i).getInstnm();
            name.put(first, i);
        }

        return name;
    }

    public static Map<String, Integer> uni(){
        Map<String, Integer> rate = new LinkedHashMap<>();

        rate.put("ticket sales",0);
        rate.put("student fees",1);
        rate.put("direct state govt support",2);
        rate.put("royalties",3);
        rate.put("tv revenue",4);
        rate.put("endowments",5);
        rate.put("subsidy",6);


        return rate;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox pane = new VBox();

// Part one
        BorderPane question1 = new BorderPane();
        question1.setPadding(new Insets(50));
        question1.setStyle("-fx-background-color: #FFDEAD;");


        HBox chooseOneSchool = new HBox();
        chooseOneSchool.setPadding(new Insets(20));

        Label label1 = new Label("Choose one School");
        label1.setWrapText(true);
        label1.setFont(new Font("Arial", 18));
        chooseOneSchool.getChildren().add(label1);

        Label label2 = new Label("     Royalties: " + ReturnProfit.returnAllData(financesData.get(index))[0]
                + "                         TV Revenue: " + ReturnProfit.returnAllData(financesData.get(index))[1] + "\n"
                + "     Endowments: " + ReturnProfit.returnAllData(financesData.get(index))[2]
                + "                    Athletic Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[3] + "\n"
                + "     Other Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[4]
                + "        Net Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[5]
        );
        label2.setWrapText(true);
        question1.setRight(label2);


        ObservableList<String> options = FXCollections.observableArrayList(getName(financesData).keySet());
        final ComboBox comboBox = new ComboBox(options);

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                index = getName(financesData).get(newValue.toString());
                label2.setText("     Royalties: " + ReturnProfit.returnAllData(financesData.get(index))[0]
                        + "                         TV Revenue: " + ReturnProfit.returnAllData(financesData.get(index))[1] + "\n"
                        + "     Endowments: " + ReturnProfit.returnAllData(financesData.get(index))[2]
                        + "                    Athletic Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[3] + "\n"
                        + "     Other Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[4]
                        + "        Net Revenues: " + ReturnProfit.returnAllData(financesData.get(index))[5]
                );
            }
        });


        question1.setTop(comboBox);

        question1.setLeft(chooseOneSchool);

        pane.getChildren().add(question1);





// Part two
        VBox question2 = new VBox();
        question2.setPadding(new Insets(50));
        question2.setSpacing(10);
        question2.setStyle("-fx-background-color: #BBFFFF;");

        Label ques1 = new Label("What are the min, max, and average values of a school's new revenue?");
        ques1.setWrapText(true);
        question2.getChildren().add(ques1);

        Label ques2 = new Label("Min: " + GetNetRevenue.getMin(financesData) + "                 " +  "Max: " + GetNetRevenue.getMax(financesData) + "                 " +
                "Average: " + GetNetRevenue.getAverage(financesData));
        ques2.setWrapText(true);

        question2.getChildren().add(ques2);

        pane.getChildren().add(question2);





// Part three
        BorderPane question3 = new BorderPane();
        question3.setPadding(new Insets(50,0,0,0));
        question3.setStyle("-fx-background-color: #FFC1C1;");
        question3.setMinHeight(300);

        Label threeSchool = new Label("Which three schools have the healthiest profit models?");
        threeSchool.setWrapText(true);
        question3.setTop(threeSchool);

        Label answer = new Label("1: " + HealthyProfit.startCompare(financesData,100,0)[0] + "\n" +
                "2: " + HealthyProfit.startCompare(financesData,100,0)[1] + "\n" +
                "3: " + HealthyProfit.startCompare(financesData,100,0)[2] + "\n");
        answer.setWrapText(true);
        answer.setStyle("-fx-background-color: #FFFF00;");
        question3.setRight(answer);

        Button bt1 = new Button("Calculate");
        question3.setLeft(bt1);


        Label type = new Label("Type in your new healthyRate:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(type, textField);
        hb.setSpacing(10);


        question3.setBottom(hb);





        ObservableList<String> lad = FXCollections.observableArrayList(uni().keySet());
        final ComboBox origin = new ComboBox(lad);


        final int[] al = {0};
        origin.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue){
                number1 = uni().get(newValue.toString());
                al[0] = number1;

            }
        });

        bt1.setOnAction(e -> {
            number2 = Double.parseDouble(textField.getText());
            answer.setText("1: " + HealthyProfit.startCompare(financesData,al[0], number2)[0] + "\n" +
                    "2: " + HealthyProfit.startCompare(financesData,al[0],number2)[1] + "\n" +
                    "3: " + HealthyProfit.startCompare(financesData,al[0],number2)[2] + "\n");
        });

        question3.setCenter(origin);

        answer.setText("1: " + HealthyProfit.startCompare(financesData,number1,number2)[0] + "\n" +
                "2: " + HealthyProfit.startCompare(financesData,number1,number2)[1] + "\n" +
                "3: " + HealthyProfit.startCompare(financesData,number1,number2)[2] + "\n");




        pane.getChildren().add(question3);



// General
        primaryStage.setTitle("Final Project");
        primaryStage.setScene(new Scene(pane, 900, 900));
        primaryStage.show();


    }


    public static void main(String[] args) throws IOException {
        launch(args);






    }
}
