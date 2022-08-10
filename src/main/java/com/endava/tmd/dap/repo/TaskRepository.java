package com.endava.tmd.dap.repo;

import com.endava.tmd.dap.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
