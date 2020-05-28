package com.cosamangio.service;

import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.entity.*;
import com.cosamangio.mapper.MerchantMapper;
import com.cosamangio.mapper.QRCodeMapper;
import com.cosamangio.repository.MerchantRepository;
import com.cosamangio.repository.QRCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public void enableQRCode(String merchantCode){
        QRCodeEntity entity = new QRCodeEntity();
        entity.setCode(UUID.randomUUID().toString()); // questo sarà il QR code effettivo
        entity.setMerchantCode(merchantCode);
        entity.setPdfUrl("");

        qrCodeRepository.save(entity);
    }

    public QRCode getQRCode(String qrCode) {
        System.out.print("> [QRCODE][GET] retrieve qr code " + qrCode);
        QRCodeEntity entity = qrCodeRepository.findByCode(qrCode);
        return qrCodeMapper.mapToDto(entity);
    }
}
