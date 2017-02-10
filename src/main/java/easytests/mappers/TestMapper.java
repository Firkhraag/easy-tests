package easytests.mappers;

import java.util.List;
import easytests.entities.Test;
import easytests.entities.User;
import org.apache.ibatis.annotations.*;

public interface TestMapper {

    @Select("SELECT id, firstname, lastname, surname FROM users WHERE id = #{id}")
    public User getUser(long id);

    @Select("SELECT id, testname, owner_id FROM tests")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "testName", column = "testname"),
            @Result(property = "user", column = "owner_id", one = @One(select = "getUser"))
    })
    public List<Test> getAllTests();

    @Select("SELECT id, testname, owner_id FROM tests WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "testName", column = "testname"),
            @Result(property = "user", column = "owner_id", one = @One(select = "getUser"))
    })
    public Test getTestById(long id);

    @Insert("INSERT INTO tests (testname, owner_id) VALUES (#{testName}, #{ownerId})")
    public void addTest(Test test);

    @Update("UPDATE tests SET testname = #{testName} WHERE id = #{id}")
    public void updateTest(Test test);

    @Delete("DELETE FROM tests WHERE id = #{id}")
    public void deleteTest(long id);

}
