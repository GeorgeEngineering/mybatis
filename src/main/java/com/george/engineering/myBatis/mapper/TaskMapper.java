package com.george.engineering.myBatis.mapper;

import com.george.engineering.myBatis.model.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT * FROM TASK")
    List<Task> selectAll();

    @Insert("INSERT INTO TASK(DESCRIPTION,PRIORITY) VALUE(#{description},#{priority})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()" ,
        keyProperty = "id",
        before = false,
        resultType = Integer.class
    )
    void insert(Task task);
}
