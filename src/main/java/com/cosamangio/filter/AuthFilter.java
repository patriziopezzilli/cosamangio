package com.cosamangio.filter;

import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.cosamangio.utils.CosaMangioConstants.SECURITY_VALUE;

@Component
public class AuthFilter {

    public AuthFilter() {
    }

    public void validate(String key) {

        /**
         * Validate email and password
         */
        if (null == key) {
            throw new IllegalArgumentException("key must be populated");
        }
        /**
         * Validate password
         */
        if (!key.equals(SECURITY_VALUE)) {
            throw new IllegalArgumentException("security key is wrong");
        }
    }
}
