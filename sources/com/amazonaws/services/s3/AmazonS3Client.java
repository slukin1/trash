package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.internal.AWSS3V4Signer;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition;
import com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazonaws.services.s3.internal.S3ExecutionContext;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler;
import com.amazonaws.services.s3.internal.S3Signer;
import com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3AccelerateUnsupported;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.HeadBucketResultHandler;
import com.amazonaws.services.s3.model.transform.RequestPaymentConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazonaws.services.s3.model.transform.Unmarshallers;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.util.ValidationUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

public class AmazonS3Client extends AmazonWebServiceClient implements AmazonS3 {

    /* renamed from: s  reason: collision with root package name */
    public static Log f15109s = LogFactory.b(AmazonS3Client.class);

    /* renamed from: t  reason: collision with root package name */
    public static final BucketConfigurationXmlFactory f15110t = new BucketConfigurationXmlFactory();

    /* renamed from: u  reason: collision with root package name */
    public static final RequestPaymentConfigurationXmlFactory f15111u = new RequestPaymentConfigurationXmlFactory();

    /* renamed from: v  reason: collision with root package name */
    public static final Map<String, String> f15112v = Collections.synchronizedMap(new LinkedHashMap<String, String>(300, 1.1f, true) {
        private static final long serialVersionUID = 23453;

        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 300;
        }
    });

    /* renamed from: l  reason: collision with root package name */
    public final S3ErrorResponseHandler f15113l;

    /* renamed from: m  reason: collision with root package name */
    public final S3XmlResponseHandler<Void> f15114m;

    /* renamed from: n  reason: collision with root package name */
    public S3ClientOptions f15115n;

    /* renamed from: o  reason: collision with root package name */
    public final AWSCredentialsProvider f15116o;

    /* renamed from: p  reason: collision with root package name */
    public volatile String f15117p;

    /* renamed from: q  reason: collision with root package name */
    public int f15118q;

    /* renamed from: r  reason: collision with root package name */
    public final CompleteMultipartUploadRetryCondition f15119r;

    static {
        AwsSdkMetrics.addAll(Arrays.asList(S3ServiceMetric.b()));
        SignerFactory.e("AWSS3V4SignerType", AWSS3V4Signer.class);
    }

    @Deprecated
    public AmazonS3Client() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public static void A(Request<?> request, String str, Date date) {
        if (date != null) {
            request.a(str, ServiceUtils.a(date));
        }
    }

    public static void B(Request<?> request, String str, String str2) {
        if (str2 != null) {
            request.a(str, str2);
        }
    }

    public static void C(Request<?> request, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.b() != null) {
                request.p("response-cache-control", responseHeaderOverrides.b());
            }
            if (responseHeaderOverrides.c() != null) {
                request.p("response-content-disposition", responseHeaderOverrides.c());
            }
            if (responseHeaderOverrides.d() != null) {
                request.p("response-content-encoding", responseHeaderOverrides.d());
            }
            if (responseHeaderOverrides.e() != null) {
                request.p("response-content-language", responseHeaderOverrides.e());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                request.p("response-content-type", responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.f() != null) {
                request.p("response-expires", responseHeaderOverrides.f());
            }
        }
    }

    public static void D(Request<?> request, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            request.a(str, ServiceUtils.b(list));
        }
    }

    public static boolean X(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i11 = 0;
        while (i11 < length) {
            try {
                int parseInt = Integer.parseInt(split[i11]);
                if (parseInt >= 0 && parseInt <= 255) {
                    i11++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    public static void Z(Request<?> request, ObjectMetadata objectMetadata) {
        Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
        if (rawMetadata.get("x-amz-server-side-encryption-aws-kms-key-id") == null || ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION.equals(rawMetadata.get("x-amz-server-side-encryption"))) {
            for (Map.Entry next : rawMetadata.entrySet()) {
                request.a((String) next.getKey(), next.getValue().toString());
            }
            Date httpExpiresDate = objectMetadata.getHttpExpiresDate();
            if (httpExpiresDate != null) {
                request.a(HttpHeaders.EXPIRES, DateUtils.d(httpExpiresDate));
            }
            Map<String, String> userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Map.Entry next2 : userMetadata.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    if (!"x-amz-tagging".equals(str)) {
                        request.a("x-amz-meta-" + str, str2);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("If you specify a KMS key id for server side encryption, you must also set the SSEAlgorithm to ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION");
    }

    public static void a0(Request<?> request, boolean z11) {
        if (z11) {
            request.a("x-amz-request-payer", "requester");
        }
    }

    public static void b0(Request<?> request, SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey != null) {
            B(request, "x-amz-server-side-encryption-customer-algorithm", sSECustomerKey.b());
            B(request, "x-amz-server-side-encryption-customer-key", sSECustomerKey.c());
            B(request, "x-amz-server-side-encryption-customer-key-MD5", sSECustomerKey.d());
            if (sSECustomerKey.c() != null && sSECustomerKey.d() == null) {
                request.a("x-amz-server-side-encryption-customer-key-MD5", Md5Utils.f(Base64.decode(sSECustomerKey.c())));
            }
        }
    }

    public static void c0(Request<?> request, SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null) {
            B(request, "x-amz-server-side-encryption", sSEAwsKeyManagementParams.getEncryption());
            B(request, "x-amz-server-side-encryption-aws-kms-key-id", sSEAwsKeyManagementParams.getAwsKmsKeyId());
        }
    }

    public static void z(Request<? extends AmazonWebServiceRequest> request, AccessControlList accessControlList) {
        Set<Grant> grants = accessControlList.getGrants();
        HashMap hashMap = new HashMap();
        for (Grant next : grants) {
            if (!hashMap.containsKey(next.b())) {
                hashMap.put(next.b(), new LinkedList());
            }
            ((Collection) hashMap.get(next.b())).add(next.a());
        }
        for (Permission permission : Permission.values()) {
            if (hashMap.containsKey(permission)) {
                StringBuilder sb2 = new StringBuilder();
                boolean z11 = false;
                for (Grantee grantee : (Collection) hashMap.get(permission)) {
                    if (!z11) {
                        z11 = true;
                    } else {
                        sb2.append(", ");
                    }
                    sb2.append(grantee.getTypeIdentifier());
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb2.append("\"");
                    sb2.append(grantee.getIdentifier());
                    sb2.append("\"");
                }
                request.a(permission.getHeaderName(), sb2.toString());
            }
        }
    }

    public final long E(InputStream inputStream) {
        byte[] bArr = new byte[8192];
        inputStream.mark(-1);
        long j11 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    j11 += (long) read;
                } else {
                    inputStream.reset();
                    return j11;
                }
            } catch (IOException e11) {
                throw new AmazonClientException("Could not calculate content length.", e11);
            }
        }
    }

    public final URI F(URI uri, String str) {
        try {
            return new URI(uri.getScheme() + "://" + str + InstructionFileId.DOT + uri.getAuthority());
        } catch (URISyntaxException e11) {
            throw new IllegalArgumentException("Invalid bucket name: " + str, e11);
        }
    }

    public final ExecutionContext G(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new S3ExecutionContext(this.f14764e, u(amazonWebServiceRequest) || AmazonWebServiceClient.s(), this);
    }

    public <X extends AmazonWebServiceRequest> Request<X> H(String str, String str2, X x11, HttpMethodName httpMethodName) {
        return I(str, str2, x11, httpMethodName, (URI) null);
    }

    public <X extends AmazonWebServiceRequest> Request<X> I(String str, String str2, X x11, HttpMethodName httpMethodName, URI uri) {
        DefaultRequest defaultRequest = new DefaultRequest(x11, "Amazon S3");
        if (!this.f15115n.a() || (defaultRequest.q() instanceof S3AccelerateUnsupported)) {
            if (this.f15115n.c()) {
                uri = RuntimeHttpUtils.a(String.format("s3.dualstack.%s.amazonaws.com", new Object[]{Q()}), this.f14762c);
            }
        } else if (this.f15115n.c()) {
            uri = RuntimeHttpUtils.a("s3-accelerate.dualstack.amazonaws.com", this.f14762c);
        } else {
            uri = RuntimeHttpUtils.a("s3-accelerate.amazonaws.com", this.f14762c);
        }
        defaultRequest.k(httpMethodName);
        e0(defaultRequest, str, str2, uri);
        return defaultRequest;
    }

    @Deprecated
    public final S3Signer J(Request<?> request, String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        if (str != null) {
            str3 = str + "/";
        } else {
            str3 = "";
        }
        sb2.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        return new S3Signer(request.j().toString(), sb2.toString());
    }

    public Signer K(Request<?> request, String str, String str2) {
        URI uri;
        String str3;
        if (this.f15115n.a()) {
            uri = this.f14760a;
        } else {
            uri = request.t();
        }
        Signer q11 = q(uri);
        if (!V()) {
            if ((q11 instanceof AWSS3V4Signer) && Y(request)) {
                String str4 = this.f15117p == null ? f15112v.get(str) : this.f15117p;
                if (str4 != null) {
                    e0(request, str, str2, RuntimeHttpUtils.a(RegionUtils.a(str4).g("s3"), this.f14762c));
                    AWSS3V4Signer aWSS3V4Signer = (AWSS3V4Signer) q11;
                    f0(aWSS3V4Signer, str4);
                    return aWSS3V4Signer;
                } else if (request.q() instanceof GeneratePresignedUrlRequest) {
                    return J(request, str, str2);
                }
            }
            if (r() == null) {
                str3 = this.f15117p == null ? f15112v.get(str) : this.f15117p;
            } else {
                str3 = r();
            }
            if (str3 != null) {
                AWSS3V4Signer aWSS3V4Signer2 = new AWSS3V4Signer();
                f0(aWSS3V4Signer2, str3);
                return aWSS3V4Signer2;
            }
        }
        return q11 instanceof S3Signer ? J(request, str, str2) : q11;
    }

    public final String L(String str) {
        Map<String, String> map = f15112v;
        String str2 = map.get(str);
        if (str2 == null) {
            if (f15109s.i()) {
                Log log = f15109s;
                log.h("Bucket region cache doesn't have an entry for " + str + ". Trying to get bucket region from Amazon S3.");
            }
            str2 = N(str);
            if (str2 != null) {
                map.put(str, str2);
            }
        }
        if (f15109s.i()) {
            Log log2 = f15109s;
            log2.h("Region for " + str + " is " + str2);
        }
        return str2;
    }

    public final void M(ProgressListenerCallbackExecutor progressListenerCallbackExecutor, int i11) {
        if (progressListenerCallbackExecutor != null) {
            ProgressEvent progressEvent = new ProgressEvent(0);
            progressEvent.c(i11);
            progressListenerCallbackExecutor.c(progressEvent);
        }
    }

    public final String N(String str) {
        String str2 = null;
        try {
            str2 = ((HeadBucketResult) U(I(str, (String) null, new HeadBucketRequest(str), HttpMethodName.HEAD, new URI("https://s3-us-west-1.amazonaws.com")), new HeadBucketResultHandler(), str, (String) null)).a();
        } catch (AmazonS3Exception e11) {
            if (e11.getAdditionalDetails() != null) {
                str2 = e11.getAdditionalDetails().get("x-amz-bucket-region");
            }
        } catch (URISyntaxException unused) {
            f15109s.g("Error while creating URI");
        }
        if (str2 == null && f15109s.i()) {
            Log log = f15109s;
            log.h("Not able to derive region of the " + str + " from the HEAD Bucket requests.");
        }
        return str2;
    }

    public final String O(String str) {
        if (str == null || !str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    public final String P(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/");
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public String Q() {
        String authority = this.f14760a.getAuthority();
        if ("s3.amazonaws.com".equals(authority)) {
            return "us-east-1";
        }
        Matcher matcher = Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
        try {
            matcher.matches();
            return RegionUtils.a(matcher.group(1)).d();
        } catch (Exception e11) {
            throw new IllegalStateException("No valid region has been specified. Unable to return region name", e11);
        }
    }

    public final String R() {
        String r11 = r();
        return r11 == null ? this.f15117p : r11;
    }

    @Deprecated
    public final void S() {
        w("s3.amazonaws.com");
        this.f14768i = "s3";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f14764e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
        this.f14764e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
    }

    public final void T(com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration) {
        if (this.f15116o == null) {
            throw new IllegalArgumentException("Credentials cannot be null. Credentials is required to sign the request");
        } else if (region != null) {
            this.f14762c = clientConfiguration;
            this.f14768i = "s3";
            w("s3.amazonaws.com");
            x(region);
            HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
            this.f14764e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
            this.f14764e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
            Log log = f15109s;
            log.h("initialized with endpoint = " + this.f14760a);
        } else {
            throw new IllegalArgumentException("Region cannot be null. Region is required to sign the request");
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.amazonaws.Request, com.amazonaws.Request<Y>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <X, Y extends com.amazonaws.AmazonWebServiceRequest> X U(com.amazonaws.Request<Y> r8, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<X>> r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "Content-Type"
            com.amazonaws.AmazonWebServiceRequest r1 = r8.q()
            com.amazonaws.http.ExecutionContext r2 = r7.G(r1)
            com.amazonaws.util.AWSRequestMetrics r3 = r2.a()
            r8.f(r3)
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r3.g(r4)
            r4 = 0
            long r5 = r7.f14765f     // Catch:{ AmazonS3Exception -> 0x0065 }
            r8.o(r5)     // Catch:{ AmazonS3Exception -> 0x0065 }
            java.util.Map r5 = r8.getHeaders()     // Catch:{ AmazonS3Exception -> 0x0065 }
            boolean r5 = r5.containsKey(r0)     // Catch:{ AmazonS3Exception -> 0x0065 }
            if (r5 != 0) goto L_0x002b
            java.lang.String r5 = "application/octet-stream"
            r8.a(r0, r5)     // Catch:{ AmazonS3Exception -> 0x0065 }
        L_0x002b:
            if (r10 == 0) goto L_0x0039
            r8.q()     // Catch:{ AmazonS3Exception -> 0x0065 }
            boolean r0 = r7.Y(r8)     // Catch:{ AmazonS3Exception -> 0x0065 }
            if (r0 == 0) goto L_0x0039
            r7.L(r10)     // Catch:{ AmazonS3Exception -> 0x0065 }
        L_0x0039:
            com.amazonaws.auth.AWSCredentialsProvider r0 = r7.f15116o     // Catch:{ AmazonS3Exception -> 0x0065 }
            com.amazonaws.auth.AWSCredentials r0 = r0.a()     // Catch:{ AmazonS3Exception -> 0x0065 }
            com.amazonaws.auth.AWSCredentials r5 = r1.getRequestCredentials()     // Catch:{ AmazonS3Exception -> 0x0065 }
            if (r5 == 0) goto L_0x0049
            com.amazonaws.auth.AWSCredentials r0 = r1.getRequestCredentials()     // Catch:{ AmazonS3Exception -> 0x0065 }
        L_0x0049:
            com.amazonaws.auth.Signer r11 = r7.K(r8, r10, r11)     // Catch:{ AmazonS3Exception -> 0x0065 }
            r2.g(r11)     // Catch:{ AmazonS3Exception -> 0x0065 }
            r2.f(r0)     // Catch:{ AmazonS3Exception -> 0x0065 }
            com.amazonaws.http.AmazonHttpClient r11 = r7.f14763d     // Catch:{ AmazonS3Exception -> 0x0065 }
            com.amazonaws.services.s3.internal.S3ErrorResponseHandler r0 = r7.f15113l     // Catch:{ AmazonS3Exception -> 0x0065 }
            com.amazonaws.Response r4 = r11.d(r8, r9, r0, r2)     // Catch:{ AmazonS3Exception -> 0x0065 }
            java.lang.Object r9 = r4.a()     // Catch:{ AmazonS3Exception -> 0x0065 }
            r7.k(r3, r8, r4)
            return r9
        L_0x0063:
            r9 = move-exception
            goto L_0x009f
        L_0x0065:
            r9 = move-exception
            int r11 = r9.getStatusCode()     // Catch:{ all -> 0x0063 }
            r0 = 301(0x12d, float:4.22E-43)
            if (r11 != r0) goto L_0x009e
            java.util.Map r11 = r9.getAdditionalDetails()     // Catch:{ all -> 0x0063 }
            if (r11 == 0) goto L_0x009e
            java.util.Map r11 = r9.getAdditionalDetails()     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = "x-amz-bucket-region"
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0063 }
            java.util.Map<java.lang.String, java.lang.String> r0 = f15112v     // Catch:{ all -> 0x0063 }
            r0.put(r10, r11)     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r10.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = "The bucket is in this region: "
            r10.append(r0)     // Catch:{ all -> 0x0063 }
            r10.append(r11)     // Catch:{ all -> 0x0063 }
            java.lang.String r11 = ". Please use this region to retry the request"
            r10.append(r11)     // Catch:{ all -> 0x0063 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0063 }
            r9.setErrorMessage(r10)     // Catch:{ all -> 0x0063 }
        L_0x009e:
            throw r9     // Catch:{ all -> 0x0063 }
        L_0x009f:
            r7.k(r3, r8, r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.U(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, java.lang.String, java.lang.String):java.lang.Object");
    }

    public final boolean V() {
        ClientConfiguration clientConfiguration = this.f14762c;
        return (clientConfiguration == null || clientConfiguration.e() == null) ? false : true;
    }

    public final boolean W(URI uri) {
        return uri.getHost().endsWith("s3.amazonaws.com");
    }

    public final boolean Y(Request<?> request) {
        return W(request.t()) && R() == null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.amazonaws.event.ProgressReportingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: com.amazonaws.event.ProgressReportingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: com.amazonaws.services.s3.internal.InputSubstream} */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.s3.model.UploadPartResult a(com.amazonaws.services.s3.model.UploadPartRequest r13) throws com.amazonaws.AmazonClientException, com.amazonaws.AmazonServiceException {
        /*
            r12 = this;
            java.lang.String r0 = "The request parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r13, r0)
            java.lang.String r0 = r13.getBucketName()
            java.lang.String r1 = r13.getKey()
            java.lang.String r2 = r13.getUploadId()
            int r3 = r13.getPartNumber()
            long r8 = r13.getPartSize()
            java.lang.String r4 = "The bucket name parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r0, r4)
            java.lang.String r4 = "The key parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r1, r4)
            java.lang.String r4 = "The upload ID parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r2, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "The part number parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r4, r5)
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            java.lang.String r5 = "The part size parameter must be specified when uploading a part"
            com.amazonaws.util.ValidationUtils.a(r4, r5)
            com.amazonaws.http.HttpMethodName r4 = com.amazonaws.http.HttpMethodName.PUT
            com.amazonaws.Request r11 = r12.H(r0, r1, r13, r4)
            java.lang.String r4 = "uploadId"
            r11.p(r4, r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "partNumber"
            r11.p(r4, r2)
            com.amazonaws.services.s3.model.ObjectMetadata r2 = r13.getObjectMetadata()
            if (r2 == 0) goto L_0x0057
            Z(r11, r2)
        L_0x0057:
            java.lang.String r2 = java.lang.Long.toString(r8)
            java.lang.String r4 = "Content-Length"
            r11.a(r4, r2)
            boolean r2 = r13.isRequesterPays()
            a0(r11, r2)
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r13.getSSECustomerKey()
            b0(r11, r2)
            java.io.InputStream r2 = r13.getInputStream()
            if (r2 == 0) goto L_0x0079
            java.io.InputStream r2 = r13.getInputStream()
            goto L_0x0093
        L_0x0079:
            java.io.File r2 = r13.getFile()
            if (r2 == 0) goto L_0x0146
            com.amazonaws.services.s3.internal.InputSubstream r2 = new com.amazonaws.services.s3.internal.InputSubstream     // Catch:{ FileNotFoundException -> 0x013d }
            com.amazonaws.services.s3.internal.RepeatableFileInputStream r5 = new com.amazonaws.services.s3.internal.RepeatableFileInputStream     // Catch:{ FileNotFoundException -> 0x013d }
            java.io.File r4 = r13.getFile()     // Catch:{ FileNotFoundException -> 0x013d }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x013d }
            long r6 = r13.getFileOffset()     // Catch:{ FileNotFoundException -> 0x013d }
            r10 = 1
            r4 = r2
            r4.<init>(r5, r6, r8, r10)     // Catch:{ FileNotFoundException -> 0x013d }
        L_0x0093:
            java.lang.String r4 = r13.getMd5Digest()
            if (r4 != 0) goto L_0x00d0
            com.amazonaws.services.s3.S3ClientOptions r4 = r12.f15115n
            boolean r4 = com.amazonaws.services.s3.internal.ServiceUtils.f(r13, r4)
            if (r4 != 0) goto L_0x00d0
            boolean r4 = r2.markSupported()
            if (r4 == 0) goto L_0x00d0
            java.lang.String r4 = com.amazonaws.util.Md5Utils.e(r2)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r5 = "Content-MD5"
            B(r11, r5, r4)     // Catch:{ Exception -> 0x00b4 }
            r2.reset()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00d0
        L_0x00b4:
            r13 = move-exception
            com.amazonaws.AmazonClientException r0 = new com.amazonaws.AmazonClientException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to calculate MD5 hash: "
            r1.append(r2)
            java.lang.String r2 = r13.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r13)
            throw r0
        L_0x00d0:
            com.amazonaws.event.ProgressListener r13 = r13.getGeneralProgressListener()
            com.amazonaws.event.ProgressListenerCallbackExecutor r13 = com.amazonaws.event.ProgressListenerCallbackExecutor.d(r13)
            if (r13 == 0) goto L_0x00ea
            com.amazonaws.event.ProgressReportingInputStream r4 = new com.amazonaws.event.ProgressReportingInputStream
            r4.<init>(r2, r13)
            int r2 = r12.f15118q
            r4.k(r2)
            r2 = 1024(0x400, float:1.435E-42)
            r12.M(r13, r2)
            r2 = r4
        L_0x00ea:
            r11.b(r2)     // Catch:{ AmazonClientException -> 0x0130 }
            com.amazonaws.services.s3.internal.S3MetadataResponseHandler r4 = new com.amazonaws.services.s3.internal.S3MetadataResponseHandler     // Catch:{ AmazonClientException -> 0x0130 }
            r4.<init>()     // Catch:{ AmazonClientException -> 0x0130 }
            java.lang.Object r0 = r12.U(r11, r4, r0, r1)     // Catch:{ AmazonClientException -> 0x0130 }
            com.amazonaws.services.s3.model.ObjectMetadata r0 = (com.amazonaws.services.s3.model.ObjectMetadata) r0     // Catch:{ AmazonClientException -> 0x0130 }
            r1 = 2048(0x800, float:2.87E-42)
            r12.M(r13, r1)     // Catch:{ AmazonClientException -> 0x0130 }
            com.amazonaws.services.s3.model.UploadPartResult r1 = new com.amazonaws.services.s3.model.UploadPartResult     // Catch:{ AmazonClientException -> 0x0130 }
            r1.<init>()     // Catch:{ AmazonClientException -> 0x0130 }
            java.lang.String r4 = r0.getETag()     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setETag(r4)     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setPartNumber(r3)     // Catch:{ AmazonClientException -> 0x0130 }
            java.lang.String r3 = r0.getSSEAlgorithm()     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setSSEAlgorithm(r3)     // Catch:{ AmazonClientException -> 0x0130 }
            java.lang.String r3 = r0.getSSECustomerAlgorithm()     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setSSECustomerAlgorithm(r3)     // Catch:{ AmazonClientException -> 0x0130 }
            java.lang.String r3 = r0.getSSECustomerKeyMd5()     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setSSECustomerKeyMd5(r3)     // Catch:{ AmazonClientException -> 0x0130 }
            boolean r0 = r0.isRequesterCharged()     // Catch:{ AmazonClientException -> 0x0130 }
            r1.setRequesterCharged(r0)     // Catch:{ AmazonClientException -> 0x0130 }
            if (r2 == 0) goto L_0x012d
            r2.close()     // Catch:{ Exception -> 0x012d }
        L_0x012d:
            return r1
        L_0x012e:
            r13 = move-exception
            goto L_0x0137
        L_0x0130:
            r0 = move-exception
            r1 = 4096(0x1000, float:5.74E-42)
            r12.M(r13, r1)     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ all -> 0x012e }
        L_0x0137:
            if (r2 == 0) goto L_0x013c
            r2.close()     // Catch:{ Exception -> 0x013c }
        L_0x013c:
            throw r13
        L_0x013d:
            r13 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The specified file doesn't exist"
            r0.<init>(r1, r13)
            throw r0
        L_0x0146:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "A File or InputStream must be specified when uploading part"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.a(com.amazonaws.services.s3.model.UploadPartRequest):com.amazonaws.services.s3.model.UploadPartResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.amazonaws.util.ServiceClientHolderInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.amazonaws.util.ServiceClientHolderInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: com.amazonaws.event.ProgressReportingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.amazonaws.util.ServiceClientHolderInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.s3.model.S3Object b(com.amazonaws.services.s3.model.GetObjectRequest r9) throws com.amazonaws.AmazonClientException, com.amazonaws.AmazonServiceException {
        /*
            r8 = this;
            java.lang.String r0 = "The GetObjectRequest parameter must be specified when requesting an object"
            com.amazonaws.util.ValidationUtils.a(r9, r0)
            java.lang.String r0 = r9.getBucketName()
            java.lang.String r1 = "The bucket name parameter must be specified when requesting an object"
            com.amazonaws.util.ValidationUtils.a(r0, r1)
            java.lang.String r0 = r9.getKey()
            java.lang.String r1 = "The key parameter must be specified when requesting an object"
            com.amazonaws.util.ValidationUtils.a(r0, r1)
            java.lang.String r0 = r9.getBucketName()
            java.lang.String r1 = r9.getKey()
            com.amazonaws.http.HttpMethodName r2 = com.amazonaws.http.HttpMethodName.GET
            com.amazonaws.Request r0 = r8.H(r0, r1, r9, r2)
            java.lang.String r1 = r9.getVersionId()
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r9.getVersionId()
            java.lang.String r2 = "versionId"
            r0.p(r2, r1)
        L_0x0034:
            long[] r1 = r9.getRange()
            r2 = 1
            if (r1 == 0) goto L_0x007a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "bytes="
            r3.append(r4)
            r4 = 0
            r4 = r1[r4]
            java.lang.String r4 = java.lang.Long.toString(r4)
            r3.append(r4)
            java.lang.String r4 = "-"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = r1[r2]
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x0075
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r5 = r1[r2]
            java.lang.String r1 = java.lang.Long.toString(r5)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
        L_0x0075:
            java.lang.String r1 = "Range"
            r0.a(r1, r3)
        L_0x007a:
            boolean r1 = r9.isRequesterPays()
            a0(r0, r1)
            com.amazonaws.services.s3.model.ResponseHeaderOverrides r1 = r9.getResponseHeaders()
            C(r0, r1)
            java.util.Date r1 = r9.getModifiedSinceConstraint()
            java.lang.String r3 = "If-Modified-Since"
            A(r0, r3, r1)
            java.util.Date r1 = r9.getUnmodifiedSinceConstraint()
            java.lang.String r3 = "If-Unmodified-Since"
            A(r0, r3, r1)
            java.util.List r1 = r9.getMatchingETagConstraints()
            java.lang.String r3 = "If-Match"
            D(r0, r3, r1)
            java.util.List r1 = r9.getNonmatchingETagConstraints()
            java.lang.String r3 = "If-None-Match"
            D(r0, r3, r1)
            com.amazonaws.services.s3.model.SSECustomerKey r1 = r9.getSSECustomerKey()
            b0(r0, r1)
            com.amazonaws.event.ProgressListener r1 = r9.getGeneralProgressListener()
            com.amazonaws.event.ProgressListenerCallbackExecutor r1 = com.amazonaws.event.ProgressListenerCallbackExecutor.d(r1)
            com.amazonaws.services.s3.internal.S3ObjectResponseHandler r3 = new com.amazonaws.services.s3.internal.S3ObjectResponseHandler     // Catch:{ AmazonS3Exception -> 0x010f }
            r3.<init>()     // Catch:{ AmazonS3Exception -> 0x010f }
            java.lang.String r4 = r9.getBucketName()     // Catch:{ AmazonS3Exception -> 0x010f }
            java.lang.String r5 = r9.getKey()     // Catch:{ AmazonS3Exception -> 0x010f }
            java.lang.Object r0 = r8.U(r0, r3, r4, r5)     // Catch:{ AmazonS3Exception -> 0x010f }
            com.amazonaws.services.s3.model.S3Object r0 = (com.amazonaws.services.s3.model.S3Object) r0     // Catch:{ AmazonS3Exception -> 0x010f }
            java.lang.String r3 = r9.getBucketName()     // Catch:{ AmazonS3Exception -> 0x010f }
            r0.setBucketName(r3)     // Catch:{ AmazonS3Exception -> 0x010f }
            java.lang.String r9 = r9.getKey()     // Catch:{ AmazonS3Exception -> 0x010f }
            r0.setKey(r9)     // Catch:{ AmazonS3Exception -> 0x010f }
            com.amazonaws.services.s3.model.S3ObjectInputStream r9 = r0.getObjectContent()     // Catch:{ AmazonS3Exception -> 0x010f }
            com.amazonaws.util.ServiceClientHolderInputStream r3 = new com.amazonaws.util.ServiceClientHolderInputStream     // Catch:{ AmazonS3Exception -> 0x010f }
            r3.<init>(r9, r8)     // Catch:{ AmazonS3Exception -> 0x010f }
            if (r1 == 0) goto L_0x00f9
            com.amazonaws.event.ProgressReportingInputStream r9 = new com.amazonaws.event.ProgressReportingInputStream     // Catch:{ AmazonS3Exception -> 0x010f }
            r9.<init>(r3, r1)     // Catch:{ AmazonS3Exception -> 0x010f }
            r9.j(r2)     // Catch:{ AmazonS3Exception -> 0x010f }
            int r3 = r8.f15118q     // Catch:{ AmazonS3Exception -> 0x010f }
            r9.k(r3)     // Catch:{ AmazonS3Exception -> 0x010f }
            r3 = 2
            r8.M(r1, r3)     // Catch:{ AmazonS3Exception -> 0x010f }
            r3 = r9
        L_0x00f9:
            com.amazonaws.util.LengthCheckInputStream r9 = new com.amazonaws.util.LengthCheckInputStream     // Catch:{ AmazonS3Exception -> 0x010f }
            com.amazonaws.services.s3.model.ObjectMetadata r4 = r0.getObjectMetadata()     // Catch:{ AmazonS3Exception -> 0x010f }
            long r4 = r4.getContentLength()     // Catch:{ AmazonS3Exception -> 0x010f }
            r9.<init>(r3, r4, r2)     // Catch:{ AmazonS3Exception -> 0x010f }
            com.amazonaws.services.s3.model.S3ObjectInputStream r2 = new com.amazonaws.services.s3.model.S3ObjectInputStream     // Catch:{ AmazonS3Exception -> 0x010f }
            r2.<init>(r9)     // Catch:{ AmazonS3Exception -> 0x010f }
            r0.setObjectContent((com.amazonaws.services.s3.model.S3ObjectInputStream) r2)     // Catch:{ AmazonS3Exception -> 0x010f }
            return r0
        L_0x010f:
            r9 = move-exception
            int r0 = r9.getStatusCode()
            r2 = 412(0x19c, float:5.77E-43)
            if (r0 == r2) goto L_0x0127
            int r0 = r9.getStatusCode()
            r2 = 304(0x130, float:4.26E-43)
            if (r0 != r2) goto L_0x0121
            goto L_0x0127
        L_0x0121:
            r0 = 8
            r8.M(r1, r0)
            throw r9
        L_0x0127:
            r9 = 16
            r8.M(r1, r9)
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.b(com.amazonaws.services.s3.model.GetObjectRequest):com.amazonaws.services.s3.model.S3Object");
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.s3.model.PutObjectResult c(com.amazonaws.services.s3.model.PutObjectRequest r18) throws com.amazonaws.AmazonClientException, com.amazonaws.AmazonServiceException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "Unable to cleanly close input stream: "
            java.lang.String r3 = "The PutObjectRequest parameter must be specified when uploading an object"
            com.amazonaws.util.ValidationUtils.a(r0, r3)
            java.lang.String r3 = r18.getBucketName()
            java.lang.String r4 = r18.getKey()
            com.amazonaws.services.s3.model.ObjectMetadata r5 = r18.getMetadata()
            java.io.InputStream r6 = r18.getInputStream()
            com.amazonaws.event.ProgressListener r7 = r18.getGeneralProgressListener()
            com.amazonaws.event.ProgressListenerCallbackExecutor r7 = com.amazonaws.event.ProgressListenerCallbackExecutor.d(r7)
            if (r5 != 0) goto L_0x002a
            com.amazonaws.services.s3.model.ObjectMetadata r5 = new com.amazonaws.services.s3.model.ObjectMetadata
            r5.<init>()
        L_0x002a:
            java.lang.String r8 = "The bucket name parameter must be specified when uploading an object"
            com.amazonaws.util.ValidationUtils.a(r3, r8)
            java.lang.String r8 = "The key parameter must be specified when uploading an object"
            com.amazonaws.util.ValidationUtils.a(r4, r8)
            com.amazonaws.services.s3.S3ClientOptions r8 = r1.f15115n
            boolean r8 = com.amazonaws.services.s3.internal.ServiceUtils.f(r0, r8)
            java.io.File r9 = r18.getFile()
            r10 = 1
            r11 = 0
            if (r9 == 0) goto L_0x009f
            java.io.File r6 = r18.getFile()
            long r12 = r6.length()
            r5.setContentLength(r12)
            java.lang.String r9 = r5.getContentMD5()
            if (r9 != 0) goto L_0x0055
            r9 = r10
            goto L_0x0056
        L_0x0055:
            r9 = r11
        L_0x0056:
            java.lang.String r12 = r5.getContentType()
            if (r12 != 0) goto L_0x0067
            com.amazonaws.services.s3.util.Mimetypes r12 = com.amazonaws.services.s3.util.Mimetypes.a()
            java.lang.String r12 = r12.b(r6)
            r5.setContentType(r12)
        L_0x0067:
            if (r9 == 0) goto L_0x008f
            if (r8 != 0) goto L_0x008f
            java.lang.String r8 = com.amazonaws.util.Md5Utils.d(r6)     // Catch:{ Exception -> 0x0073 }
            r5.setContentMD5(r8)     // Catch:{ Exception -> 0x0073 }
            goto L_0x008f
        L_0x0073:
            r0 = move-exception
            com.amazonaws.AmazonClientException r2 = new com.amazonaws.AmazonClientException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to calculate MD5 hash: "
            r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0)
            throw r2
        L_0x008f:
            com.amazonaws.services.s3.internal.RepeatableFileInputStream r8 = new com.amazonaws.services.s3.internal.RepeatableFileInputStream     // Catch:{ FileNotFoundException -> 0x0096 }
            r8.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0096 }
            r6 = r8
            goto L_0x009f
        L_0x0096:
            r0 = move-exception
            com.amazonaws.AmazonClientException r2 = new com.amazonaws.AmazonClientException
            java.lang.String r3 = "Unable to find file to upload"
            r2.<init>(r3, r0)
            throw r2
        L_0x009f:
            com.amazonaws.http.HttpMethodName r8 = com.amazonaws.http.HttpMethodName.PUT
            com.amazonaws.Request r8 = r1.H(r3, r4, r0, r8)
            com.amazonaws.services.s3.model.AccessControlList r9 = r18.getAccessControlList()
            if (r9 == 0) goto L_0x00b3
            com.amazonaws.services.s3.model.AccessControlList r9 = r18.getAccessControlList()
            z(r8, r9)
            goto L_0x00c6
        L_0x00b3:
            com.amazonaws.services.s3.model.CannedAccessControlList r9 = r18.getCannedAcl()
            if (r9 == 0) goto L_0x00c6
            com.amazonaws.services.s3.model.CannedAccessControlList r9 = r18.getCannedAcl()
            java.lang.String r9 = r9.toString()
            java.lang.String r12 = "x-amz-acl"
            r8.a(r12, r9)
        L_0x00c6:
            java.lang.String r9 = r18.getStorageClass()
            if (r9 == 0) goto L_0x00d5
            java.lang.String r9 = r18.getStorageClass()
            java.lang.String r12 = "x-amz-storage-class"
            r8.a(r12, r9)
        L_0x00d5:
            java.lang.String r9 = r18.getRedirectLocation()
            if (r9 == 0) goto L_0x00f0
            java.lang.String r9 = r18.getRedirectLocation()
            java.lang.String r12 = "x-amz-website-redirect-location"
            r8.a(r12, r9)
            if (r6 != 0) goto L_0x00f0
            r1.g0(r8)
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream
            byte[] r9 = new byte[r11]
            r6.<init>(r9)
        L_0x00f0:
            com.amazonaws.services.s3.model.ObjectTagging r9 = r18.getTagging()
            java.lang.String r9 = r1.k0(r9)
            java.lang.String r12 = "x-amz-tagging"
            B(r8, r12, r9)
            boolean r9 = r18.isRequesterPays()
            a0(r8, r9)
            com.amazonaws.services.s3.model.SSECustomerKey r9 = r18.getSSECustomerKey()
            b0(r8, r9)
            java.lang.String r9 = "Content-Length"
            java.lang.Object r12 = r5.getRawMetadataValue(r9)
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 != 0) goto L_0x0141
            boolean r11 = r6.markSupported()
            if (r11 != 0) goto L_0x0135
            com.amazonaws.logging.Log r11 = f15109s
            java.lang.String r12 = "No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors."
            r11.g(r12)
            java.io.ByteArrayInputStream r6 = r1.j0(r6)
            int r11 = r6.available()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r8.a(r9, r11)
            r8.r(r10)
            goto L_0x0158
        L_0x0135:
            long r10 = r1.E(r6)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r8.a(r9, r10)
            goto L_0x0158
        L_0x0141:
            long r13 = r12.longValue()
            r15 = 0
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x0158
            com.amazonaws.util.LengthCheckInputStream r10 = new com.amazonaws.util.LengthCheckInputStream
            r10.<init>(r6, r13, r11)
            java.lang.String r6 = r12.toString()
            r8.a(r9, r6)
            r6 = r10
        L_0x0158:
            if (r7 == 0) goto L_0x0169
            com.amazonaws.event.ProgressReportingInputStream r9 = new com.amazonaws.event.ProgressReportingInputStream
            r9.<init>(r6, r7)
            int r6 = r1.f15118q
            r9.k(r6)
            r6 = 2
            r1.M(r7, r6)
            r6 = r9
        L_0x0169:
            java.lang.String r9 = r5.getContentType()
            if (r9 != 0) goto L_0x0174
            java.lang.String r9 = "application/octet-stream"
            r5.setContentType(r9)
        L_0x0174:
            Z(r8, r5)
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r0 = r18.getSSEAwsKeyManagementParams()
            c0(r8, r0)
            r8.b(r6)
            com.amazonaws.services.s3.internal.S3MetadataResponseHandler r0 = new com.amazonaws.services.s3.internal.S3MetadataResponseHandler     // Catch:{ AmazonClientException -> 0x01fa }
            r0.<init>()     // Catch:{ AmazonClientException -> 0x01fa }
            java.lang.Object r0 = r1.U(r8, r0, r3, r4)     // Catch:{ AmazonClientException -> 0x01fa }
            r3 = r0
            com.amazonaws.services.s3.model.ObjectMetadata r3 = (com.amazonaws.services.s3.model.ObjectMetadata) r3     // Catch:{ AmazonClientException -> 0x01fa }
            r6.close()     // Catch:{ AbortedException -> 0x01ab, Exception -> 0x0191 }
            goto L_0x01ab
        L_0x0191:
            r0 = move-exception
            r4 = r0
            com.amazonaws.logging.Log r0 = f15109s
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.d(r2, r4)
        L_0x01ab:
            r0 = 4
            r1.M(r7, r0)
            com.amazonaws.services.s3.model.PutObjectResult r0 = new com.amazonaws.services.s3.model.PutObjectResult
            r0.<init>()
            java.lang.String r2 = r3.getVersionId()
            r0.setVersionId(r2)
            java.lang.String r2 = r3.getSSEAlgorithm()
            r0.setSSEAlgorithm(r2)
            java.lang.String r2 = r3.getSSECustomerAlgorithm()
            r0.setSSECustomerAlgorithm(r2)
            java.lang.String r2 = r3.getSSECustomerKeyMd5()
            r0.setSSECustomerKeyMd5(r2)
            java.util.Date r2 = r3.getExpirationTime()
            r0.setExpirationTime(r2)
            java.lang.String r2 = r3.getExpirationTimeRuleId()
            r0.setExpirationTimeRuleId(r2)
            java.lang.String r2 = r3.getETag()
            r0.setETag(r2)
            r0.b(r3)
            boolean r2 = r3.isRequesterCharged()
            r0.setRequesterCharged(r2)
            java.lang.String r2 = r3.getContentMD5()
            r0.a(r2)
            return r0
        L_0x01f7:
            r0 = move-exception
            r3 = r0
            goto L_0x0201
        L_0x01fa:
            r0 = move-exception
            r3 = 8
            r1.M(r7, r3)     // Catch:{ all -> 0x01f7 }
            throw r0     // Catch:{ all -> 0x01f7 }
        L_0x0201:
            r6.close()     // Catch:{ AbortedException -> 0x021f, Exception -> 0x0205 }
            goto L_0x021f
        L_0x0205:
            r0 = move-exception
            r4 = r0
            com.amazonaws.logging.Log r0 = f15109s
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = r4.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.d(r2, r4)
        L_0x021f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.AmazonS3Client.c(com.amazonaws.services.s3.model.PutObjectRequest):com.amazonaws.services.s3.model.PutObjectResult");
    }

    public CompleteMultipartUploadResult d(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.a(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
        String bucketName = completeMultipartUploadRequest.getBucketName();
        String key = completeMultipartUploadRequest.getKey();
        String uploadId = completeMultipartUploadRequest.getUploadId();
        ValidationUtils.a(bucketName, "The bucket name parameter must be specified when completing a multipart upload");
        ValidationUtils.a(key, "The key parameter must be specified when completing a multipart upload");
        ValidationUtils.a(uploadId, "The upload ID parameter must be specified when completing a multipart upload");
        ValidationUtils.a(completeMultipartUploadRequest.getPartETags(), "The part ETags parameter must be specified when completing a multipart upload");
        int i11 = 0;
        while (true) {
            Request H = H(bucketName, key, completeMultipartUploadRequest, HttpMethodName.POST);
            H.p("uploadId", uploadId);
            a0(H, completeMultipartUploadRequest.isRequesterPays());
            byte[] a11 = RequestXmlFactory.a(completeMultipartUploadRequest.getPartETags());
            H.a("Content-Type", "application/xml");
            H.a("Content-Length", String.valueOf(a11.length));
            H.b(new ByteArrayInputStream(a11));
            XmlResponsesSaxParser.CompleteMultipartUploadHandler completeMultipartUploadHandler = (XmlResponsesSaxParser.CompleteMultipartUploadHandler) U(H, new ResponseHeaderHandlerChain(new Unmarshallers.CompleteMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3VersionHeaderHandler(), new S3RequesterChargedHeaderHandler()), bucketName, key);
            if (completeMultipartUploadHandler.h() != null) {
                return completeMultipartUploadHandler.h();
            }
            int i12 = i11 + 1;
            if (h0(completeMultipartUploadRequest, completeMultipartUploadHandler.g(), i11)) {
                i11 = i12;
            } else {
                throw completeMultipartUploadHandler.g();
            }
        }
    }

    public PutObjectResult d0(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonClientException, AmazonServiceException {
        return c(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public InitiateMultipartUploadResult e(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.a(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.getKey(), "The key parameter must be specified when initiating a multipart upload");
        Request H = H(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), initiateMultipartUploadRequest, HttpMethodName.POST);
        H.p("uploads", (String) null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            H.a("x-amz-storage-class", initiateMultipartUploadRequest.getStorageClass().toString());
        }
        if (initiateMultipartUploadRequest.getRedirectLocation() != null) {
            H.a("x-amz-website-redirect-location", initiateMultipartUploadRequest.getRedirectLocation());
        }
        if (initiateMultipartUploadRequest.getAccessControlList() != null) {
            z(H, initiateMultipartUploadRequest.getAccessControlList());
        } else if (initiateMultipartUploadRequest.getCannedACL() != null) {
            H.a("x-amz-acl", initiateMultipartUploadRequest.getCannedACL().toString());
        }
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.objectMetadata;
        if (objectMetadata != null) {
            Z(H, objectMetadata);
        }
        B(H, "x-amz-tagging", k0(initiateMultipartUploadRequest.getTagging()));
        a0(H, initiateMultipartUploadRequest.isRequesterPays());
        b0(H, initiateMultipartUploadRequest.getSSECustomerKey());
        c0(H, initiateMultipartUploadRequest.getSSEAwsKeyManagementParams());
        g0(H);
        H.b(new ByteArrayInputStream(new byte[0]));
        return (InitiateMultipartUploadResult) U(H, new ResponseHeaderHandlerChain(new Unmarshallers.InitiateMultipartUploadResultUnmarshaller(), new ServerSideEncryptionHeaderHandler()), initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey());
    }

    public void e0(Request<?> request, String str, String str2, URI uri) {
        if (uri == null) {
            uri = this.f14760a;
        }
        if (i0(uri, str)) {
            Log log = f15109s;
            log.h("Using virtual style addressing. Endpoint = " + uri);
            request.u(F(uri, str));
            request.d(O(str2));
        } else {
            Log log2 = f15109s;
            log2.h("Using path style addressing. Endpoint = " + uri);
            request.u(uri);
            if (str != null) {
                request.d(P(str, str2));
            }
        }
        Log log3 = f15109s;
        log3.h("Key: " + str2 + "; Request: " + request);
    }

    public void f(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException, AmazonServiceException {
        ValidationUtils.a(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getKey(), "The key parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getUploadId(), "The upload ID parameter must be specified when aborting a multipart upload");
        String bucketName = abortMultipartUploadRequest.getBucketName();
        String key = abortMultipartUploadRequest.getKey();
        Request H = H(bucketName, key, abortMultipartUploadRequest, HttpMethodName.DELETE);
        H.p("uploadId", abortMultipartUploadRequest.getUploadId());
        a0(H, abortMultipartUploadRequest.isRequesterPays());
        U(H, this.f15114m, bucketName, key);
    }

    public final void f0(AWSS3V4Signer aWSS3V4Signer, String str) {
        aWSS3V4Signer.setServiceName(p());
        aWSS3V4Signer.setRegionName(str);
    }

    public final void g0(Request<?> request) {
        request.a("Content-Length", String.valueOf(0));
    }

    public final boolean h0(AmazonWebServiceRequest amazonWebServiceRequest, AmazonS3Exception amazonS3Exception, int i11) {
        RetryPolicy d11 = this.f14762c.d();
        if (d11 == null || d11.c() == null || d11 == PredefinedRetryPolicies.f15070a) {
            return false;
        }
        return this.f15119r.a(amazonWebServiceRequest, amazonS3Exception, i11);
    }

    public final boolean i0(URI uri, String str) {
        return !this.f15115n.d() && BucketNameUtils.isDNSBucketName(str) && !X(uri.getHost());
    }

    public final ByteArrayInputStream j0(InputStream inputStream) {
        int i11 = 262144;
        byte[] bArr = new byte[262144];
        int i12 = 0;
        while (i11 > 0) {
            try {
                int read = inputStream.read(bArr, i12, i11);
                if (read == -1) {
                    break;
                }
                i12 += read;
                i11 -= read;
            } catch (IOException e11) {
                throw new AmazonClientException("Failed to read from inputstream", e11);
            }
        }
        if (inputStream.read() == -1) {
            inputStream.close();
            return new ByteArrayInputStream(bArr, 0, i12);
        }
        throw new AmazonClientException("Input stream exceeds 256k buffer.");
    }

    public final String k0(ObjectTagging objectTagging) {
        if (objectTagging == null || objectTagging.getTagSet() == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Tag> it2 = objectTagging.getTagSet().iterator();
        while (it2.hasNext()) {
            Tag next = it2.next();
            sb2.append(S3HttpUtils.b(next.getKey(), false));
            sb2.append('=');
            sb2.append(S3HttpUtils.b(next.getValue(), false));
            if (it2.hasNext()) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb2.toString();
    }

    public void w(String str) {
        if (!str.endsWith("s3-accelerate.amazonaws.com")) {
            super.w(str);
            if (!str.endsWith("s3.amazonaws.com")) {
                this.f15117p = AwsHostNameUtils.a(this.f14760a.getHost(), "s3");
                return;
            }
            return;
        }
        throw new IllegalStateException("To enable accelerate mode, please use AmazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());");
    }

    public void x(com.amazonaws.regions.Region region) {
        super.x(region);
        this.f15117p = region.d();
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.f15113l = new S3ErrorResponseHandler();
        this.f15114m = new S3XmlResponseHandler<>((Unmarshaller) null);
        this.f15115n = new S3ClientOptions();
        this.f15118q = 1024;
        this.f15119r = new CompleteMultipartUploadRetryCondition();
        this.f15116o = aWSCredentialsProvider;
        S();
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration) {
        this(aWSCredentials, region, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), region, clientConfiguration, httpClient);
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, com.amazonaws.regions.Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.f15113l = new S3ErrorResponseHandler();
        this.f15114m = new S3XmlResponseHandler<>((Unmarshaller) null);
        this.f15115n = new S3ClientOptions();
        this.f15118q = 1024;
        this.f15119r = new CompleteMultipartUploadRetryCondition();
        this.f15116o = aWSCredentialsProvider;
        T(region, clientConfiguration);
    }
}
