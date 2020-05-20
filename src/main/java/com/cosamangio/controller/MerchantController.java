package com.cosamangio.controller;

import com.cosamangio.dto.auth.AuthRequest;
import com.cosamangio.dto.auth.AuthResponse;
import com.cosamangio.dto.merchant.CreateMerchantRequest;
import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.MerchantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.cosamangio.utils.CosaMangioConstants.*;

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
    public Merchant createMerchant(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestBody CreateMerchantRequest request) {
        authFilter.validate(headerKey);
        merchantService.createMerchant(request);
        return merchantService.findOne(request.getEmail());
    }

    @GetMapping("/one")
    public Merchant retrieveByEmail(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String email) {

        authFilter.validate(headerKey);
        return merchantService.findOne(email);
    }

    @PutMapping("/name")
    public void updateName(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String name,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        if (name != null && !name.equals("")) {
            merchantService.updateName(merchantCode, name);
        }
    }

    @PutMapping("/description")
    public void updateDescription(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String description,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        merchantService.updateDescription(merchantCode, description);
    }

    @PutMapping("/address")
    public void updateAddress(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String address,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        if (address != null && !address.equals("")) {
            merchantService.updateAddress(merchantCode, address);
        }
    }


    @PutMapping("/facebook")
    public void updateFacebook(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String url,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        if (url != null && !url.equals("")) {
            merchantService.updateSocial(merchantCode, "FACEBOOK", "Facebook", url);
        }
    }

    @PutMapping("/instagram")
    public void updateInstagram(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String url,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        if (url != null && !url.equals("")) {
            merchantService.updateSocial(merchantCode, "INSTAGRAM", "Instagram", url);
        }
    }

    @PutMapping("/web")
    public void updateWeb(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String url,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        if (url != null && !url.equals("")) {
            merchantService.updateSocial(merchantCode, "WEB", "Web", url);
        }
    }

    @PutMapping("/logo")
    public void uploadLogo(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);

    }

    @PutMapping("/active")
    public void activateMerchant(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam Boolean activation) {
        authFilter.validate(headerKey);
        merchantService.activateMerchant(merchantCode, activation);
    }

    @PutMapping("/allergens")
    public void editAllergens(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode,
            @RequestParam List<String> allergens) {
        authFilter.validate(headerKey);
        merchantService.editAllergens(merchantCode, allergens);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logo", consumes = "multipart/form-data")
    public void uploadLogo(@RequestParam("file") MultipartFile file,
                                   @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
                                   @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        merchantService.uploadLogo(merchantCode, file);
    }

    @DeleteMapping("/logo")
    public void deleteLogo(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String merchantCode) {
        authFilter.validate(headerKey);
        merchantService.removeLogo(merchantCode);
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
     * @param request
     */
    @PutMapping
    public void updateMerchant
    (
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestBody CreateMerchantRequest request) {

        authFilter.validate(headerKey);
    }
}
