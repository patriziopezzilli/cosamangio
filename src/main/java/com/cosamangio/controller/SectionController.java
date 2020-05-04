package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import org.springframework.web.bind.annotation.*;

import static com.cosamangio.utils.CosaMangioConstants.EMAIL_HEADER;
import static com.cosamangio.utils.CosaMangioConstants.PASSWORD_HEADER;

@RestController
public class SectionController {

    private final AuthFilter authFilter;

    public SectionController(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @PostMapping("/merchant/{merchantId}/menu/{menuId}/section")
    public void addSection(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);

    }

    @PutMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}")
    public void editSection(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }

    @DeleteMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}")
    public void deleteSection(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }

    @PostMapping("/merchant/{merchantId}/menu/{menuId}/section/item")
    public void addSectionItem(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);

    }

    @PutMapping("/merchant/{merchantId}/menu/{menuId}/section/item/{sectionItemId}")
    public void editSectionItem(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }

    @DeleteMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}/item/{sectionItemId}")
    public void deleteSectionItem(
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password
    ) {

        authFilter.validate(email, password);
    }

}
