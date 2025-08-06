package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractAWSSigner implements Signer {
    private static final int BUFFER_SIZE_MULTIPLIER = 5;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.a(doHash(""));
    private static final ThreadLocal<MessageDigest> SHA256_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() {
        /* renamed from: a */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e11) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e11.getMessage(), e11);
            }
        }
    };
    private static final int TIME_MILLISEC = 1000;

    private static byte[] doHash(String str) {
        try {
            MessageDigest messageDigestInstance = getMessageDigestInstance();
            messageDigestInstance.update(str.getBytes(StringUtils.f15560a));
            return messageDigestInstance.digest();
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e11.getMessage(), e11);
        }
    }

    private static MessageDigest getMessageDigestInstance() {
        MessageDigest messageDigest = SHA256_MESSAGE_DIGEST.get();
        messageDigest.reset();
        return messageDigest;
    }

    public abstract void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials);

    public byte[] getBinaryRequestPayload(Request<?> request) {
        if (!HttpUtils.g(request)) {
            return getBinaryRequestPayloadWithoutQueryParams(request);
        }
        String d11 = HttpUtils.d(request);
        if (d11 == null) {
            return new byte[0];
        }
        return d11.getBytes(StringUtils.f15560a);
    }

    public InputStream getBinaryRequestPayloadStream(Request<?> request) {
        if (!HttpUtils.g(request)) {
            return getBinaryRequestPayloadStreamWithoutQueryParams(request);
        }
        String d11 = HttpUtils.d(request);
        if (d11 == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        return new ByteArrayInputStream(d11.getBytes(StringUtils.f15560a));
    }

    public InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e11.getMessage(), e11);
        }
    }

    public byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e11.getMessage(), e11);
        }
    }

    public String getCanonicalizedEndpoint(URI uri) {
        String b11 = StringUtils.b(uri.getHost());
        if (!HttpUtils.e(uri)) {
            return b11;
        }
        return b11 + ":" + uri.getPort();
    }

    public String getCanonicalizedQueryString(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            treeMap.put(HttpUtils.f((String) next.getKey(), false), HttpUtils.f((String) next.getValue(), false));
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = treeMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            sb2.append((String) entry.getKey());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append((String) entry.getValue());
            if (it2.hasNext()) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb2.toString();
    }

    public String getCanonicalizedResourcePath(String str) {
        return getCanonicalizedResourcePath(str, true);
    }

    public String getRequestPayload(Request<?> request) {
        return newString(getBinaryRequestPayload(request));
    }

    public String getRequestPayloadWithoutQueryParams(Request<?> request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    public Date getSignatureDate(long j11) {
        Date date = new Date();
        return j11 != 0 ? new Date(date.getTime() - (j11 * 1000)) : date;
    }

    public long getTimeOffset(Request<?> request) {
        return SDKGlobalConfiguration.a() != 0 ? SDKGlobalConfiguration.a() : request.e();
    }

    public byte[] hash(String str) {
        return doHash(str);
    }

    public String newString(byte[] bArr) {
        return new String(bArr, StringUtils.f15560a);
    }

    public AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String a11;
        String b11;
        String sessionToken;
        synchronized (aWSCredentials) {
            a11 = aWSCredentials.a();
            b11 = aWSCredentials.b();
            sessionToken = aWSCredentials instanceof AWSSessionCredentials ? ((AWSSessionCredentials) aWSCredentials).getSessionToken() : null;
        }
        if (b11 != null) {
            b11 = b11.trim();
        }
        if (a11 != null) {
            a11 = a11.trim();
        }
        if (sessionToken != null) {
            sessionToken = sessionToken.trim();
        }
        if (aWSCredentials instanceof AWSSessionCredentials) {
            return new BasicSessionCredentials(a11, b11, sessionToken);
        }
        return new BasicAWSCredentials(a11, b11);
    }

    public byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return sign(str.getBytes(StringUtils.f15560a), bArr, signingAlgorithm);
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e11.getMessage(), e11);
        }
    }

    public String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return signAndBase64Encode(str.getBytes(StringUtils.f15560a), str2, signingAlgorithm);
    }

    public String getCanonicalizedResourcePath(String str, boolean z11) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (z11) {
            str = HttpUtils.f(str, true);
        }
        if (str.startsWith("/")) {
            return str;
        }
        return "/".concat(str);
    }

    public byte[] hash(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, getMessageDigestInstance());
            while (sdkDigestInputStream.read(new byte[1024]) > -1) {
            }
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e11.getMessage(), e11);
        }
    }

    public String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.encodeAsString(sign(bArr, str.getBytes(StringUtils.f15560a), signingAlgorithm));
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e11.getMessage(), e11);
        }
    }

    public byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac instance = Mac.getInstance(signingAlgorithm.toString());
            instance.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return instance.doFinal(bArr);
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e11.getMessage(), e11);
        }
    }

    public byte[] hash(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e11.getMessage(), e11);
        }
    }

    public String getCanonicalizedQueryString(Request<?> request) {
        if (HttpUtils.g(request)) {
            return "";
        }
        return getCanonicalizedQueryString(request.getParameters());
    }
}
