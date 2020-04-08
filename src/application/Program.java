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

    }
}
