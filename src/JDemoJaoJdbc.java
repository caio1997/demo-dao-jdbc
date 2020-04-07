
import java.sql.Date;
import model.entities.Department;
import model.entities.Seller;

public class JDemoJaoJdbc {
    public static void main(String[] args) {
        Date data = new Date(System.currentTimeMillis());
        Department dep = new Department(1, "Books");
               
        Seller seller = new Seller(1,"Caio","caio_mcoelho@hotmail.com",data,3000,dep);
        
        System.out.println(dep);
        System.out.println(seller);
    }
    
}
