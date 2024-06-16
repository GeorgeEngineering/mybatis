package com.george.engineering.myBatis.mapper;

import com.george.engineering.myBatis.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT * FROM TASK;")
    List<Task> selectAll();

    @Select("SELECT * FROM TASK WHERE ID = #{id};")
    Task selectById(@Param("id") int id);

    @Insert("INSERT INTO TASK(DESCRIPTION,PRIORITY) VALUE(#{description},#{priority});")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()" ,
        keyProperty = "id",
        before = false,
        resultType = Integer.class
    )
    void insert(Task task);

    @Update("UPDATE TASK SET DESCRIPTION = #{description}, PRIORITY = #{priority} WHERE ID = #{id};")
    void update(@Param("id") int id, @Param("description") String description, @Param("priority") int priority);

    @Delete("DELETE FROM TASK WHERE id = #{id};")
    void delete(int id);
}
