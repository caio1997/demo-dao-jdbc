package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;


public class Program2 {
    public static void main(String[] args) {
         Date data = new Date(System.currentTimeMillis());
        Scanner ler = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
         System.out.println("===== TEST 1: department findById ========");
        System.out.print("Digite o id que seja pesquisar: ");;
        int resp = ler.nextInt();
        Department department = departmentDao.findById(resp);
        System.out.println(department);
        System.out.println("");
        
        System.out.println("===== TEST 2: department findAll ========");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("");
        System.out.println("===== TEST 3: department insert ========");
        System.out.print("Digite o nome do departamento: ");
        String res = ler.next();
        Department newDepartment = new Department(null,res);
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = "+ newDepartment.getId());
        
        System.out.println("");
        System.out.println("===== TEST 4: department update ========");
        System.out.print("Digite o id que deseja editar: ");
        resp = ler.nextInt();
        department = departmentDao.findById(resp);
        System.out.print("Digite o nome novo do departamento: ");
        res = ler.next();
        department.setName(res);
        departmentDao.update(department);
        
        System.out.println("");
        System.out.println("===== TEST 6: department delete ========");
        System.out.print("Digite qual id deseja excluir: ");
        resp = ler.nextInt();
        departmentDao.deleteById(resp);
        System.out.println("Delected completed");
    }
    
}
