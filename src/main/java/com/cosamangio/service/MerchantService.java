package com.cosamangio.service;

import com.cosamangio.dto.merchant.CreateMerchantRequest;
import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.mapper.MerchantMapper;
import com.cosamangio.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MerchantService {

    private final Random rand = new Random();
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    public MerchantService(MerchantRepository merchantRepository, MerchantMapper merchantMapper) {
        this.merchantRepository = merchantRepository;
        this.merchantMapper = merchantMapper;
    }

    /**
     * Create new merchant
     *
     * @param request
     */
    public void createMerchant(CreateMerchantRequest request) {
        MerchantEntity entity = new MerchantEntity();

        /**
         * Init common fields
         */
        entity.setEmail(request.getEmail());
        entity.setName(request.getName());
        entity.setShortName(request.getShortName());
        entity.setVatCode(request.getVatCode());
        entity.setDescription(request.getDescription());
        entity.setPassword(request.getPassword());
        entity.setAddress(request.getAddress());

        /**
         * Set validation code
         */
        entity.setValidated(false);
        entity.setValidationCode(String.valueOf(rand.nextInt(10000)));

        /**
         * Set active
         */
        entity.setActive(false);

        /**
         * Set arrays
         */
        entity.setTags(new ArrayList<>());
        entity.setSocials(new ArrayList<>());
        entity.setMenus(new ArrayList<>());

        /**
         * Save
         */
        merchantRepository.save(entity);

        /**
         * Send mail
         */
    }

    /**
     * Retrieve all merchants configured on *cosamangio*
     *
     * @return
     */
    public List<Merchant> findAll() {
        List<MerchantEntity> entities = merchantRepository.findAll();

        return merchantMapper.mapToDtos(entities);
    }

}
