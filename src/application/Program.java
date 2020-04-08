package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
         Date data = new Date(System.currentTimeMillis());
        Scanner ler = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("===== TEST 1: seller findById ========");
        System.out.print("Digite o id que seja pesquisar: ");;
        int resp = ler.nextInt();
        Seller seller = sellerDao.findById(resp);
        System.out.println(seller);
        System.out.println("");
        System.out.println("===== TEST 2: seller findDepartment ========");
        System.out.print("Digite o id do departamento que seja pesquisar: ");
        resp = ler.nextInt();
        Department dep = new Department(resp, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println("");
        System.out.println("===== TEST 3: seller findAll ========");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("");
        System.out.println("===== TEST 4: seller insert ========");
        Seller newSeller = new Seller(null, "Caio", "caioomarinhocoelho@gmail.com", data, 5000, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+ newSeller.getId());
        
        System.out.println("");
        System.out.println("===== TEST 5: seller update ========");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");
        
        
    }
}
