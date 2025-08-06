package com.amazonaws.services.kms;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.services.kms.model.transform.AlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotActiveExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotRelatedExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.ConflictExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreHasCMKsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNameInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DependencyTimeoutExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DisabledExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DryRunOperationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.ExpiredImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectKeyExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectKeyMaterialExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectTrustAnchorExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidAliasNameExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidArnExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidCiphertextExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantIdExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidKeyUsageExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidMarkerExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInternalExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidMacExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidSignatureExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KeyUnavailableExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.NotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.TagExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksKeyAlreadyInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksKeyInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksKeyNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyInvalidResponseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyUriEndpointInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyUriInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyUriUnreachableExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyVpcEndpointServiceInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyVpcEndpointServiceInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.XksProxyVpcEndpointServiceNotFoundExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import java.util.ArrayList;
import java.util.List;

public class AWSKMSClient extends AmazonWebServiceClient {

    /* renamed from: l  reason: collision with root package name */
    public AWSCredentialsProvider f15094l;

    /* renamed from: m  reason: collision with root package name */
    public List<JsonErrorUnmarshaller> f15095m;

    @Deprecated
    public AWSKMSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public static ClientConfiguration z(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    public final void A() {
        ArrayList arrayList = new ArrayList();
        this.f15095m = arrayList;
        arrayList.add(new AlreadyExistsExceptionUnmarshaller());
        this.f15095m.add(new CloudHsmClusterInUseExceptionUnmarshaller());
        this.f15095m.add(new CloudHsmClusterInvalidConfigurationExceptionUnmarshaller());
        this.f15095m.add(new CloudHsmClusterNotActiveExceptionUnmarshaller());
        this.f15095m.add(new CloudHsmClusterNotFoundExceptionUnmarshaller());
        this.f15095m.add(new CloudHsmClusterNotRelatedExceptionUnmarshaller());
        this.f15095m.add(new ConflictExceptionUnmarshaller());
        this.f15095m.add(new CustomKeyStoreHasCMKsExceptionUnmarshaller());
        this.f15095m.add(new CustomKeyStoreInvalidStateExceptionUnmarshaller());
        this.f15095m.add(new CustomKeyStoreNameInUseExceptionUnmarshaller());
        this.f15095m.add(new CustomKeyStoreNotFoundExceptionUnmarshaller());
        this.f15095m.add(new DependencyTimeoutExceptionUnmarshaller());
        this.f15095m.add(new DisabledExceptionUnmarshaller());
        this.f15095m.add(new DryRunOperationExceptionUnmarshaller());
        this.f15095m.add(new ExpiredImportTokenExceptionUnmarshaller());
        this.f15095m.add(new IncorrectKeyExceptionUnmarshaller());
        this.f15095m.add(new IncorrectKeyMaterialExceptionUnmarshaller());
        this.f15095m.add(new IncorrectTrustAnchorExceptionUnmarshaller());
        this.f15095m.add(new InvalidAliasNameExceptionUnmarshaller());
        this.f15095m.add(new InvalidArnExceptionUnmarshaller());
        this.f15095m.add(new InvalidCiphertextExceptionUnmarshaller());
        this.f15095m.add(new InvalidGrantIdExceptionUnmarshaller());
        this.f15095m.add(new InvalidGrantTokenExceptionUnmarshaller());
        this.f15095m.add(new InvalidImportTokenExceptionUnmarshaller());
        this.f15095m.add(new InvalidKeyUsageExceptionUnmarshaller());
        this.f15095m.add(new InvalidMarkerExceptionUnmarshaller());
        this.f15095m.add(new KMSInternalExceptionUnmarshaller());
        this.f15095m.add(new KMSInvalidMacExceptionUnmarshaller());
        this.f15095m.add(new KMSInvalidSignatureExceptionUnmarshaller());
        this.f15095m.add(new KMSInvalidStateExceptionUnmarshaller());
        this.f15095m.add(new KeyUnavailableExceptionUnmarshaller());
        this.f15095m.add(new LimitExceededExceptionUnmarshaller());
        this.f15095m.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.f15095m.add(new NotFoundExceptionUnmarshaller());
        this.f15095m.add(new TagExceptionUnmarshaller());
        this.f15095m.add(new UnsupportedOperationExceptionUnmarshaller());
        this.f15095m.add(new XksKeyAlreadyInUseExceptionUnmarshaller());
        this.f15095m.add(new XksKeyInvalidConfigurationExceptionUnmarshaller());
        this.f15095m.add(new XksKeyNotFoundExceptionUnmarshaller());
        this.f15095m.add(new XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller());
        this.f15095m.add(new XksProxyInvalidConfigurationExceptionUnmarshaller());
        this.f15095m.add(new XksProxyInvalidResponseExceptionUnmarshaller());
        this.f15095m.add(new XksProxyUriEndpointInUseExceptionUnmarshaller());
        this.f15095m.add(new XksProxyUriInUseExceptionUnmarshaller());
        this.f15095m.add(new XksProxyUriUnreachableExceptionUnmarshaller());
        this.f15095m.add(new XksProxyVpcEndpointServiceInUseExceptionUnmarshaller());
        this.f15095m.add(new XksProxyVpcEndpointServiceInvalidConfigurationExceptionUnmarshaller());
        this.f15095m.add(new XksProxyVpcEndpointServiceNotFoundExceptionUnmarshaller());
        this.f15095m.add(new JsonErrorUnmarshaller());
        w("kms.us-east-1.amazonaws.com");
        this.f14768i = "kms";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f14764e.addAll(handlerChainFactory.c("/com/amazonaws/services/kms/request.handlers"));
        this.f14764e.addAll(handlerChainFactory.b("/com/amazonaws/services/kms/request.handler2s"));
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(z(clientConfiguration), httpClient);
        this.f15094l = aWSCredentialsProvider;
        A();
    }
}
