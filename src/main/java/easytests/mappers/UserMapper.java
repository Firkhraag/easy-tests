package easytests.mappers;

import java.util.List;
import easytests.entities.Test;
import org.apache.ibatis.annotations.*;
import easytests.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT id, testname, owner_id FROM tests WHERE owner_id = #{id}")
    List<Test> getTests(long id);

    @Select("SELECT id, firstname, lastname, surname FROM users")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstname"),
            @Result(property = "lastName", column = "lastname"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "tests", javaType=List.class, column = "id", many = @Many(select = "getTests"))
    })
    public List<User> getAllUsers();

    @Select("SELECT id, firstname, lastname, surname FROM users WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstname"),
            @Result(property = "lastName", column = "lastname"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "tests", javaType=List.class, column = "id", many = @Many(select = "getTests"))
    })
    public User getUserById(long id);

    @Insert("INSERT INTO users (firstname, lastname, surname) VALUES (#{firstName}, #{lastName}, #{surname})")
    public void addUser(User user);

    @Update("UPDATE users SET firstname = #{firstName}, lastname = #{lastName}, surname = #{surname} WHERE id = #{id}")
    public void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public void deleteUser(long id);

}
