package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.Issue;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssueRepository extends MongoRepository<Issue, String> {

    public List<Issue> findByAuthor(String author);
}
