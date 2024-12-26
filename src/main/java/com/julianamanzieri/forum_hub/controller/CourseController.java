package com.julianamanzieri.forum_hub.controller;

import com.julianamanzieri.forum_hub.domain.course.Course;
import com.julianamanzieri.forum_hub.domain.course.CourseDTO;
import com.julianamanzieri.forum_hub.domain.course.CourseDetails;
import com.julianamanzieri.forum_hub.domain.course.CourseRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerCourse(@RequestBody @Valid CourseDTO courseDTO, UriComponentsBuilder builder) {
        var course = new Course(courseDTO);
        courseRepository.save(course);
        var uri = builder.path("/topics/{id}").buildAndExpand(course.getId()).toUri();
        var dto = new CourseDetails(course);
        return ResponseEntity.created(uri).body(dto);
    }
}
