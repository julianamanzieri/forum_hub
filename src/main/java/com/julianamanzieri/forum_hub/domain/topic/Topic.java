package com.julianamanzieri.forum_hub.domain.topic;

import com.julianamanzieri.forum_hub.domain.course.Course;
import com.julianamanzieri.forum_hub.domain.response.Response;
import com.julianamanzieri.forum_hub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Response> responses = new ArrayList<>();

    private Boolean active;

    public void updateTopic(DataUpdateTopic data) {
        if (data.title() != null && !data.title().isEmpty()) {
            this.title = data.title();
        }
        if (data.message() != null && !data.message().isEmpty()) {
            this.message = data.message();
        }
    }

    public void deleteTopic() {
        this.active = false;
    }

    public void deleteById(Long id) {
    }
}
