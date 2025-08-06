package com.amazonaws.auth.policy;

public enum Principal$WebIdentityProviders {
    Facebook("graph.facebook.com"),
    Google("accounts.google.com"),
    Amazon("www.amazon.com"),
    AllProviders("*");
    
    private String webIdentityProvider;

    private Principal$WebIdentityProviders(String str) {
        this.webIdentityProvider = str;
    }

    public static Principal$WebIdentityProviders fromString(String str) {
        if (str == null) {
            return null;
        }
        for (Principal$WebIdentityProviders principal$WebIdentityProviders : values()) {
            if (principal$WebIdentityProviders.getWebIdentityProvider().equalsIgnoreCase(str)) {
                return principal$WebIdentityProviders;
            }
        }
        return null;
    }

    public String getWebIdentityProvider() {
        return this.webIdentityProvider;
    }
}
