package easytests.entities;

import easytests.entities.test.CommonFieldsInterface;

//Test POJO Class
public class Test implements CommonFieldsInterface {

    private long id;
    private String testName;
    private User user;
    private long ownerId;

    protected Test(){}

    public Test(String testName) {
        this.testName = testName;
    }

    public Test(String testName, long ownerId) {
        this.testName = testName;
        this.ownerId = ownerId;
    }

    public Test(long id, String testName) {
        this.id = id;
        this.testName = testName;
    }

    @Override
    public String getTestName() { return this.testName; }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public User getUser() {
        return this.user;
    }

}
