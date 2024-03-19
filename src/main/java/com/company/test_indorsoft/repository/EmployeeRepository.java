package com.company.test_indorsoft.repository;

import com.company.test_indorsoft.entity.Employee;
import io.jmix.core.repository.JmixDataRepository;

import java.util.UUID;

public interface EmployeeRepository extends JmixDataRepository<Employee, UUID> {
}