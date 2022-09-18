package com.xww.springboot.control;

import com.xww.springboot.dao.EmployeeDao;
import com.xww.springboot.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    EmployeeDao dao  = new EmployeeDao();

    //访问员工管理页面
    @GetMapping(value = "/emps")
    public String list(Model model){

        Collection<Employee> all = dao.getAll();
        model.addAttribute("employee",all);
        return "employee/list";
    }

    //添加员工表单
    @GetMapping("/emp")
    public String toAddEmployee(){
        return "employee/add";
    }
}
