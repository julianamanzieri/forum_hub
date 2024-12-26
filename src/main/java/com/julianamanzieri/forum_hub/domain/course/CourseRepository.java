package com.julianamanzieri.forum_hub.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository  extends JpaRepository <Course, Long>{

    @Query("select c from Course c where lower(c.name) = lower(:course)")
    Course getCourse(String course);
}
