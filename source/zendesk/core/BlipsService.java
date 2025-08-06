package zendesk.core;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface BlipsService {
    @GET("/embeddable_blip")
    Call<Void> send(@Query("data") String str);
}
