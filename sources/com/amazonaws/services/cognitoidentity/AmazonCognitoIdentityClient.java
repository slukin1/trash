package com.amazonaws.services.cognitoidentity;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.services.cognitoidentity.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeveloperUserAlreadyRegisteredExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ExternalServiceExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidIdentityPoolConfigurationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.NotAuthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceConflictExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import java.util.ArrayList;
import java.util.List;

public class AmazonCognitoIdentityClient extends AmazonWebServiceClient {

    /* renamed from: l  reason: collision with root package name */
    public AWSCredentialsProvider f15084l;

    /* renamed from: m  reason: collision with root package name */
    public List<JsonErrorUnmarshaller> f15085m;

    @Deprecated
    public AmazonCognitoIdentityClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public static ClientConfiguration z(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    public final void A() {
        ArrayList arrayList = new ArrayList();
        this.f15085m = arrayList;
        arrayList.add(new ConcurrentModificationExceptionUnmarshaller());
        this.f15085m.add(new DeveloperUserAlreadyRegisteredExceptionUnmarshaller());
        this.f15085m.add(new ExternalServiceExceptionUnmarshaller());
        this.f15085m.add(new InternalErrorExceptionUnmarshaller());
        this.f15085m.add(new InvalidIdentityPoolConfigurationExceptionUnmarshaller());
        this.f15085m.add(new InvalidParameterExceptionUnmarshaller());
        this.f15085m.add(new LimitExceededExceptionUnmarshaller());
        this.f15085m.add(new NotAuthorizedExceptionUnmarshaller());
        this.f15085m.add(new ResourceConflictExceptionUnmarshaller());
        this.f15085m.add(new ResourceNotFoundExceptionUnmarshaller());
        this.f15085m.add(new TooManyRequestsExceptionUnmarshaller());
        this.f15085m.add(new JsonErrorUnmarshaller());
        w("cognito-identity.us-east-1.amazonaws.com");
        this.f14768i = "cognito-identity";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f14764e.addAll(handlerChainFactory.c("/com/amazonaws/services/cognitoidentity/request.handlers"));
        this.f14764e.addAll(handlerChainFactory.b("/com/amazonaws/services/cognitoidentity/request.handler2s"));
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(z(clientConfiguration), httpClient);
        this.f15084l = aWSCredentialsProvider;
        A();
    }
}
