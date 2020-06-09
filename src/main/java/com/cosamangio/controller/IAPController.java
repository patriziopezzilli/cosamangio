package com.cosamangio.controller;

import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.IAPService;
import com.cosamangio.service.QRCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.cosamangio.utils.CosaMangioConstants.SECURITY_KEY_HEADER;

@RestController
public class IAPController {

    private final AuthFilter authFilter;
    private final IAPService iapService;

    public IAPController(AuthFilter authFilter, IAPService service) {
        this.authFilter = authFilter;
        this.iapService = service;
    }

    @GetMapping("/iap/pay")
    public void pay(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String iapCode,
            @RequestParam String merchantCode) {

        authFilter.validate(headerKey);
        iapService.pay(iapCode, merchantCode);
    }

    @GetMapping("/iap/verify")
    public Boolean verify(
            @RequestHeader(SECURITY_KEY_HEADER) String headerKey,
            @RequestParam String iapCode,
            @RequestParam String merchantCode
    ) {
        authFilter.validate(headerKey);
        return iapService.verifyPayment(iapCode, merchantCode);
    }

    @GetMapping("/iap/test")
    public void test(
    ) {
        iapService.test();
    }
}
