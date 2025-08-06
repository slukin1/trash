package zendesk.core;

class AuthenticationRequestWrapper {
    private Identity user;

    public AuthenticationRequestWrapper(Identity identity) {
        this.user = identity;
    }
}
