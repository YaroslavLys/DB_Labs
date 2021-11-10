package lab6.service;
import lab6.domain.Review;
import lab6.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewService extends AbstractService<Review, Integer> {
    public ReviewRepository reviewRepository;

    @Override
    protected JpaRepository<Review, Integer> getRepository() {
        return reviewRepository;
    }
}
