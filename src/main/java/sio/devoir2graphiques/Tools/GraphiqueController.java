package sio.devoir2graphiques.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphiqueController
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public GraphiqueController() {
        cnx = ConnexionBDD.getCnx();
    }
    // A vous de jouer

    public HashMap<String,Double> getGraphiqueData1()throws SQLException {
        HashMap<String,Double> dataGraph1 = new HashMap();
        cnx = ConnexionBDD.getCnx();
        ps = cnx.prepareStatement("SELECT employe.ageEmp, AVG(employe.salaireEmp)\n" +
                "FROM employe \n" +
                "GROUP BY employe.ageEmp\n" +
                "ORDER BY employe.ageEmp ASC");
        rs = ps.executeQuery();
        while (rs.next()){
            dataGraph1.put(rs.getString(1), rs.getDouble(2));
        }
        ps.close();
        rs.close();
        return dataGraph1;
    }

    public HashMap<String,Double> getGraphiqueData2()throws SQLException {
        HashMap<String,Double> dataGraph1 = new HashMap();
        cnx = ConnexionBDD.getCnx();
        ps = cnx.prepareStatement("SELECT employe.ageEmp, AVG(employe.salaireEmp)\n" +
                "FROM employe \n" +
                "GROUP BY employe.ageEmp\n" +
                "ORDER BY employe.ageEmp ASC");
        rs = ps.executeQuery();
        while (rs.next()){
            dataGraph1.put(rs.getString(1), rs.getDouble(2));
        }
        ps.close();
        rs.close();
        return dataGraph1;
    }

    public HashMap<String,Integer> getGraphiqueData3()throws SQLException {
        HashMap<String,Integer> dataGraph3 = new HashMap<>();
        cnx = ConnexionBDD.getCnx();
        ps = cnx.prepareStatement("SELECT COUNT(employe.sexe)\n" +
                "FROM employe\n" +
                "WHERE employe.sexe = \"Homme\"\n" +
                "UNION\n" +
                "SELECT COUNT(employe.sexe)\n" +
                "FROM employe\n" +
                "WHERE employe.sexe = \"Femme\"");
        rs = ps.executeQuery();
        rs.next();
        dataGraph3.put("Homme",rs.getRow());
        rs.next();
        dataGraph3.put("Femme",rs.getRow());


        ps.close();
        rs.close();
        return dataGraph3;
    }

}
