package com.cosamangio.service;

import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.entity.*;
import com.cosamangio.mapper.MerchantMapper;
import com.cosamangio.mapper.QRCodeMapper;
import com.cosamangio.repository.MerchantRepository;
import com.cosamangio.repository.QRCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class QRCodeService {
    private final QRCodeRepository qrCodeRepository;
    private final QRCodeMapper qrCodeMapper;

    public QRCodeService(QRCodeRepository repository, QRCodeMapper mapper) {
        this.qrCodeRepository = repository;
        this.qrCodeMapper = mapper;
    }

    public void enableQRCode(String merchantCode) {
        QRCodeEntity entity = new QRCodeEntity();
        String uuid = UUID.randomUUID().toString();
        entity.setCode(uuid); // questo sarà il QR code effettivo
        entity.setMerchantCode(merchantCode);
        entity.setPdfUrl("");

        qrCodeRepository.save(entity);

        try {
            URL yahoo = new URL("https://www.cosamangio-qrcode.it/script/insert_qrcode.php?qrCode="
                    + uuid + "&merchantCode=" + merchantCode + "&pdfUrl=TO_INSERT");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (Exception e) {
            System.out.println("> [ERROR] failed to update MYSQL");
        }
    }

    public void setQrCode(String pdfUrl, String merchantCode) {
        List<QRCodeEntity> codes = qrCodeRepository.findByMerchantCode(merchantCode);

        if (codes != null && !codes.isEmpty()) {
            codes.get(0).setPdfUrl(pdfUrl);
            qrCodeRepository.saveAll(codes);

            try {
                URL yahoo = new URL("https://www.cosamangio-qrcode.it/script/remove_qrcode.php?qrCode=" + codes.get(0).getCode());
                URLConnection yc = yahoo.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
            } catch (Exception e) {
                System.out.println("> [ERROR] failed to update MYSQL");
            }

            try {
                URL yahoo = new URL("https://www.cosamangio-qrcode.it/script/insert_qrcode.php?qrCode="
                        + codes.get(0).getCode() + "&merchantCode=" + merchantCode + "&pdfUrl=" + pdfUrl);
                URLConnection yc = yahoo.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
            } catch (Exception e) {
                System.out.println("> [ERROR] failed to update MYSQL");
            }
        }
    }

    public QRCode getQRCode(String qrCode) {
        System.out.print("> [QRCODE][GET] retrieve qr code " + qrCode);
        QRCodeEntity entity = qrCodeRepository.findByCode(qrCode);
        return qrCodeMapper.mapToDto(entity);
    }

    public String findByMerchant(String merchantCode) {
        List<QRCodeEntity> codes = qrCodeRepository.findByMerchantCode(merchantCode);

        if (codes != null && !codes.isEmpty()) {
            return qrCodeMapper.mapToDto(codes.get(0)).getCode();
        } else {
            enableQRCode(merchantCode);
            findByMerchant(merchantCode);
        }

        return null;
    }
}
