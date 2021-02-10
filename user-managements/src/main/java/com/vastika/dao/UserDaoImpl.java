package com.vastika.dao;



import com.vastika.util.DbUtil;
import com.vastika.util.QueryUtil;
import com.vastika.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public int saveUser(User user) {
        int saved = 0;
        try {
            PreparedStatement ps = DbUtil.getConnection().prepareStatement(QueryUtil.SAVE_SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setDouble(4, user.getSalary());
            ps.setDate(5, Date.valueOf(user.getDob()));
            ps.setBoolean(6, user.isEnable());
            saved = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }

    @Override
    public int updateUser(User user) {
        int updated = 0;
        try {
            PreparedStatement ps = DbUtil.getConnection().prepareStatement(QueryUtil.UPDATE_SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setDouble(4, user.getSalary());
            ps.setDate(5, Date.valueOf(user.getDob()));
            ps.setBoolean(6, user.isEnable());
            ps.setInt(7, user.getId());
            updated = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public int deleteUser(int id) {
        int deleted = 0;
        try {
            PreparedStatement ps = DbUtil.getConnection().prepareStatement(QueryUtil.DELETE_SQL);
            ps.setInt(1, id);
            deleted = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        try {
            PreparedStatement ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_USER_BY_ID_SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId((rs.getInt("id")));
                user.setUsername((rs.getString("user_name")));
                user.setPassword((rs.getString("password")));
                user.setDob((rs.getDate("dob").toLocalDate()));
                user.setMobileNo((rs.getLong("mobileNO")));
                user.setEnable((rs.getBoolean("enable")));
                user.setSalary((rs.getDouble("salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
       List<User> userList = new ArrayList<>();
        try{
            PreparedStatement ps = DbUtil.getConnection().prepareStatement(QueryUtil.LIST_SQL);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                User user= new User();

                user.setId((rs.getInt("id")));
                user.setUsername((rs.getString("user_name")));
                user.setPassword((rs.getString("password")));
                user.setDob((rs.getDate("dob").toLocalDate()));
                user.setMobileNo((rs.getLong("mobileNO")));
                user.setEnable((rs.getBoolean("enable")));
                user.setSalary((rs.getDouble("salary")));

                userList.add(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }
}
