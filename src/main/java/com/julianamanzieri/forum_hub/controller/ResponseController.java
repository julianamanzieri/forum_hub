package com.julianamanzieri.forum_hub.controller;

import com.julianamanzieri.forum_hub.domain.response.DataDetailsResponse;
import com.julianamanzieri.forum_hub.domain.response.DataNewResponse;
import com.julianamanzieri.forum_hub.domain.response.Response;
import com.julianamanzieri.forum_hub.domain.response.ResponseRepository;
import com.julianamanzieri.forum_hub.domain.topic.TopicService;
import com.julianamanzieri.forum_hub.domain.user.AuthenticationService;
import com.julianamanzieri.forum_hub.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/answers")
public class ResponseController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ResponseRepository respostaRepository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    @Transactional
    public ResponseEntity responderTopico(@RequestBody @Valid DataNewResponse dataNewResponse,
                                          UriComponentsBuilder builder, Authentication authentication) {
        var user = authenticationService.getUser(authentication);
        var topic = topicService.getTopic(dataNewResponse);


        var response = new Response(null, dataNewResponse.message(), topic.get(), LocalDateTime.now(), user, false);

        respostaRepository.save(response);
        var uri = builder.path("/topics/{id}").buildAndExpand(response.getId()).toUri();
        var dto = new DataDetailsResponse(response);
        return ResponseEntity.created(uri).body(dto);
    }
}
