package cn.wk.lambda01;

import org.junit.Test;

import java.util.Arrays;
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
}
