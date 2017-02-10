package easytests.controllers;

import easytests.entities.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import easytests.dao.TestDAO;
import java.util.List;

@Controller
public class TestsController {

    @RequestMapping("/tests")
    @ResponseBody
    public static void main(String[] args) throws Exception {
        TestDAO testService = new TestDAO();
        //testService.addTest(new Test("Test1", 2));
        //System.out.println("---Data inserted---");
        List<Test> tests =  testService.getAllTests();
        tests.forEach(test->System.out.println("id:"+test.getId()+", testName:"+test.getTestName()+", OwnersFirstName:"+test.getUser().getFirstName()+", OwnersLastName:"+test.getUser().getLastName()));
    }

}