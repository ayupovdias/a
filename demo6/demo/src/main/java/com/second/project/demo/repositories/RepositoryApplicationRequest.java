package com.second.project.demo.repositories;

import com.second.project.demo.entity.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RepositoryApplicationRequest extends JpaRepository<ApplicationRequest, Long> {
}
