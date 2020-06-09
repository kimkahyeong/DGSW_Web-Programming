package kr.hs.dgsw.weblog.Repository;

import kr.hs.dgsw.weblog.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long>{
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);
}