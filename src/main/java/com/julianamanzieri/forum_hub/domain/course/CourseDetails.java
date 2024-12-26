package com.julianamanzieri.forum_hub.domain.course;

public record CourseDetails(Long id, String name, Category category) {

    public CourseDetails(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }
}
