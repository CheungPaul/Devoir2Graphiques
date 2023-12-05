package sio.devoir2graphiques;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sio.devoir2graphiques.Tools.ConnexionBDD;
import sio.devoir2graphiques.Tools.GraphiqueController;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Devoir2GraphiquesController implements Initializable
{
    ConnexionBDD cnx;
    GraphiqueController graphController;

    XYChart.Series<String,Number> serieGraph1;
    @FXML
    private Button btnGraph1;
    @FXML
    private Button btnGraph2;
    @FXML
    private Button btnGraph3;
    @FXML
    private AnchorPane apGraph1;
    @FXML
    private LineChart graph1;
    @FXML
    private Label lblTitre;
    @FXML
    private AnchorPane apGraph2;
    @FXML
    private AnchorPane apGraph3;
    @FXML
    private PieChart graph3;
    @FXML
    private BarChart graph2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTitre.setText("Devoir : Graphique n°1");
        apGraph1.toFront();

        // A vous de jouer
        try{
            cnx = new  ConnexionBDD();
            graphController = new GraphiqueController();
            HashMap<String,Double> dataGraph1 = new HashMap<>();
            dataGraph1 = graphController.getGraphiqueData1();
            serieGraph1 = new XYChart.Series<>();

            for (String unAge : dataGraph1.keySet()){
                serieGraph1.getData().add(new XYChart.Data(unAge,dataGraph1.get(unAge)));
            }
            graph1.getData().add(serieGraph1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void menuClicked(Event event) throws SQLException {
        if(event.getSource() == btnGraph1)
        {
            lblTitre.setText("Devoir : Graphique n°1");
            apGraph1.toFront();

            // A vous de jouer

        }
        else if(event.getSource() == btnGraph2)
        {
            lblTitre.setText("Devoir : Graphique n°2");
            apGraph2.toFront();

            // A vous de jouer

        }
        else
        {
            lblTitre.setText("Devoir : Graphique n°3");
            apGraph3.toFront();

            // A vous de jouer

        }
    }
}