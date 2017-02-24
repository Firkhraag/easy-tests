package easytests.mappers;

import easytests.config.DatabaseConfig;
import easytests.entities.IssueStandardQuestionTypeOption;
import easytests.entities.IssueStandardQuestionTypeOptionInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

/**
 * @author SingularityA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:database.test.properties"})
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {DatabaseConfig.class})
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/mappersTestData.sql")
public class IssueStandardQuestionTypeOptionTest {

    @Autowired
    private IssueStandardQuestionTypeOptionMapper questionTypeOptionMapper;

    @Test
    public void findTest() {
        final IssueStandardQuestionTypeOptionInterface questionTypeOption = this.questionTypeOptionMapper.find(1);

        Assert.assertEquals((Integer) 1, questionTypeOption.getId());
        Assert.assertEquals((Integer) 1, questionTypeOption.getQuestionTypeId());
        Assert.assertEquals((Integer) 1, questionTypeOption.getMinQuestions());
        Assert.assertEquals(null, questionTypeOption.getMaxQuestions());
        Assert.assertEquals(null, questionTypeOption.getTimeLimit());
        Assert.assertEquals((Integer) 1, questionTypeOption.getIssueStandardId());
    }

    @Test
    public void findByIssueStandardIdTest() {
        final List<IssueStandardQuestionTypeOption> questionTypeOptions
                = this.questionTypeOptionMapper.findByIssueStandardId(1);

        Assert.assertEquals(3, questionTypeOptions.size());

        IssueStandardQuestionTypeOptionInterface questionTypeOption = questionTypeOptions.get(2);
        Assert.assertEquals((Integer) 3, questionTypeOption.getId());
        Assert.assertEquals((Integer) 3, questionTypeOption.getQuestionTypeId());
        Assert.assertEquals((Integer) 5, questionTypeOption.getMinQuestions());
        Assert.assertEquals((Integer) 10, questionTypeOption.getMaxQuestions());
        Assert.assertEquals(null, questionTypeOption.getTimeLimit());
        Assert.assertEquals((Integer) 1, questionTypeOption.getIssueStandardId());
    }

    @Test
    public void deleteTest() {
        IssueStandardQuestionTypeOptionInterface questionTypeOption = this.questionTypeOptionMapper.find(1);
        Assert.assertNotNull(questionTypeOption);
        this.questionTypeOptionMapper.delete(questionTypeOption);
        questionTypeOption = this.questionTypeOptionMapper.find(1);
        Assert.assertNull(questionTypeOption);
    }
}
