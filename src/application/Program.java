package application;

import java.sql.Date;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();  
        System.out.println("===== TEST 1: seller findById ========");
        System.out.println("Digite o id que seja pesquisar");
        int resp = ler.nextInt();
        Seller seller = sellerDao.findById(resp);
        
       
        System.out.println(seller);
    }
}
