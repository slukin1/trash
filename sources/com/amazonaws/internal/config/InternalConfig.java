package com.amazonaws.internal.config;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalConfig {

    /* renamed from: g  reason: collision with root package name */
    public static final Log f14923g = LogFactory.b(InternalConfig.class);

    /* renamed from: a  reason: collision with root package name */
    public final SignerConfig f14924a = f();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, SignerConfig> f14925b = d();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, SignerConfig> f14926c = c();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, SignerConfig> f14927d = e();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, HttpClientConfig> f14928e = b();

    /* renamed from: f  reason: collision with root package name */
    public final List<HostRegexToRegionMapping> f14929f = a();

    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final InternalConfig f14930a = new InternalConfig();

        static {
            try {
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Android SDK", e12);
            }
        }

        public static InternalConfig a() {
            return f14930a;
        }
    }

    public static List<HostRegexToRegionMapping> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3\\.amazonaws\\.com", "us-east-1"));
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3-external-1\\.amazonaws\\.com", "us-east-1"));
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3-fips-us-gov-west-1\\.amazonaws\\.com", "us-gov-west-1"));
        return arrayList;
    }

    public static Map<String, HttpClientConfig> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("AmazonCloudWatchClient", new HttpClientConfig("monitoring"));
        hashMap.put("AmazonCloudWatchLogsClient", new HttpClientConfig("logs"));
        hashMap.put("AmazonCognitoIdentityClient", new HttpClientConfig("cognito-identity"));
        hashMap.put("AmazonCognitoIdentityProviderClient", new HttpClientConfig("cognito-idp"));
        hashMap.put("AmazonCognitoSyncClient", new HttpClientConfig("cognito-sync"));
        hashMap.put("AmazonComprehendClient", new HttpClientConfig("comprehend"));
        hashMap.put("AmazonConnectClient", new HttpClientConfig("connect"));
        hashMap.put("AmazonKinesisFirehoseClient", new HttpClientConfig("firehose"));
        hashMap.put("AWSKinesisVideoArchivedMediaClient", new HttpClientConfig("kinesisvideo"));
        hashMap.put("AWSKinesisVideoSignalingClient", new HttpClientConfig("kinesisvideo"));
        hashMap.put("AWSIotClient", new HttpClientConfig("execute-api"));
        hashMap.put("AmazonLexRuntimeClient", new HttpClientConfig("lex"));
        hashMap.put("AmazonPinpointClient", new HttpClientConfig("mobiletargeting"));
        hashMap.put("AmazonPinpointAnalyticsClient", new HttpClientConfig("mobileanalytics"));
        hashMap.put("AmazonSageMakerRuntimeClient", new HttpClientConfig("sagemaker"));
        hashMap.put("AmazonSimpleDBClient", new HttpClientConfig("sdb"));
        hashMap.put("AmazonSimpleEmailServiceClient", new HttpClientConfig("email"));
        hashMap.put("AWSSecurityTokenServiceClient", new HttpClientConfig("sts"));
        hashMap.put("AmazonTextractClient", new HttpClientConfig("textract"));
        hashMap.put("AmazonTranscribeClient", new HttpClientConfig("transcribe"));
        hashMap.put("AmazonTranslateClient", new HttpClientConfig("translate"));
        return hashMap;
    }

    public static Map<String, SignerConfig> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("eu-central-1", new SignerConfig("AWS4SignerType"));
        hashMap.put("cn-north-1", new SignerConfig("AWS4SignerType"));
        return hashMap;
    }

    public static Map<String, SignerConfig> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("s3/eu-central-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/cn-north-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/us-east-2", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ca-central-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ap-south-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ap-northeast-2", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/eu-west-2", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("lex/eu-central-1", new SignerConfig("AmazonLexV4Signer"));
        hashMap.put("lex/cn-north-1", new SignerConfig("AmazonLexV4Signer"));
        hashMap.put("polly/eu-central-1", new SignerConfig("AmazonPollyCustomPresigner"));
        hashMap.put("polly/cn-north-1", new SignerConfig("AmazonPollyCustomPresigner"));
        return hashMap;
    }

    public static Map<String, SignerConfig> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("ec2", new SignerConfig("QueryStringSignerType"));
        hashMap.put("email", new SignerConfig("AWS4SignerType"));
        hashMap.put("s3", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("sdb", new SignerConfig("QueryStringSignerType"));
        hashMap.put("lex", new SignerConfig("AmazonLexV4Signer"));
        hashMap.put("polly", new SignerConfig("AmazonPollyCustomPresigner"));
        return hashMap;
    }

    public static SignerConfig f() {
        return new SignerConfig("AWS4SignerType");
    }

    public List<HostRegexToRegionMapping> g() {
        return Collections.unmodifiableList(this.f14929f);
    }

    public HttpClientConfig h(String str) {
        return this.f14928e.get(str);
    }

    public SignerConfig i(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                SignerConfig signerConfig = this.f14925b.get(str + "/" + str2);
                if (signerConfig != null) {
                    return signerConfig;
                }
                SignerConfig signerConfig2 = this.f14926c.get(str2);
                if (signerConfig2 != null) {
                    return signerConfig2;
                }
            }
            SignerConfig signerConfig3 = this.f14927d.get(str);
            return signerConfig3 == null ? this.f14924a : signerConfig3;
        }
        throw new IllegalArgumentException();
    }
}
