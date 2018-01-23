package cn.wk.Interface;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: WangKun
 * @Description:
 * @FunctionalInterface有以下特点:
 *(1)该注解只能标记"有且仅有一个抽象方法"的接口上;
 *(2)jdk1.8接口中的静态方法和默认方法,都不算抽象方法
 *(3)接口默认继承java.lang.Object,如果接口显示声明覆盖了Object中的方法,那么不算抽象方法
 *(4)该注解不是必须的,如果一个接口符合"函数式接口的定义", 那么此注解加不加都不影响最终的结果. 加上此注解
 * 能更好的让编译器进行检查.如果编写的不是函数式接口,但是加上@FunctionalInterface, 那么编译器会报错
 * @Date: Created in 2018/1/23 下午4:44
 * @ProjectName: lambda-demo
 * @Version: 1.0.0
 */
@FunctionalInterface
public interface ResultSetProcessor {

	/**
	 * 抽象方法
	 * @param resultSet
	 * @param currentRow
	 * @throws SQLException
	 */
	public void process(ResultSet resultSet, long currentRow) throws SQLException;

}
