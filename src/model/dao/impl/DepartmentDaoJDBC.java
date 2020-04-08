package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
    
      Date data = new Date(System.currentTimeMillis());
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            int rows = st.executeUpdate();
            if(rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                    DB.closeResultSet(rs);
                }
            }else{
                throw new DbException("Nothing alterated!");
            }
        }
       catch(SQLException e){
           throw new DbException(e.getMessage());
       }
       finally{
           DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Department findById(Integer id) {
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
           st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
           st.setInt(1, id);
            rs = st.executeQuery();
           if(rs.next()){
               Department obj = new Department();
               obj.setId(rs.getInt("Id"));
               obj.setName(rs.getString("Name"));
               return obj; 
           }
           return null;
       }
       catch(SQLException e){
           throw new DbException(e.getMessage());
       }
       finally{
           DB.closeStatement(st);
           DB.closeResultSet(rs);
       }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
           st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
           rs = st.executeQuery();
           
           List<Department> list = new ArrayList<>();
           
           while(rs.next()){
               Department obj = new Department();
               obj.setId(rs.getInt("Id"));
               obj.setName(rs.getString("Name"));
               list.add(obj);
           }
           return list;
           
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
   
}
