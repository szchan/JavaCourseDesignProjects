import java.sql.*;

public class DBConnecter {
    static Boolean tableNext = null;
    static String tableDate = "";
    //连接数据库
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //初始化驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //与位于服务器的mysql数据库建立连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel?characterEncoding=UTF-8","root", "cszcszcsz");
            //接收异常
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void reservatRoom(String sql, String date, String username) throws SQLException {
        Connection conn = null;
        //初始化PreStatement
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            //给占位符赋值
            pstmt.setString(1,date);
            pstmt.setString(2,username);
            //执行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
    }

    public static void cancelreservatRoom(String sql, String date) throws SQLException {
        //和数据库取得连接
        Connection conn = null;
        //初始化PreStatement
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            //给占位符赋值
            pstmt.setString(1,date);
            //执行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
    }

    public static Boolean userQueryRoom(String sql, String date) throws SQLException {
        Boolean state = null;
        Connection conn = null;
        PreparedStatement pstmt= null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,date);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();
            if (!resultSet.next()){
                state = true;
            }else{
                state = false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
        return state;
    }

    public static Boolean queryUser (String username, String password) throws SQLException {
        Boolean state = null;
        String sql = "SELECT username FROM user WHERE username = ? AND password = ?";
        Connection conn = null;
        PreparedStatement pstmt= null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                state = true;
            }else{
                state = false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
        return state;
    }

    public static void addUser(String username, String password) throws SQLException {
        String sql = "insert into user (username,password) values (?,?)";
        //和数据库取得连接
        Connection conn = null;
        //初始化PreStatement
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            //给占位符赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //执行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
    }

    public static void addWaiter(String username, String password) throws SQLException {
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        String sql = "insert into waiter (username,password) values (?,?)";
        //和数据库取得连接
        Connection conn = null;
        //初始化PreStatement
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            //给占位符赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //执行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
    }

    public static Boolean tableQuery() throws SQLException {
        //String preparedRoom = "room_"+room;
        String sql = "Select date, username from room_101";
        Connection conn = null;
        PreparedStatement pstmt= null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1,preparedRoom);
            //pstmt.setString(2,date);
            pstmt.executeQuery();
            ResultSet resultSet = pstmt.executeQuery();
            tableNext = resultSet.next();
            tableDate = resultSet.getString("date");
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            assert pstmt != null;
            pstmt.close();
            conn.close();
        }
        return tableNext;
    }
}

