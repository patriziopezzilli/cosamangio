package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static com.cosamangio.utils.CosaMangioConstants.EMAIL_HEADER;
import static com.cosamangio.utils.CosaMangioConstants.PASSWORD_HEADER;

@RestController
public class SocialController {

    private final AuthFilter authFilter;

    public SocialController(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @PostMapping("/merchant/{merchantId}/social")
    public void addSocial(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);

    }

    @PostMapping("/merchant/{merchantId}/social/{socialId}")
    public void editSocial(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }

    @DeleteMapping("/merchant/{merchantId}/social/{socialId}")
    public void deleteSocial(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }
}
