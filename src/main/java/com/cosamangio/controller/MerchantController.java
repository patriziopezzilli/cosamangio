package com.cosamangio.controller;

import com.cosamangio.dto.auth.AuthRequest;
import com.cosamangio.dto.auth.AuthResponse;
import com.cosamangio.dto.merchant.CreateMerchantRequest;
import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.MerchantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cosamangio.utils.CosaMangioConstants.EMAIL_HEADER;
import static com.cosamangio.utils.CosaMangioConstants.PASSWORD_HEADER;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private final AuthFilter authFilter;
    private final MerchantService merchantService;

    public MerchantController(AuthFilter authFilter, MerchantService merchantService) {
        this.authFilter = authFilter;
        this.merchantService = merchantService;
    }

    /**
     * Login
     *
     * @param request
     * @return
     */
    @PostMapping("/auth")
    public AuthResponse authMerchant(@RequestBody AuthRequest request) {
        return new AuthResponse(0, null);
    }

    /**
     * Sign up
     *
     * @param request
     */
    @PostMapping
    public void createMerchant(@RequestBody CreateMerchantRequest request) {
        merchantService.createMerchant(request);
    }

    /**
     * Retrieve all merchants
     *
     * @return
     */
    @GetMapping
    public List<Merchant> retrieveMerchants() {
        return merchantService.findAll();
    }

    /**
     * Update my merchant info (description, photo)..
     *
     * @param email
     * @param password
     * @param request
     */
    @PutMapping
    public void updateMerchant
    (
            @RequestHeader(EMAIL_HEADER) String email,
            @RequestHeader(PASSWORD_HEADER) String password,
            @RequestBody CreateMerchantRequest request) {

        authFilter.validate(email, password);
    }
}
