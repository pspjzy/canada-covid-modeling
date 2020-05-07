package ccm.data.repository;

import ccm.data.entity.YesterdayFinal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YesterdayFinalRepo extends CrudRepository<YesterdayFinal,Integer> {
    YesterdayFinal findByDate(String date);
}
