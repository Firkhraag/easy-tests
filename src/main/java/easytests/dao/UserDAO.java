package easytests.dao;

import easytests.ConnectionFactory;
import easytests.mappers.UserMapper;
import easytests.entities.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUsers();
        session.close();
        return users;
    }
    public User getUserById(long id) throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(id);
        session.close();
        return user;
    }
    public void addUser(User user) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper mapper =session.getMapper(UserMapper.class);
        mapper.addUser(user);
        session.commit();
        session.close();
    }
    public void updateUser(User user){
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(user);
        session.commit();
        session.close();
    }
    public void deleteUser(long id){
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(id);
        session.commit();
        session.close();
    }

}
