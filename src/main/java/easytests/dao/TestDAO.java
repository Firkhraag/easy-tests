package easytests.dao;

import easytests.ConnectionFactory;
import easytests.mappers.TestMapper;
import easytests.entities.Test;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class TestDAO {

    public List<Test> getAllTests() throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        List<Test> tests = mapper.getAllTests();
        session.close();
        return tests;
    }
    public Test getTestById(long id) throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        Test test = mapper.getTestById(id);
        session.close();
        return test;
    }
    public void addTest(Test test) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        mapper.addTest(test);
        session.commit();
        session.close();
    }
    public void updateTest(Test test){
        SqlSession session = ConnectionFactory.getSession().openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        mapper.updateTest(test);
        session.commit();
        session.close();
    }
    public void deleteTest(long id){
        SqlSession session = ConnectionFactory.getSession().openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        mapper.deleteTest(id);
        session.commit();
        session.close();
    }

}
