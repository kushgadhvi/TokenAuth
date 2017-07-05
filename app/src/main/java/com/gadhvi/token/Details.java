package com.gadhvi.token;

/**
 * Created by gadhvi on 5/7/17.
 */

public class Details {
    String email;
    String token;
public Details(){

}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public Details(String email, String token) {
        this.email = email;
        this.token = token;

    }



}
