package ccm.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ccm.data.entity.DataModel;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DataModelRepo extends CrudRepository<DataModel, Integer> {
    List<DataModel> findDataModelByTime(Timestamp time);
}
