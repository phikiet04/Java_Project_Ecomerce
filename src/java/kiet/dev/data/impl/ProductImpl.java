package kiet.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import kiet.dev.data.dao.DatabaseDao;
import kiet.dev.data.dao.ProductDao;
import kiet.dev.data.driver.MySQLDriver;
import kiet.dev.data.model.Product;
import kiet.dev.util.Constants;

public class ProductImpl implements ProductDao {
    // gọi hàm kết nối csdl

    Connection con = MySQLDriver.getInstance().getConnection();

   
    @Override
    public int insert(Product product) {
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    

    @Override

    public boolean update(Product product) {
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.setInt(7, product.getId());

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                return new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> proList = new ArrayList<>();
//        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC ";
        String sql = "SELECT * FROM PRODUCTS";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        // TODO Auto-generated method stub
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> hot(int limit) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE NAME LIKE ? ORDER BY VIEW DESC ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + key + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> relatedProductList(Product product) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ? LIMIT ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, product.getCategoryId());
            stmt.setInt(2, Constants.RELATED_NUMBER);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findByCategoryOfName(int categoryId, String key) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ? AND NAME LIKE ? ORDER BY VIEW DESC";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, "%" + key + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public boolean updateView(Product product) {
        String sql = "UPDATE PRODUCTS SET view = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, product.getView() + 1);
            stmt.setInt(2, product.getId());

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> news(int limit) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY CREATED_AT DESC LIMIT ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> filterShop(String propertyName, String order) {
        List<Product> proList = new ArrayList<>();

        // Kiểm tra và đảm bảo rằng propertyName và order có giá trị hợp lệ
        String validProperty = "name"; // Giá trị mặc định
        if (propertyName.equalsIgnoreCase("price") || propertyName.equalsIgnoreCase("createdAt")) {
            validProperty = propertyName;
        }

        String validOrder = "ASC"; // Giá trị mặc định
        if (order.equalsIgnoreCase("desc")) {
            validOrder = "DESC";
        }

        String sql = "SELECT * FROM PRODUCTS ORDER BY " + validProperty + " " + validOrder;

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> filter(int categoryId, String propertyName, String order) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY " + propertyName + " " + order;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> getProducts(int from, int amount) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS LIMIT ?, ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, from);
            stmt.setInt(2, amount);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    // add paginate category
    @Override
    public List<Product> getProductsByCategory(int categoryId, int offset, int limit) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category_id = ? LIMIT ?, ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, categoryId);
            stmt.setInt(2, offset);
            stmt.setInt(3, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                products.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int countByCategory(int categoryId) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM products WHERE category_id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

//    search
    @Override
    public List<Product> findByNameAndFilter(String keyword, String property, String order) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ? ORDER BY " + property + " " + order;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");
                // Thêm vào danh sách sản phẩm
                productList.add(new Product(id, name, description, thumbnail, price, quantity, view, id, createdAt));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

}
