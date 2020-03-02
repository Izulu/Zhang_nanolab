package dao;

import bean.User;
import bean.bookingevent;
import utils.DBUtil;
import utils.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventBookingDAO {

    public void add(bookingevent be){
        try {
            Connection c = DBUtil.getConnection();
            String sql = "insert into bookingevents values(null, ?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,be.getUser().getId());
            ps.setString(2,be.getInstrumentName());
            ps.setTimestamp(3, DateUtil.util2sql(be.getStartTime()));
            ps.setTimestamp(4, DateUtil.util2sql(be.getEndTime()));
            ps.setString(5, be.getComment());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                be.setId(rs.getInt(1));
            }
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<bookingevent> list(User user){
        List<bookingevent> result = new ArrayList<>();
        int uid = user.getId();
        try{
            Connection c = DBUtil.getConnection();
            String sql = "select * from bookingevents where uid=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,uid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bookingevent be = new bookingevent();
                be.setId(rs.getInt("id"));
                be.setUser(user);
                be.setStartTime(rs.getTimestamp("startTime"));
                be.setEndTime(rs.getTimestamp("endTime"));
                be.setInstrumentName(rs.getString("instrumentName"));
                be.setComment(rs.getString("comment_"));
                result.add(be);
            }
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void delete(bookingevent be){
        try {
            Connection c = DBUtil.getConnection();
            String sql = "delete from bookingevents where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,be.getId());
            ps.execute();
            ps.close();
            c.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventBookingDAO ebd = new EventBookingDAO();
        User u = new User();
        u.setId(1);
        List<bookingevent> bookingeventList = ebd.list(u);
        for(bookingevent be : bookingeventList){
            System.out.println(be.getId());
            System.out.println(be.getStartTime());
            System.out.println(be.getEndTime());
        }
   }
}
