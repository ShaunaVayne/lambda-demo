package cn.wk.main;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/1/22 下午3:03
 * @ProjectName: lambda-demo
 * @Version: 1.0.0
 */
public class Demo {

	@Test
	public void test() {
		String[] str = new String[]{"a","b","c","d"};

		Stream.of(str).forEach(e -> {
			System.out.println(e);
		});

		int[] ints = {1, 2, 3, 4, 5};
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		Arrays.stream(ints).forEach(e -> {
			System.out.println(e);
		});

		Integer[] integers = {1, 2, 3, 4, 5};
		Stream.of(integers).forEach(e -> {
			System.out.println(e);
		});
	}

	/**
	 * 实现Runnable线程
	 * 使用() -> {} 代替匿名类
	 */
	@Test
	public void test2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("before java 1.8");
			}
		}).start();
		// lambda
		new Thread( () -> {
			System.out.println("java 1.8 lambda");
		}
		).start();
	}

	/**
	 * 实现事件处理
	 */
	@Test
	public void test3() {
		JButton show = new JButton("show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("without lambda expression is boring");
			}
		});

		// java 8 lambda
		show.addActionListener((e) -> {
			System.out.println("Action !! Lambda expressions Rocks");
		});
	}

	/**
	 * 遍历集合
	 */
	@Test
	public void test4() {
		List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		list.stream().forEach(e -> {
			System.out.println(e);
		});
		list.forEach(e -> {
			System.out.println(e);
		});
		list.forEach(System.out::println);
	}

	/**
	 * 方法的引用   ::
	 */
	@Test
	public void test5() {
		List<String> list = Arrays.asList("alpha", "beta");
		list = list.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
		System.out.println(list);

		List<String> list1 = Arrays.asList("bbda", "ccsd");
		list1 = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(list1);
	}

	@Test
	public void test6() {
		List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		//filter(list, (str)->str.startsWith("J"));
	}

	/**
	 * 实现map
	 */
	@Test
	public void test7() {
		List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
		list.stream().map((e) -> e + .12 * e).forEach(System.out::println);
	}

	/**
	 * 实现reduce(); reduce()是将集合中所有值结合成一个, 类似于sql中的sum(),avg(),count()等
	 */
	@Test
	public void test8() {
		List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
		Double aDouble = list.stream().map((e) -> e + .12 * e).reduce((sum, e) -> sum + e).get();
		System.out.println("total:"+aDouble);
		Double aDouble1 = (list.stream().map((e) -> e + .12 * e).reduce((sum, e) -> sum + e).get()) / list.size();
		System.out.println("average:"+aDouble1);
	}

	/**
	 * 输出语句跟python的写法一模一样, 我天.
	 */
	@Test
	public void test9() {
		List<String> list = Arrays.asList("abc", "de", "ijk", "xyz");
		List<String> list1 = list.stream().filter(e -> e.length() > 2).collect(Collectors.toList());
		System.out.printf("list :%s , list1: %s %n", list,list1);
	}

	/**
	 * 将字符串转大写,使用逗号拼接组成一个String, 用Collectors.joining("")方法
	 */
	@Test
	public void test10() {
		List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K", "Canada");
		String collect = list.stream().map(e -> e.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(collect);
	}

	/**
	 *  通过复制不同的值创建一个子列表:
	 *  使用stream的distinct()方法过滤集合的元素
	 */
	@Test
	public void test11() {
		List<Integer> list = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> list1 = list.stream().map(e -> e * e).distinct().collect(Collectors.toList());
		System.out.printf("list1 : %s", list1);
	}

	/**
	 * 一个api就能搞定所有:
	 * mapToInt(e -> e).summaryStatistics();
	 */
	@Test
	public void test12() {
		List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics statistics = list.stream().mapToInt(e -> e).summaryStatistics();
		System.out.printf("max: %s %n", statistics.getMax());
		System.out.printf("min: %s %n", statistics.getMin());
		System.out.printf("average: %s %n", statistics.getAverage());
		System.out.printf("sum: %s %n", statistics.getSum());
		new Thread(() -> System.out.println("-----------")).start();
		Integer integer = list.stream().reduce((sum, e) -> sum + e).get();
		System.out.println("sum2:"+integer);
	}

}
