package com.amazonaws.auth;

import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.google.common.net.HttpHeaders;
import com.huobi.vulcan.model.VulcanInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Deprecated
public class AWS3Signer extends AbstractAWSSigner {

    /* renamed from: b  reason: collision with root package name */
    public static final Log f14812b = LogFactory.b(AWS3Signer.class);

    /* renamed from: a  reason: collision with root package name */
    public String f14813a;

    public String a(Request<?> request) {
        List<String> b11 = b(request);
        for (int i11 = 0; i11 < b11.size(); i11++) {
            b11.set(i11, StringUtils.b(b11.get(i11)));
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : request.getHeaders().entrySet()) {
            if (b11.contains(StringUtils.b((String) next.getKey()))) {
                treeMap.put(StringUtils.b((String) next.getKey()), next.getValue());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append(StringUtils.b((String) entry.getKey()));
            sb2.append(":");
            sb2.append((String) entry.getValue());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.a("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public List<String> b(Request<?> request) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> key : request.getHeaders().entrySet()) {
            String str = (String) key.getKey();
            String b11 = StringUtils.b(str);
            if (b11.startsWith("x-amz") || VulcanInfo.HOST.equals(b11)) {
                arrayList.add(str);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final String c(Request<?> request) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SignedHeaders=");
        boolean z11 = true;
        for (String next : b(request)) {
            if (!z11) {
                sb2.append(";");
            }
            sb2.append(next);
            z11 = false;
        }
        return sb2.toString();
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
            UUID.randomUUID().toString();
            String d11 = DateUtils.d(getSignatureDate(getTimeOffset(request)));
            String str = this.f14813a;
            if (str != null) {
                d11 = str;
            }
            request.a(HttpHeaders.DATE, d11);
            request.a("X-Amz-Date", d11);
            String host = request.t().getHost();
            if (HttpUtils.e(request.t())) {
                host = host + ":" + request.t().getPort();
            }
            request.a("Host", host);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            String a11 = HttpUtils.a(request.t().getPath(), request.l());
            String str2 = request.j().toString() + "\n" + getCanonicalizedResourcePath(a11) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + a(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
            byte[] hash = hash(str2);
            f14812b.h("Calculated StringToSign: " + str2);
            String signAndBase64Encode = signAndBase64Encode(hash, sanitizeCredentials.b(), signingAlgorithm);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AWS3");
            sb2.append(" ");
            sb2.append("AWSAccessKeyId=" + sanitizeCredentials.a() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append("Algorithm=" + signingAlgorithm.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c(request));
            sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(sb3.toString());
            sb2.append("Signature=" + signAndBase64Encode);
            request.a("X-Amzn-Authorization", sb2.toString());
        }
    }
}
