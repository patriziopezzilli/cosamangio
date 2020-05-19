package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.SectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cosamangio.utils.CosaMangioConstants.SECURITY_KEY_HEADER;

@RestController
public class SectionController {

    private final AuthFilter authFilter;
    private final SectionService sectionService;

    public SectionController(AuthFilter authFilter, SectionService sectionService) {
        this.authFilter = authFilter;
        this.sectionService = sectionService;
    }

    @PostMapping("/section/item")
    public void createItem(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String sectionCode,
            @RequestParam String itemTitle,
            @RequestParam String itemSubtitle,
            @RequestParam String itemPrice
    ) {
        authFilter.validate(headerKey);

        itemPrice = itemPrice.replace(",", ".");

        sectionService.createItem(merchantCode, sectionCode, itemTitle, itemSubtitle, itemPrice);
    }

    @PutMapping("/section/item")
    public void editItem(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String itemCode,
            @RequestParam String itemTitle,
            @RequestParam String itemSubtitle,
            @RequestParam String itemPrice
    ) {
        authFilter.validate(headerKey);

        itemPrice = itemPrice.replace(",", ".");

        sectionService.editItem(merchantCode, itemCode, itemTitle, itemSubtitle, itemPrice);
    }

    @DeleteMapping("/section/item")
    public void deleteItem(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String sectionCode,
            @RequestParam String itemCode
    ) {
        authFilter.validate(headerKey);
        sectionService.deleteItem(merchantCode, sectionCode, itemCode);
    }

    @DeleteMapping("/section/item/all")
    public void deleteAllItem(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String sectionCode
    ) {
        authFilter.validate(headerKey);
        sectionService.deleteAllItem(merchantCode, sectionCode);
    }

    @PostMapping("/section")
    public void addSection(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName,
            @RequestParam String sectionName
    ) {
        authFilter.validate(headerKey);
        sectionService.createSection(merchantCode, menuName, sectionName);
    }

    @PutMapping("/section")
    public void editSection(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String oldName,
            @RequestParam String newName,
            @RequestParam String menuName
    ) {
        authFilter.validate(headerKey);
        sectionService.updateSection(merchantCode, menuName, oldName, newName);
    }

    @DeleteMapping("/section")
    public void deleteSection(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName,
            @RequestParam String sectionName
    ) {
        authFilter.validate(headerKey);
        sectionService.deleteSection(merchantCode, menuName, sectionName);
    }

    @DeleteMapping("/section/all")
    public void deleteSection(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName
    ) {
        authFilter.validate(headerKey);
        sectionService.deleteAllSection(merchantCode, menuName);
    }
}
