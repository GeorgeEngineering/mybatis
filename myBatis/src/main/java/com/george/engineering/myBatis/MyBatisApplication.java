package com.george.engineering.myBatis;

import com.george.engineering.myBatis.model.Task;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Task.class)
@MapperScan("com.george.engineering.myBatis.mapper")
@SpringBootApplication
public class MyBatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBatisApplication.class, args);
	}
}
