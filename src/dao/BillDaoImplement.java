package dao;

import model.Bill;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDaoImplement implements BillDao {
    @Override
    public void createBillJDBC(Bill bill) {
        try {
            String sql = "INSERT INTO BILL(id_bill, id_of_product, quantity_bill, price_bill, buy_date_bill) VALUE(?, ?, ?, ?, ?)";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, bill.getIdBill());
            preparedStatement.setInt(2, bill.getProduct().getIdProduct());
            ProductDaoImplement productDaoImplement = new ProductDaoImplement();
            if (productDaoImplement.getQuantityProductJDBC(bill.getProduct().getIdProduct()) < bill.getQuantityBill()) {
                System.out.println("Quantity of Product is not enough to buy.");
            } else {
                preparedStatement.setInt(3, bill.getQuantityBill());
                preparedStatement.setInt(4, productDaoImplement.getPriceProductJDBC(bill.getProduct().getIdProduct()) * bill.getQuantityBill());

                preparedStatement.setTimestamp(5, new java.sql.Timestamp(bill.getBuyDateBill().getTime()));

                productDaoImplement.updateQuantiTyProductJDBC(bill); // cap nhat lai quantity_product sau khi tao don hang

                System.out.println("Create BILL success !");
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Create BILL JDBC error: " + e);
        }
    }

    @Override
    public List<Bill> findBillByDateJDBC(String dateFrom, String dateTo) {
        List<Bill> billList = new ArrayList<Bill>();

        try {
            String sql = "SELECT id_bill, id_product, name_product, price_product, quantity_bill, price_bill, buy_date_bill FROM BILL INNER JOIN PRODUCT ON id_of_product = id_product WHERE buy_date_bill BETWEEN ? AND ?;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            // Format String to Date
            Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
            Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

            // Convert Date in Java to DATE in SQL
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(dateStart.getTime()));
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(dateEnd.getTime()));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_bill_resultSet = resultSet.getInt("id_bill");
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int quantity_bill_resultSet = resultSet.getInt("quantity_bill");
                int price_bill_resultSet = resultSet.getInt("price_bill");
                Date buy_date_bill_resultSet = resultSet.getDate("buy_date_bill");

                Product product = new Product(id_product_resultSet, name_product_resultSet, price_product_resultSet);
                Bill bill = new Bill(id_bill_resultSet, product, quantity_bill_resultSet, price_bill_resultSet, buy_date_bill_resultSet);

                billList.add(bill);
            }

            return billList;
        } catch (Exception e) {
            System.out.println("Find BILL by date JDBC error: " + e);
        }

        return null;
    }

    @Override
    public List<Bill> printAllBillJDBC() {
        List<Bill> billList = new ArrayList<Bill>();

        try {
            String sql = "SELECT id_bill, id_product, name_product, price_product, quantity_bill, price_bill, buy_date_bill FROM BILL INNER JOIN PRODUCT ON id_of_product = id_product;";
            JDBCConnection jdbcConnection = new JDBCConnection();
            PreparedStatement preparedStatement = jdbcConnection.getConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_bill_resultSet = resultSet.getInt("id_bill");
                int id_product_resultSet = resultSet.getInt("id_product");
                String name_product_resultSet = resultSet.getString("name_product");
                int price_product_resultSet = resultSet.getInt("price_product");
                int quantity_bill_resultSet = resultSet.getInt("quantity_bill");
                int price_bill_resultSet = resultSet.getInt("price_bill");
                Date buy_date_bill_resultSet = resultSet.getDate("buy_date_bill");

                Product product = new Product(id_product_resultSet, name_product_resultSet, price_product_resultSet);
                Bill bill = new Bill(id_bill_resultSet, product, quantity_bill_resultSet, price_bill_resultSet, buy_date_bill_resultSet);

                billList.add(bill);
            }

            return billList;
        } catch (Exception e) {
            System.out.println("Print all BILL JDBC error: " + e);
        }

        return null;
    }
}
