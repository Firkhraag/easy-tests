package easytests.personal.dto;

import easytests.models.IssueStandardTopicPriorityModelInterface;
import javax.validation.constraints.NotNull;

import easytests.models.empty.IssueStandardModelEmpty;
import easytests.models.empty.TopicModelEmpty;
import lombok.Data;

/**
 * @author Singularity
 */
@Data
public class IssueStandardTopicPriorityDto {

    private Integer id;

    @NotNull
    private Integer topicId;

    @NotNull
    private Boolean isPreferable;

    public void map(IssueStandardTopicPriorityModelInterface topicPriorityModel) {
        this.setId(topicPriorityModel.getId());
        this.setTopicId(topicPriorityModel.getTopic().getId());
        this.setIsPreferable(topicPriorityModel.getIsPreferable());
    }

    public void mapInto(IssueStandardTopicPriorityModelInterface topicPriorityModel, Integer issueStandardId) {
        topicPriorityModel.setId(this.getId());
        topicPriorityModel.setTopic(new TopicModelEmpty(this.getTopicId()));
        topicPriorityModel.setIsPreferable(this.getIsPreferable());
        topicPriorityModel.setIssueStandard(new IssueStandardModelEmpty(issueStandardId));
    }
}
