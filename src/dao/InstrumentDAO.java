package dao;

import bean.Instrument;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDAO {

    public Instrument get(int id){
        Instrument result = new Instrument();
        try {
            Connection c = DBUtil.getConnection();
            String sql = "select * from instrument where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result.setName(rs.getString("name"));
                result.setId(id);
            }
            ps.close();
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }


    public List<Instrument> list(int start, int count){
        List<Instrument> result= new ArrayList<>();
        try{
            Connection c = DBUtil.getConnection();
            String sql = "select * from instrument order by id desc limit ?,?";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Instrument i = new Instrument();
                i.setName(rs.getString("name"));
                i.setId(rs.getInt("id"));
                result.add(i);
            }
            ps.close();
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Instrument> list(){
        return list(0, Short.MAX_VALUE);
    }

    public void add(Instrument i) {
        try {
            Connection c = DBUtil.getConnection();
            String sql = "insert into instrument values(null,?)";
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,i.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs!=null) {
                i.setId(rs.getInt(1));
            }
            ps.close();
            c.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Instrument i) {
        try {
            Connection c = DBUtil.getConnection();
            String sql = "delete from instrument where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,i.getId());
            ps.execute();
            ps.close();
            c.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Instrument i, String name) {
        try {
            Connection c = DBUtil.getConnection();
            String sql = "update instrument set name =? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,i.getId());
            ps.execute();
            ps.close();
            c.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
