package com.facebook;

public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public final String toString() {
        GraphResponse graphResponse2 = this.graphResponse;
        FacebookRequestError error = graphResponse2 != null ? graphResponse2.getError() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb2.append(message);
            sb2.append(" ");
        }
        if (error != null) {
            sb2.append("httpResponseCode: ");
            sb2.append(error.getRequestStatusCode());
            sb2.append(", facebookErrorCode: ");
            sb2.append(error.getErrorCode());
            sb2.append(", facebookErrorType: ");
            sb2.append(error.getErrorType());
            sb2.append(", message: ");
            sb2.append(error.getErrorMessage());
            sb2.append("}");
        }
        return sb2.toString();
    }
}
