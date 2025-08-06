package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.google.common.net.HttpHeaders;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.android.tpush.common.MessageKey;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AWS4Signer extends AbstractAWSSigner implements ServiceAwareSigner, RegionAwareSigner {
    public static final String ALGORITHM = "AWS4-HMAC-SHA256";
    private static final String DATE_PATTERN = "yyyyMMdd";
    private static final long MAX_EXPIRATION_TIME_IN_SECONDS = 604800;
    private static final long MILLISEC = 1000;
    public static final String TERMINATOR = "aws4_request";
    private static final String TIME_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    public static final Log log = LogFactory.b(AWS4Signer.class);
    public boolean doubleUrlEncode;
    public Date overriddenDate;
    public String regionName;
    public String serviceName;

    public static class HeaderSigningResult {

        /* renamed from: a  reason: collision with root package name */
        public final String f14814a;

        /* renamed from: b  reason: collision with root package name */
        public final String f14815b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f14816c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f14817d;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.f14814a = str;
            this.f14815b = str2;
            this.f14816c = bArr;
            this.f14817d = bArr2;
        }

        public String a() {
            return this.f14814a;
        }

        public byte[] b() {
            byte[] bArr = this.f14816c;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public String c() {
            return this.f14815b;
        }

        public byte[] d() {
            byte[] bArr = this.f14817d;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    public AWS4Signer() {
        this(true);
    }

    public void addHostHeader(Request<?> request) {
        String host = request.t().getHost();
        if (HttpUtils.e(request.t())) {
            host = host + ":" + request.t().getPort();
        }
        request.a("Host", host);
    }

    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.a("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public String calculateContentHash(Request<?> request) {
        InputStream binaryRequestPayloadStream = getBinaryRequestPayloadStream(request);
        binaryRequestPayloadStream.mark(-1);
        String a11 = BinaryUtils.a(hash(binaryRequestPayloadStream));
        try {
            binaryRequestPayloadStream.reset();
            return a11;
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e11);
        }
    }

    public String calculateContentHashPresign(Request<?> request) {
        return calculateContentHash(request);
    }

    public final HeaderSigningResult computeSignature(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String extractRegionName = extractRegionName(request.t());
        String extractServiceName = extractServiceName(request.t());
        String str5 = str + "/" + extractRegionName + "/" + extractServiceName + "/" + TERMINATOR;
        String stringToSign = getStringToSign(str3, str2, str5, getCanonicalRequest(request, str4));
        Charset charset = StringUtils.f15560a;
        byte[] bytes = ("AWS4" + aWSCredentials.b()).getBytes(charset);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        byte[] sign = sign(TERMINATOR, sign(extractServiceName, sign(extractRegionName, sign(str, bytes, signingAlgorithm), signingAlgorithm), signingAlgorithm), signingAlgorithm);
        return new HeaderSigningResult(str2, str5, sign, sign(stringToSign.getBytes(charset), sign, signingAlgorithm));
    }

    public String extractRegionName(URI uri) {
        String str = this.regionName;
        if (str != null) {
            return str;
        }
        return AwsHostNameUtils.a(uri.getHost(), this.serviceName);
    }

    public String extractServiceName(URI uri) {
        String str = this.serviceName;
        if (str != null) {
            return str;
        }
        return AwsHostNameUtils.c(uri);
    }

    public String getCanonicalRequest(Request<?> request, String str) {
        String str2;
        if (request.m() != null) {
            str2 = HttpUtils.c(request.t().getPath(), request.m());
        } else {
            str2 = HttpUtils.a(request.t().getPath(), request.l());
        }
        String str3 = request.j().toString() + "\n" + getCanonicalizedResourcePath(str2, this.doubleUrlEncode) + "\n" + getCanonicalizedQueryString(request) + "\n" + getCanonicalizedHeaderString(request) + "\n" + getSignedHeadersString(request) + "\n" + str;
        log.h("AWS4 Canonical Request: '\"" + str3 + "\"");
        return str3;
    }

    public String getCanonicalizedHeaderString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb2 = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                String replaceAll = StringUtils.b(str).replaceAll("\\s+", " ");
                String str2 = request.getHeaders().get(str);
                sb2.append(replaceAll);
                sb2.append(":");
                if (str2 != null) {
                    sb2.append(str2.replaceAll("\\s+", " "));
                }
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public final long getDateFromRequest(Request<?> request) {
        Date signatureDate = getSignatureDate(getTimeOffset(request));
        Date date = this.overriddenDate;
        if (date != null) {
            signatureDate = date;
        }
        return signatureDate.getTime();
    }

    public final String getDateStamp(long j11) {
        return DateUtils.c(DATE_PATTERN, new Date(j11));
    }

    public String getScope(Request<?> request, String str) {
        String extractRegionName = extractRegionName(request.t());
        String extractServiceName = extractServiceName(request.t());
        return str + "/" + extractRegionName + "/" + extractServiceName + "/" + TERMINATOR;
    }

    public String getSignedHeadersString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb2 = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(StringUtils.b(str));
            }
        }
        return sb2.toString();
    }

    public String getStringToSign(String str, String str2, String str3, String str4) {
        String str5 = str + "\n" + str2 + "\n" + str3 + "\n" + BinaryUtils.a(hash(str4));
        log.h("AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    public final String getTimeStamp(long j11) {
        return DateUtils.c(TIME_PATTERN, new Date(j11));
    }

    public boolean needsSign(String str) {
        return MessageKey.MSG_DATE.equalsIgnoreCase(str) || HttpHeaders.CONTENT_MD5.equalsIgnoreCase(str) || VulcanInfo.HOST.equalsIgnoreCase(str) || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }

    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    public void presignRequest(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            long time = date != null ? (date.getTime() - System.currentTimeMillis()) / 1000 : 604800;
            if (time <= 604800) {
                addHostHeader(request);
                AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
                if (sanitizeCredentials instanceof AWSSessionCredentials) {
                    request.p("X-Amz-Security-Token", ((AWSSessionCredentials) sanitizeCredentials).getSessionToken());
                }
                long dateFromRequest = getDateFromRequest(request);
                String dateStamp = getDateStamp(dateFromRequest);
                String timeStamp = getTimeStamp(dateFromRequest);
                request.p("X-Amz-Algorithm", ALGORITHM);
                request.p("X-Amz-Date", timeStamp);
                request.p("X-Amz-SignedHeaders", getSignedHeadersString(request));
                request.p("X-Amz-Expires", Long.toString(time));
                request.p("X-Amz-Credential", sanitizeCredentials.a() + "/" + getScope(request, dateStamp));
                request.p("X-Amz-Signature", BinaryUtils.a(computeSignature(request, dateStamp, timeStamp, ALGORITHM, calculateContentHashPresign(request), sanitizeCredentials).d()));
                return;
            }
            throw new AmazonClientException("Requests that are pre-signed by SigV4 algorithm are valid for at most 7 days. The expiration date set on the current request [" + getTimeStamp(date.getTime()) + "] has exceeded this limit.");
        }
    }

    public void processRequestPayload(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            addHostHeader(request);
            long dateFromRequest = getDateFromRequest(request);
            String dateStamp = getDateStamp(dateFromRequest);
            String scope = getScope(request, dateStamp);
            String calculateContentHash = calculateContentHash(request);
            String timeStamp = getTimeStamp(dateFromRequest);
            request.a("X-Amz-Date", timeStamp);
            if (request.getHeaders().get("x-amz-content-sha256") != null && "required".equals(request.getHeaders().get("x-amz-content-sha256"))) {
                request.a("x-amz-content-sha256", calculateContentHash);
            }
            HeaderSigningResult computeSignature = computeSignature(request, dateStamp, timeStamp, ALGORITHM, calculateContentHash, sanitizeCredentials);
            request.a("Authorization", "AWS4-HMAC-SHA256 " + ("Credential=" + (sanitizeCredentials.a() + "/" + scope)) + ", " + ("SignedHeaders=" + getSignedHeadersString(request)) + ", " + ("Signature=" + BinaryUtils.a(computeSignature.d())));
            processRequestPayload(request, computeSignature);
        }
    }

    public AWS4Signer(boolean z11) {
        this.doubleUrlEncode = z11;
    }
}
