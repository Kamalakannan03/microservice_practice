package com.spotify.spotify.model;

public class TokenResponse {
    private String access_token;
    private String token_Type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_Type() {
        return token_Type;
    }

    public void setToken_Type(String token_Type) {
        this.token_Type = token_Type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public TokenResponse(String access_token, String token_Type, int expires_in) {
        this.access_token = access_token;
        this.token_Type = token_Type;
        this.expires_in = expires_in;
    }
}
