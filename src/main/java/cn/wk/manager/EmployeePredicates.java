package cn.wk.manager;

import cn.wk.entity.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/1/22 下午6:55
 * @ProjectName: lambda-demo
 * @Version: 1.0.0
 */
public class EmployeePredicates {

	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}

	public static  Predicate<Employee> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}


	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
}
