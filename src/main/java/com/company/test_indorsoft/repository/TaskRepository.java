package com.company.test_indorsoft.repository;

import com.company.test_indorsoft.entity.Task;
import io.jmix.core.repository.JmixDataRepository;

import java.util.UUID;

public interface TaskRepository extends JmixDataRepository<Task, UUID> {
}