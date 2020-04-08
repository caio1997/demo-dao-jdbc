package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
