package easytests.entities.user;

import easytests.entities.Test;
import java.util.List;

public interface CommonFieldsInterface {

    String getFirstName();
    String getLastName();
    String getSurname();
    long getId();
    List<Test> getTests();

}
