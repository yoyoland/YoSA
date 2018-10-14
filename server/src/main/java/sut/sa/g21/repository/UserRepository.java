package sut.sa.g21.repository;
import sut.sa.g21.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface UserRepository extends JpaRepository<User, Long> {
        User findByUserId(long userId);
}