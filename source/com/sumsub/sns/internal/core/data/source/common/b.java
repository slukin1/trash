package com.sumsub.sns.internal.core.data.source.common;

import com.sumsub.sns.core.data.model.SNSInitConfig;
import com.sumsub.sns.internal.core.data.model.remote.i;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import com.sumsub.sns.internal.core.data.model.remote.response.f;
import com.sumsub.sns.internal.ff.model.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.serialization.json.JsonObject;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\tJ\u001d\u0010\r\u001a\u00020\u000b2\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\tJ'\u0010\r\u001a\u00020\u00112\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0012J\u001d\u0010\u0003\u001a\u00020\u00112\b\b\u0001\u0010\u0010\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\tJ\u001f\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0013H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0004J)\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0001\u0010\u0010\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\tJ3\u0010\r\u001a\u00020\u00162\b\b\u0001\u0010\u0010\u001a\u00020\u00052\u0014\b\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0018H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0004J)\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u00132\b\b\u0001\u0010\u001c\u001a\u00020\u001bH§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u001eø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/common/b;", "", "Lcom/sumsub/sns/internal/core/data/model/remote/response/f;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "actionId", "Lkotlinx/serialization/json/JsonObject;", "d", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "applicantId", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$d;", "e", "a", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "conf", "language", "Lcom/sumsub/sns/internal/core/data/model/remote/i;", "(Lcom/sumsub/sns/core/data/model/SNSInitConfig;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "c", "translations", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/model/b;", "", "Lcom/sumsub/sns/internal/core/data/model/d;", "Lcom/sumsub/sns/internal/ff/model/a;", "requestedFlags", "Lcom/sumsub/sns/internal/ff/model/b;", "(Lcom/sumsub/sns/internal/ff/model/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public interface b {
    @POST("resources/sdkIntegrations/msdkInit")
    Object a(@Body SNSInitConfig sNSInitConfig, @Query("lang") String str, c<? super i> cVar);

    @POST("/resources/featureFlags/msdk")
    Object a(@Body a aVar, c<? super Map<String, com.sumsub.sns.internal.ff.model.b>> cVar);

    @POST("/resources/msdk/i18n")
    Object a(@Query("lang") String str, @Body Map<String, String> map, c<? super Unit> cVar);

    @GET("resources/applicantActions/{actionId}/one")
    Object a(@Path("actionId") String str, c<? super d.c.C0351d> cVar);

    @GET("resources/sdkIntegrations/-/clientIntegrationSettings")
    Object a(c<? super Map<String, ? extends Object>> cVar);

    @POST("resources/sdkIntegrations/msdkReinit")
    Object b(@Query("lang") String str, c<? super i> cVar);

    @GET("/resources/sdk/applicant/requiredIdDocsStatus")
    Object b(c<? super f> cVar);

    @GET("/resources/msdk/i18n")
    Object c(@Query("lang") String str, c<? super Map<String, ? extends Object>> cVar);

    @GET("/resources/sdkIntegrations/agreement")
    Object c(c<? super com.sumsub.sns.internal.core.data.model.b> cVar);

    @GET("/resources/applicantActions/{actionId}/requiredIdDocsStatus")
    Object d(@Path("actionId") String str, c<? super JsonObject> cVar);

    @GET("/resources/sdkIntegrations/agreements")
    Object d(c<? super List<com.sumsub.sns.internal.core.data.model.d>> cVar);

    @GET("resources/applicants/{applicantId}/one")
    Object e(@Path("applicantId") String str, c<? super d.c.C0351d> cVar);
}
