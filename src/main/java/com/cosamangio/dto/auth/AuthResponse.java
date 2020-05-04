package com.cosamangio.dto.auth;

import com.cosamangio.dto.merchant.Merchant;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private Integer result;
    private Merchant resultBody;

    public AuthResponse(Integer result, Merchant resultBody) {
        this.result = result;
        this.resultBody = resultBody;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Merchant getResultBody() {
        return resultBody;
    }

    public void setResultBody(Merchant resultBody) {
        this.resultBody = resultBody;
    }
}
