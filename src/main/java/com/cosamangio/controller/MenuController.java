package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.cosamangio.utils.CosaMangioConstants.SECURITY_KEY_HEADER;

@RestController
public class MenuController {

    private final AuthFilter authFilter;
    private final MenuService menuService;

    public MenuController(AuthFilter authFilter, MenuService menuService) {
        this.authFilter = authFilter;
        this.menuService = menuService;
    }

    @GetMapping("/reindex")
    public void reindex(){
        menuService.reindex();
    }

    @PostMapping("/menu")
    public void addMenu(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName,
            @RequestParam(required = false) List<String> sections
    ) {
        authFilter.validate(headerKey);
        menuService.createMenu(merchantCode, menuName, sections, null);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/menu/pdf")
    public void addPDFMenu(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName,
            @RequestParam("file") MultipartFile file
    ) {
        authFilter.validate(headerKey);
        menuService.createMenu(merchantCode, menuName, null, file);
    }


    @PutMapping("/menu")
    public void editMenu(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String oldName,
            @RequestParam String newName
    ) {
        authFilter.validate(headerKey);
        menuService.updateMenuName(merchantCode, oldName, newName);
    }

    @DeleteMapping("/menu")
    public void deleteMenu(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam String menuName
    ) {
        authFilter.validate(headerKey);
        menuService.deleteMenu(merchantCode, menuName);
    }

    @DeleteMapping("/menu/all")
    public void deleteMenu(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode
    ) {
        authFilter.validate(headerKey);
        menuService.deleteAllMenu(merchantCode);
    }
}
