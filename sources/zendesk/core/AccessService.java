package zendesk.core;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface AccessService {
    @POST("/access/sdk/anonymous")
    Call<AuthenticationResponse> getAuthTokenForAnonymous(@Body AuthenticationRequestWrapper authenticationRequestWrapper);

    @POST("/access/sdk/jwt")
    Call<AuthenticationResponse> getAuthTokenForJwt(@Body AuthenticationRequestWrapper authenticationRequestWrapper);
}
