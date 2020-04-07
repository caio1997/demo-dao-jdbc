package application;

import java.sql.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Date data = new Date(System.currentTimeMillis());
        
        Department dep = new Department(1, "Books");
               
        Seller seller = new Seller(1,"Caio","caio_mcoelho@hotmail.com",data,3000,dep);
        
        SellerDao selerDao = DaoFactory.createSellerDao();
        
        System.out.println(dep);
        System.out.println(seller);
    }
}
