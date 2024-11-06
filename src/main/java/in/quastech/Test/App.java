package in.quastech.Test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.quastech.bean.Employees;
import in.quastech.mapper.EmployeeRowMapper;
import in.quastech.resource.SpringConfigFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbcTemplate=context.getBean(JdbcTemplate.class);
        
        Scanner sc=new Scanner(System.in);
        int x;String sql;int count;
        try {
        do {
        	System.out.println("Enter your choice");
        System.out.println("1.Add Employees\n2.Get All Employees\n3.Delete Employee\n4.Update Employee\n5.Get By Location");
        int n=sc.nextInt();
        if(n>0&&n<6) {}
        switch(n) {
        case 1:{
        System.out.println("Enter EmployeeId:");
        int Empid=sc.nextInt();
        System.out.println("Enter EmployeeName:");
        String Empname=sc.next();
        System.out.println("Enter Employee Salary:");
        double Empsalary=sc.nextDouble();
        System.out.println("Enter Employee Department:");
        String department=sc.next();
        System.out.println("Enter the location:");
        String location=sc.next();
        
         sql="insert into emp values(?,?,?,?,?)";
        
        count=jdbcTemplate.update(sql, Empid,Empname, Empsalary, department, location);
        
        if(count>0) {
        	System.out.println("Row inserted");
        }else {
        	System.out.println("Row not inserted");
        }
        }
        break;
        
        case 2:{
        	 sql="select * from emp";
        	 List<Employees>list=jdbcTemplate.query(sql, new EmployeeRowMapper());
        	 for(Employees li:list) {
        		 System.out.println("Employee Id:"+li.getEmpid());
        		 System.out.println("Employee Name:"+li.getEmpname());
        		 System.out.println("Employee Salary:"+li.getEmpsalary());
        		 System.out.println("Department:"+li.getDepartment());
        		 System.out.println("Location:"+li.getLocation());
        		 System.out.println("-----------------------------");
        	 }
        }
        	 break;
        	 
        case 3:{
        	System.out.println("Enter the Employee Id to delete the record:");
        	int Empid=sc.nextInt();
        	sql="delete from emp where Empid=?";
        	count=jdbcTemplate.update(sql,Empid);
        	if(count>0) {
        		System.out.println("Data deleted successfully");
        	}else {
        		System.out.println("Data not deleted");
        	}
        }
        	break;
        case 4:{
        	System.out.println("Enter the Employee Id to update the employee:");
        	int Empid=sc.nextInt();
        	 System.out.println("Enter EmployeeName:");
             String Empname=sc.next();
             System.out.println("Enter Employee Salary:");
             double Empsalary=sc.nextDouble();
             System.out.println("Enter Employee Department:");
             String department=sc.next();
             System.out.println("Enter the location:");
             String location=sc.next();
        	sql="update emp set Empname=?, Empsalary=?, department=?, location=? where Empid=?";
        	count=jdbcTemplate.update(sql, Empname,Empsalary,department, location,Empid);
        	if(count>0) {
        		System.out.println("Data updated successfully.");
        	}else {
        		System.out.println("Data not updated");
        	}
        }
        break;
        case 5:{
        	System.out.println("Enter the location to get that location employees:");
        	String location=sc.next();
        	sql="select * from emp where location=?";
        	List<Employees>list=jdbcTemplate.query(sql,new EmployeeRowMapper(),location);
        	for(Employees li:list) {
        		System.out.println("Employee Id:"+li.getEmpid());
        		System.out.println("Employee Name:"+li.getEmpname());
        		System.out.println("Employee Salary:"+li.getEmpsalary());
        		System.out.println("Department:"+li.getDepartment());
        		System.out.println("Location:"+li.getLocation());
        		System.out.println("----------------------------");
        	}
        	
        }
        break;
        default:System.out.println("Enter a valid number!!!");
        
        	
        }
        System.out.println("Do you want to continue");
        System.out.println("Enter 1 to continue 2 to discontinue:");
        x=sc.nextInt();
        }while(x==1);
        System.out.println("Thank you for visiting");
        }catch(Exception e) {
        	System.out.println("Entry Invalid!!!");
        }
        
        
    }
}
