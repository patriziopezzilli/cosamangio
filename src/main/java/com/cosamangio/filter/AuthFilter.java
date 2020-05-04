package com.cosamangio.filter;

import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter {

    private final MerchantRepository merchantRepository;

    public AuthFilter(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public void validate(String email, String password) {

        /**
         * Validate email and password
         */
        if (null == email || null == password) {
            throw new IllegalArgumentException("email and password must be populated");
        }

        /**
         * Retrieve merchant
         */
        MerchantEntity merchant = merchantRepository.findByEmailAndActive(email.toLowerCase(), true);

        /**
         * Validate nullabilty
         */
        if (null == merchant) {
            throw new IllegalArgumentException("merchant " + email + " not present");
        }

        /**
         * Validate password
         */
        if (!merchant.getPassword().equals(password)) {
            throw new IllegalArgumentException("password is wrong");
        }
    }
}
