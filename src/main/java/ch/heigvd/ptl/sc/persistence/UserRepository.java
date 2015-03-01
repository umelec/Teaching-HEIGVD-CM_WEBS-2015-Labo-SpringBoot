package ch.heigvd.ptl.sc.persistence;

import ch.heigvd.ptl.sc.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByFirstname(String firstname);

    public List<User> findByLastname(String lastname);
}
