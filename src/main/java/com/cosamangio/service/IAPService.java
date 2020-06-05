package com.cosamangio.service;

import com.cosamangio.entity.IAPPurchaseEntity;
import com.cosamangio.mapper.IAPMapper;
import com.cosamangio.repository.IAPRepository;
import org.springframework.stereotype.Service;

@Service
public class IAPService {
    private final IAPRepository iapRepository;
    private final IAPMapper iapMapper;

    public IAPService(IAPRepository repository, IAPMapper mapper) {
        this.iapRepository = repository;
        this.iapMapper = mapper;
    }

    public void pay(String iapCode, String merchantCode) {
        IAPPurchaseEntity entity = new IAPPurchaseEntity();
        entity.setIapCode(iapCode);
        entity.setMerchantCode(merchantCode);
        entity.setPaid(true);

        this.iapRepository.save(entity);
    }

    public Boolean verifyPayment(String iapCode, String merchantCode) {
        IAPPurchaseEntity entity = iapRepository.findByMerchantCodeAndIapCode(merchantCode, iapCode);

        if (entity == null) {
            return false;
        }

        return entity.getPaid();
    }
}
