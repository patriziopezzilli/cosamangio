package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.cosamangio.utils.CosaMangioConstants.EMAIL_HEADER;
import static com.cosamangio.utils.CosaMangioConstants.PASSWORD_HEADER;

@RestController
public class MenuController {

    private final AuthFilter authFilter;

    public MenuController(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @PostMapping("/merchant/{merchantId}/menu")
    public void addMenu
            (@RequestHeader(EMAIL_HEADER) String email,
             @RequestHeader(PASSWORD_HEADER) String password
            ) {

        authFilter.validate(email, password);

    }

    @PutMapping("/merchant/{merchantId}/menu/{menuId}")
    public void editMenu
            (@RequestHeader(EMAIL_HEADER) String email,
             @RequestHeader(PASSWORD_HEADER) String password
            ) {

        authFilter.validate(email, password);

    }

    @DeleteMapping("/merchant/{merchantId}/menu/{menuId}")
    public void deleteMenu
            (@RequestHeader(EMAIL_HEADER) String email,
             @RequestHeader(PASSWORD_HEADER) String password
            ) {

        authFilter.validate(email, password);
    }
}
