package lab6.controller;

import lab6.domain.Review;
import lab6.dto.ReviewDto;
import lab6.mapper.AbstractMapper;
import lab6.mapper.ReviewMapper;
import lab6.service.AbstractService;
import lab6.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/reviews")
@RestController
@AllArgsConstructor
public class ReviewController extends AbstractController<Review, ReviewDto, Integer> {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;


    @Override
    protected AbstractService<Review, Integer> getService() {
        return reviewService;
    }

    @Override
    protected AbstractMapper<Review, ReviewDto> getMapper() {
        return reviewMapper;
    }
}
