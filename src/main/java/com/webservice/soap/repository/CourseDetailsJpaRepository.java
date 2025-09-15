package com.webservice.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.soap.entity.CourseDetailsEntity;

@Repository
public interface CourseDetailsJpaRepository extends JpaRepository<CourseDetailsEntity, Long> {

}
