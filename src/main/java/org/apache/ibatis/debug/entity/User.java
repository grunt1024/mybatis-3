package org.apache.ibatis.debug.entity;

import lombok.Data;

/**
 * @author : zhanghua
 * @date : 2023/1/29
 */
@Data
public class User {

	private Long id;

	private String name;

	private Integer age;

	private String address;

	private String email;
}
