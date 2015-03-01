package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.Action;
import ch.heigvd.ptl.sc.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action, String> {

    public Page<Action> findAll(Pageable pageable);
    
    public List<Action> findByAuthor(String author);

    public List<Action> findByDate(String date);

    public List<Action> findByIssueId(String issueId);
}
