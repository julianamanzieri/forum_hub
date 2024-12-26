package com.julianamanzieri.forum_hub.controller;

import com.julianamanzieri.forum_hub.domain.response.DataDetailsResponse;
import com.julianamanzieri.forum_hub.domain.topic.*;
import com.julianamanzieri.forum_hub.domain.user.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    @Transactional
    public ResponseEntity createNewTopic(@RequestBody @Valid DataNewTopic dataNewTopic,
                                         UriComponentsBuilder builder, Authentication authentication) {
        var user = authenticationService.getUser(authentication);
        var course = topicService.getCourse(dataNewTopic);

        var topic = new Topic(null, dataNewTopic.title(), dataNewTopic.message(), LocalDateTime.now(), Status.OPEN, user, course, null, true);
        topicRepository.save(topic);
        var dto = new DataDetailsResponse(topic);
        var uri = builder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
