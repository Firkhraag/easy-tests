package easytests.controllers;

import easytests.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import easytests.dao.UserDAO;
import java.util.List;

@Controller
public class UsersController {

    @RequestMapping("/users")
    @ResponseBody
    public static void main(String[] args) throws Exception {
        UserDAO userService = new UserDAO();
        //userService.addUser(new User("Test1", "Test1", "Test1"));
        //System.out.println("---Data inserted---");
        User user = userService.getUserById(2);
        System.out.println("Tests of requested user:");
        if( user.getTests().size() == 0)
            System.out.println("None");
        else
            user.getTests().forEach(test->System.out.println("id:"+test.getId()+", testName:"+test.getTestName()));
    }

}