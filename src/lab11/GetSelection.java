package lab11;

import java.sql.*;


public class GetSelection {
    private Connection connection;


    public GetSelection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getFilmsRangeDate(Date dateStart, Date dateEnd){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from films where date between ? and ?");
            statement.setDate(1, dateStart);
            statement.setDate(2, dateEnd);
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getActorsOnFilm(String filmName){
        try {
            PreparedStatement statement = connection.prepareStatement("select actors.id, actors.name from actors join films_actors fa on actors.id = fa.actor_id join films on fa.film_id = films.id where films.name = ?");
            statement.setString(1, filmName);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getActorsWhoWhereDirectors(){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT actors.id, actors.name FROM actors" +
                    "               JOIN films_actors ON actors.id = films_actors.actor_id " +
                    "               JOIN films ON films_actors.film_id = films.id " +
                    "               JOIN producers ON films.producer_id = producers.id " +
                    "               WHERE actors.name IN (SELECT DISTINCT producers.name FROM producers)");

            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean geleteFilmsOlderThanYears(int years){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM films WHERE DATEDIFF(CURRENT_DATE, films.date) > ? * 365");
            statement.setInt(1, years);
            return statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
