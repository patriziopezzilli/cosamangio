package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialController {

    private final AuthFilter authFilter;

    public SocialController(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @PostMapping("/merchant/{merchantId}/social")
    public void addSocial(
    ) {

    }

    @PostMapping("/merchant/{merchantId}/social/{socialId}")
    public void editSocial(
    ) {

    }

    @DeleteMapping("/merchant/{merchantId}/social/{socialId}")
    public void deleteSocial(
    ) {

    }
}
