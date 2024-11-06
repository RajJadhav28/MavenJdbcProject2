package in.quastech.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.quastech.bean.Employees;

public class EmployeeRowMapper implements RowMapper<Employees>{

	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employees emp=new Employees();
		emp.setEmpid(rs.getInt(1));
		emp.setEmpname(rs.getString(2));
		emp.setEmpsalary(rs.getDouble(3));
		emp.setDepartment(rs.getString(4));
		emp.setLocation(rs.getString(5));
		
		return emp;
	}

}
