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
     //   qrCodeService.enableQRCode("ChIJPyUNHxHBhkcROGoFF-I7Pm0");
     //   qrCodeService.setQrCode("https://www.ristorantemonopoli.com/ristoranti/pdf/38BBCE73-6254-42FA-82D9-98493FF5AF20.pdf", "ChIJPyUNHxHBhkcROGoFF-I7Pm0");
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

    @PutMapping("/qrcode")
    public void setQRcode(
            @RequestParam String merchantCode,
            @RequestParam String pdfUrl) {
        qrCodeService.setQrCode(pdfUrl, merchantCode);
    }

}
