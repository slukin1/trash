package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner extends AbstractAWSSigner {
    private Date overriddenDate;

    private String calculateStringToSignV1(Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append((String) entry.getKey());
            sb2.append((String) entry.getValue());
        }
        return sb2.toString();
    }

    private String calculateStringToSignV2(Request<?> request) {
        URI t11 = request.t();
        Map<String, String> parameters = request.getParameters();
        return "POST" + "\n" + getCanonicalizedEndpoint(t11) + "\n" + getCanonicalizedResourcePath(request) + "\n" + getCanonicalizedQueryString(parameters);
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String str = "";
        if (request.t().getPath() != null) {
            str = str + request.t().getPath();
        }
        if (request.l() != null) {
            if (str.length() > 0 && !str.endsWith("/") && !request.l().startsWith("/")) {
                str = str + "/";
            }
            str = str + request.l();
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return str.startsWith("//") ? str.substring(1) : str;
    }

    private String getFormattedTimestamp(long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        Date date = this.overriddenDate;
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return simpleDateFormat.format(getSignatureDate(j11));
    }

    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.p("SecurityToken", aWSSessionCredentials.getSessionToken());
    }

    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    public void sign(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) {
        String str;
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            request.p("AWSAccessKeyId", sanitizeCredentials.a());
            request.p("SignatureVersion", signatureVersion.toString());
            request.p("Timestamp", getFormattedTimestamp(getTimeOffset(request)));
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            if (signatureVersion.equals(SignatureVersion.V1)) {
                str = calculateStringToSignV1(request.getParameters());
            } else if (signatureVersion.equals(SignatureVersion.V2)) {
                request.p("SignatureMethod", signingAlgorithm.toString());
                str = calculateStringToSignV2(request);
            } else {
                throw new AmazonClientException("Invalid Signature Version specified");
            }
            request.p("Signature", signAndBase64Encode(str, sanitizeCredentials.b(), signingAlgorithm));
        }
    }
}
