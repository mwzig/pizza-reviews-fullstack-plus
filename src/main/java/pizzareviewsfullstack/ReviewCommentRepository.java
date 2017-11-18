package pizzareviewsfullstack;

import org.springframework.data.repository.CrudRepository;

public interface ReviewCommentRepository extends CrudRepository<ReviewComment, Long> {

}
