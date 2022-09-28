package Z_dao;

import Z_model.BillM;
import Z_model.ProductM;
import Z_service.ProductServiceImplementM;
import model.Bill;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImplementM implements BillDaoM{

    @Override
    public void createBillJDBC(BillM bill) {
        String sql = "INSERT INTO FinalProject.Bill VALUES (?,?,?,?,?)";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1,bill.getIdBill());
            preparedStatement.setInt(2,bill.getProduct().getIdProduct());
            preparedStatement.setInt(3,bill.getQuantityBill());
            preparedStatement.setInt(4,bill.getPriceBill());
            Date sqlDate = new Date(bill.getBuyDateBill().getTime());
            preparedStatement.setDate(5, sqlDate);
            int isCreateSuccessful = preparedStatement.executeUpdate();
            if (isCreateSuccessful>0) {
                System.out.println("Create bill successful");
            } else {
                System.out.println("Create bill unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BillM> findBillByDateJDBC(java.util.Date dateFrom, java.util.Date dateTo) {
        List<BillM> billMList = new ArrayList<>();
        String sql = "SELECT * FROM FinalProject.Bill " +
                "WHERE buyDateBill BETWEEN ? AND ? ";

        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            Date sqlDateFrom = new Date(dateFrom.getTime());
            Date sqlDateTo = new Date(dateTo.getTime());
            preparedStatement.setDate(1,sqlDateFrom);
            preparedStatement.setDate(2,sqlDateTo);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
                ProductM productMOfBillM = productServiceImplementM.findByIdProduct(resultSet.getInt(2));

                BillM billM = new BillM(resultSet.getInt(1),productMOfBillM, resultSet.getInt(3)
                        ,resultSet.getInt(4),resultSet.getDate(5));
                billMList.add(billM);
            }
            return billMList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<BillM> printAllBillJDBC() {
        List<BillM> billMList = new ArrayList<>();
        String sql = "SELECT * FROM FinalProject.Bill";
        JDBCConnectionM jdbcConnectionM = new JDBCConnectionM();
        try (PreparedStatement preparedStatement = jdbcConnectionM.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductServiceImplementM productServiceImplementM = new ProductServiceImplementM();
                ProductM productMOfBillM = productServiceImplementM.findByIdProduct(resultSet.getInt(2));

                BillM billM = new BillM(resultSet.getInt(1),productMOfBillM,resultSet.getInt(3)
                ,resultSet.getInt(4),resultSet.getDate(5));
                billMList.add(billM);
            }
            return billMList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
