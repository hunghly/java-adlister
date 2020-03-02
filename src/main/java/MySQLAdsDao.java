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
        while (rs.next()) {
            returnList.add(new Ad(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4)));
        }

//        for (Ad ad : returnList) {
//            System.out.println("id: " + ad.getId());
//            System.out.println("uid: " + ad.getUserId());
//            System.out.println("title: " + ad.getTitle());
//            System.out.println("description: " + ad.getDescription());
//        }

        return returnList;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(String.format("INSERT INTO ads (user_id, title, description) VALUES ('%d', '%s', '%s')", (int) ad.getUserId(), ad.getTitle(), ad.getDescription()), Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return rs.getLong((1));
    }

//    public static void main(String[] args) throws SQLException {
//        Ads mySQLDao = DaoFactory.getAdsDao();
//        Ad ps4 = new Ad (1, "old PS4", "An old playstation 4 for sale.");
//        Ad xbox = new Ad (1, "old Xbox", "An old Xbox for sale.");
//        Ad car = new Ad (2, "2018 toyota corolla", "near mint condition vehicle!");
//        Ad backpack = new Ad (2, "army backpack", "selling for cheap!.");
////        Ads mySQLDao = DaoFactory.getAdsDao();
////        mySQLDao.insert(ps4);
////        mySQLDao.insert(xbox);
////        mySQLDao.insert(car);
////        mySQLDao.insert(backpack);
//        mySQLDao.all();
//    }
}
