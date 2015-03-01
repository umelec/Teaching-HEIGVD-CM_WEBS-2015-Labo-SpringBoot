package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IssueRepository extends MongoRepository<Issue, String> {
    
        public Page<Issue> findAll(Pageable pageable);
    
	public List<Issue> findByAuthor(String author);
        
        public List<Issue> findByDateBetween(String start, String end);
        
        public List<Issue> findByIssueType(String issueType);
        
        @Query("{'status' : 'unsolved'}")
        public List<Issue> findUnsolved();
        
        
        
        

}