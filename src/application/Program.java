package application;

import java.sql.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Date data = new Date(System.currentTimeMillis());
        
        SellerDao sellerDao = DaoFactory.createSellerDao();  
        
        Seller seller = sellerDao.findById(3);
        
       
        System.out.println(seller);
    }
}
