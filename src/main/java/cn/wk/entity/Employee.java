package cn.wk.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/1/22 下午6:25
 * @ProjectName: lambda-demo
 * @Version: 1.0.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

	private static final long serialVersionUID = -4263033530964856654L;

	private Integer id;

	private Integer age;

	private String gender;

	private String fName;

	private String lName;
}
