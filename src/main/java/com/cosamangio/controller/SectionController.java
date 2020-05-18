package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectionController {

    private final AuthFilter authFilter;

    public SectionController(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @PostMapping("/merchant/{merchantId}/menu/{menuId}/section")
    public void addSection(
    ) {

    }

    @PutMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}")
    public void editSection(
    ) {

    }

    @DeleteMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}")
    public void deleteSection(
    ) {
    }

    @PostMapping("/merchant/{merchantId}/menu/{menuId}/section/item")
    public void addSectionItem(
    ) {


    }

    @PutMapping("/merchant/{merchantId}/menu/{menuId}/section/item/{sectionItemId}")
    public void editSectionItem(
    ) {

    }

    @DeleteMapping("/merchant/{merchantId}/menu/{menuId}/section/{sectionId}/item/{sectionItemId}")
    public void deleteSectionItem(
    ) {
    }

}
