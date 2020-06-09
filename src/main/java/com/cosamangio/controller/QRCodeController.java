package com.cosamangio.controller;

import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.filter.AuthFilter;
import com.cosamangio.service.QRCodeService;
import com.cosamangio.service.SectionService;
import org.springframework.web.bind.annotation.*;

import static com.cosamangio.utils.CosaMangioConstants.SECURITY_KEY_HEADER;

@RestController
public class QRCodeController {

    private final AuthFilter authFilter;
    private final QRCodeService qrCodeService;

    public QRCodeController(AuthFilter authFilter, QRCodeService service) {
        this.authFilter = authFilter;
        this.qrCodeService = service;
    }

    @GetMapping("/qrcode/test")
    public void test() {
        qrCodeService.enableQRCode("39170500-2d95-47d7-8072-29f055ece36c");
    }

    @GetMapping("/qrcode/resolve")
    public String resolveQRCode(
            @RequestParam String code
    ) {
        return qrCodeService.getQRCode(code).getPdfUrl();
    }

    @GetMapping("/qrcode")
    public String retrieveQRcode(
            @RequestParam String merchantCode
    ) {
        return qrCodeService.findByMerchant(merchantCode);
    }

}
