package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    
    public Page<User> findAll(Pageable pageable);
    
    public List<User> findByFirstnameOrderByFirstnameAsc(String firstname);

    public List<User> findByFirstname(String firstname);

    public List<User> findByLastname(String lastname, Sort sort);

}
