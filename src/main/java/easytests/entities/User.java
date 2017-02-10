package easytests.entities;
import easytests.entities.user.CommonFieldsInterface;
import java.util.ArrayList;
import java.util.List;

//User POJO Class
public class User implements CommonFieldsInterface {

    private long id;
    private String firstName;
    private String lastName;
    private String surname;
    private List<Test> tests = new ArrayList<Test>();

    protected User(){}

    public User(String firstName, String lastName, String surname) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    public User(long id, String firstName, String lastName, String surname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public List<Test> getTests() { return tests; }

}
