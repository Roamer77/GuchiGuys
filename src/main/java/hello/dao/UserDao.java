package hello.dao;

import hello.entitiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserDao  extends CrudRepository<UserEntity,Long> {

}
