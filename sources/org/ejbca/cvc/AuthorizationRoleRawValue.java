package org.ejbca.cvc;

public class AuthorizationRoleRawValue implements AuthorizationRole {
    private final byte value;

    public AuthorizationRoleRawValue(byte b11) {
        this.value = b11;
    }

    public byte getValue() {
        return this.value;
    }

    public boolean isAccreditationBodyDV() {
        return false;
    }

    public boolean isAuthenticationTerminal() {
        return false;
    }

    public boolean isCVCA() {
        return false;
    }

    public boolean isCertificationServiceProviderDV() {
        return false;
    }

    public boolean isDV() {
        return false;
    }

    public boolean isDomesticDV() {
        return false;
    }

    public boolean isForeignDV() {
        return false;
    }

    public boolean isIS() {
        return false;
    }

    public boolean isSignatureTerminal() {
        return false;
    }

    public String name() {
        return "RAW_AUTHORIZATION_ROLE";
    }

    public String toString() {
        return "AuthorizationRoleRawValue(" + Integer.toString(this.value & 255, 16).toUpperCase() + ")";
    }
}
