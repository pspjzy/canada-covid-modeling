package test.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.data.entity.DataModel;

@Repository
public interface DataModelRepo extends CrudRepository<DataModel, Integer> {
}
