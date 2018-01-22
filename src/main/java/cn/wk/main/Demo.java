package cn.wk.main;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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


}
