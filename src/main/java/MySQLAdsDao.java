import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
        List<Ad> returnList = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ads");


        return returnList;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
