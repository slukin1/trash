package com.amazonaws.services.securitytoken;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.services.securitytoken.model.transform.ExpiredTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPCommunicationErrorExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPRejectedClaimExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidAuthorizationMessageExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidIdentityTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.PackedPolicyTooLargeExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.RegionDisabledExceptionUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class AWSSecurityTokenServiceClient extends AmazonWebServiceClient {

    /* renamed from: l  reason: collision with root package name */
    public AWSCredentialsProvider f15501l;

    /* renamed from: m  reason: collision with root package name */
    public final List<Unmarshaller<AmazonServiceException, Node>> f15502m;

    @Deprecated
    public AWSSecurityTokenServiceClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public static ClientConfiguration z(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    public final void A() {
        this.f15502m.add(new ExpiredTokenExceptionUnmarshaller());
        this.f15502m.add(new IDPCommunicationErrorExceptionUnmarshaller());
        this.f15502m.add(new IDPRejectedClaimExceptionUnmarshaller());
        this.f15502m.add(new InvalidAuthorizationMessageExceptionUnmarshaller());
        this.f15502m.add(new InvalidIdentityTokenExceptionUnmarshaller());
        this.f15502m.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.f15502m.add(new PackedPolicyTooLargeExceptionUnmarshaller());
        this.f15502m.add(new RegionDisabledExceptionUnmarshaller());
        this.f15502m.add(new StandardErrorUnmarshaller());
        w("sts.amazonaws.com");
        this.f14768i = "sts";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f14764e.addAll(handlerChainFactory.c("/com/amazonaws/services/securitytoken/request.handlers"));
        this.f14764e.addAll(handlerChainFactory.b("/com/amazonaws/services/securitytoken/request.handler2s"));
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(z(clientConfiguration), httpClient);
        this.f15502m = new ArrayList();
        this.f15501l = aWSCredentialsProvider;
        A();
    }
}
