package dz.soljit.soljitdemo.repository;


import dz.soljit.soljitdemo.model.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<LoginResponse,Long> {


}
