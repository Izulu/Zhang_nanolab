package dao;

import bean.User;
import utils.DBUtil;

import java.sql.*;

public class UserDAO {
    public User getUser(String name, String password){
        User result = null;
        try{
            Connection c = DBUtil.getConnection();
            String sql = "select * from user where name=? and password=?";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = new User();
                result.setName(name);
                result.setPassword(password);
                result.setId(rs.getInt("id"));
            }
            ps.close();
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void regist(User u){
        try{
            Connection c = DBUtil.getConnection();
            String sql = "insert into user values(null,?,?)";
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,u.getName());
            ps.setString(2,u.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                u.setId(rs.getInt(1));
            }
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(User u){
        try{
            Connection c = DBUtil.getConnection();
            String sql = "delete from user where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,u.getId());
            ps.execute();
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User u, String new_passwd){
        try{
            Connection c = DBUtil.getConnection();
            String sql = "update user set password=? where name=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, new_passwd);
            ps.setString(2, u.getName());
            ps.execute();
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        UserDAO ud = new UserDAO();
//        User user = ud.getUser("admin","password");
//        System.out.println("AdminUser: ");
//        System.out.println(user);
//        User u1 = ud.getUser("LiuXuan","admin");
////        ud.regist(u);
//        System.out.println("OldUser: ");
//        System.out.println(u1);
//        ud.delete(u1);
    }
}
