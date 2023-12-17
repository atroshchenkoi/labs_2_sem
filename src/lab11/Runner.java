package lab11;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        GetSelection getSelection = new GetSelection(ConnectionCreator.getConnection());
        Date dateStart = Date.valueOf("2015-1-1");
        Date dateEnd = Date.valueOf("2020-1-1");
        ResultSet set = getSelection.getFilmsRangeDate(dateStart, dateEnd);
        try {
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name").trim();
                Date date = set.getDate("date");
                int producer_id = set.getInt("producer_id");
                System.out.println("id : " + id
                        + "\nname : " + name
                        + "\ndate : " + date.toString()
                        + "\nproducer_id : " + producer_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet set2 = getSelection.getActorsOnFilm("Слово пацана");
        try {
            while (set2.next()) {
                System.out.println("1");
                int id = set2.getInt("id");
                String name = set2.getString("name").trim();
                System.out.println("id : " + id
                        + "\nname : " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResultSet set3 = getSelection.getActorsWhoWhereDirectors();
        try {
            while (set3.next()) {
                int id = set3.getInt("id");
                String name = set3.getString("name").trim();
                System.out.println("id : " + id
                        + "\nname : " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getSelection.geleteFilmsOlderThanYears(1));
    }
}
