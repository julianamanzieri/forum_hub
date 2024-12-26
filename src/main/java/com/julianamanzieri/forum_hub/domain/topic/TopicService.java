package com.julianamanzieri.forum_hub.domain.topic;

import com.julianamanzieri.forum_hub.domain.course.Course;
import com.julianamanzieri.forum_hub.domain.course.CourseRepository;
import com.julianamanzieri.forum_hub.domain.response.DataNewResponse;
import com.julianamanzieri.forum_hub.domain.user.AuthenticationService;
import com.julianamanzieri.forum_hub.domain.user.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public Course getCourse(DataNewTopic dataNewTopic) {
        var curso = courseRepository.getCourse(dataNewTopic.course());
        if (curso == null) {
            throw new ValidationException("Course not found. Register course first!");
        }
        return getCourse();
    }

    public DataDetailsTopic getDataDetailsTopicUpdated(Long id, DataUpdateTopic dataUpdateTopic, Authentication authentication) {
        var user = authenticationService.getUser(authentication);
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty()) {
            throw new ValidationException("Topic not found!");
        }
        if (!Objects.equals(topic.get().getAuthor().getEmail(), user.getEmail())) {
            throw new ValidationException("No permission to update topic!");
        }
        topic.get().updateTopic(dataUpdateTopic);
        topicRepository.save(topic.get());
        var dataTopicUpdated = new DataDetailsTopic(topic.get());
        return dataTopicUpdated;
    }

    public DataDetailsTopic getDataDetailsTopicDeleted(Long id, Authentication authentication) {
        var user = authenticationService.getUser(authentication);
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty()) {
            throw new ValidationException("Topic not found!");
        }
        if (!Objects.equals(topic.get().getAuthor().getEmail(), user.getEmail())) {
            throw new ValidationException("No permission to update topic!");
        }
        topic.get().deleteTopic();
        topicRepository.save(topic.get());
        var dataTopicDeleted = new DataDetailsTopic(topic.get());
        return dataTopicDeleted;
    }

    public Optional<Topic> getTopico(DataNewResponse dataNewResponse) {
        var topic = topicRepository.findById(dataNewResponse.topic());
        if (topic.isEmpty()) {
            throw new ValidationException("Topic not found!");
        }
        return topic;
    }
}

