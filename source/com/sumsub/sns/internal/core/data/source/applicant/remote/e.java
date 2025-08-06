package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.sumsub.sns.internal.core.data.model.b;
import com.sumsub.sns.internal.core.data.model.remote.d;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.c;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0005\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000eJ)\u0010\u0005\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0012J3\u0010\u0005\u001a\u00020\u00132\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\n2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0014J'\u0010\u0005\u001a\u00020\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0017J'\u0010\r\u001a\u00020\u00162\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0017J1\u0010\u0005\u001a\u00020\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u001bJ1\u0010\r\u001a\u00020\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u001d2\b\b\u0001\u0010\u001c\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0006J\u001d\u0010\r\u001a\u00020\u001d2\b\b\u0001\u0010\u0010\u001a\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010 J\u001d\u0010\u0005\u001a\u00020\u001d2\b\b\u0001\u0010\u0010\u001a\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010 J\u001d\u0010\u0005\u001a\u00020\u001d2\b\b\u0001\u0010\u0010\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\"J'\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020#H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010$J\u001d\u0010&\u001a\u00020%2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0006J3\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010'2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010(J\u001d\u0010)\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b)\u0010\u0006J'\u0010\u0005\u001a\u00020+2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010,J1\u0010\u0005\u001a\u00020+2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020.H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010/J\u001d\u00101\u001a\u0002002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0006J\u0013\u0010\u0005\u001a\u000202H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u00103J'\u0010\u0005\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00105\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u00106J'\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u00105\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0004\b\r\u00106ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u00067À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/e;", "", "", "applicantId", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/g;", "a", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "actionId", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$d;", "f", "Lokhttp3/RequestBody;", "applicantAndLanguage", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d;", "b", "(Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/model/remote/d;", "data", "unsetFields", "(Lcom/sumsub/sns/internal/core/data/model/remote/d;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;", "(Ljava/lang/String;Lokhttp3/RequestBody;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/a0;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b0;", "(Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/a0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "requestCode", "verificationId", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "questionnaireId", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/w;", "g", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/y;", "(Lcom/sumsub/sns/internal/core/data/source/applicant/remote/y;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/u;", "(Lcom/sumsub/sns/internal/core/data/source/applicant/remote/u;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/model/remote/b;", "(Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/h0;", "c", "", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/e0;", "(Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "confirmationId", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/a;", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/d0;", "d", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/f;", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/sumsub/sns/internal/core/data/model/b;", "agreement", "(Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public interface e {
    @PATCH("/resources/applicants")
    Object a(@Body d dVar, @Query("unsetFields") String str, c<? super d.c.C0351d> cVar);

    @POST("/resources/sdk/applicant/questionnaires")
    Object a(@Body u uVar, c<? super w> cVar);

    @PATCH("/resources/applicantActions")
    Object a(@Body y yVar, c<? super w> cVar);

    @POST("resources/applicants/{applicantId}/agreement")
    Object a(@Path("applicantId") String str, @Body b bVar, c<? super d.c.C0351d> cVar);

    @POST("/resources/applicants/{applicantId}/info/mrtd")
    Object a(@Path("applicantId") String str, @Body com.sumsub.sns.internal.core.data.model.remote.b bVar, c<? super g> cVar);

    @POST("resources/applicants/{applicantId}/identifierConfirmation/-/request")
    Object a(@Path("applicantId") String str, @Body a0 a0Var, c<? super b0> cVar);

    @POST("resources/applicants/{applicantId}/ekyc/submit")
    Object a(@Path("applicantId") String str, @Body b bVar, c<? super e0> cVar);

    @POST("resources/applicants/{applicantId}/ekyc/confirm/{confirmationId}")
    Object a(@Path("applicantId") String str, @Path("confirmationId") String str2, @Body a aVar, c<? super e0> cVar);

    @POST("resources/applicants/{applicantId}/identifierConfirmation/{verificationId}/verify")
    Object a(@Path("applicantId") String str, @Path("verificationId") String str2, @Query("code") String str3, c<? super b0> cVar);

    @POST("/resources/applicants/{applicantId}/status/pending")
    Object a(@Path("applicantId") String str, c<? super g> cVar);

    @PATCH("/resources/applicants/{applicantId}/fixedInfo")
    Object a(@Path("applicantId") String str, @Body RequestBody requestBody, @Query("unsetFields") String str2, c<? super d.c.C0350c> cVar);

    @POST("/resources/applicants/{applicantId}/info/location")
    Object a(@Path("applicantId") String str, @Body RequestBody requestBody, c<? super Map<String, ? extends Object>> cVar);

    @GET("resources/videoIdent/-/availableLanguages")
    Object a(c<? super f> cVar);

    @PATCH("resources/applicantActions")
    Object a(@Body RequestBody requestBody, c<? super com.sumsub.sns.internal.core.data.model.remote.response.d> cVar);

    @PATCH("/resources/applicants")
    Object b(@Body y yVar, c<? super w> cVar);

    @POST("resources/applicantActions/{actionId}/agreement")
    Object b(@Path("actionId") String str, @Body b bVar, c<? super d.c.C0351d> cVar);

    @POST("resources/applicantActions/{actionId}/identifierConfirmation/-/request")
    Object b(@Path("actionId") String str, @Body a0 a0Var, c<? super b0> cVar);

    @POST("resources/applicantActions/{actionId}/identifierConfirmation/{verificationId}/verify")
    Object b(@Path("actionId") String str, @Path("verificationId") String str2, @Query("code") String str3, c<? super b0> cVar);

    @POST("/resources/videoIdent/applicant/{applicantId}/confirm")
    Object b(@Path("applicantId") String str, c<? super g> cVar);

    @PATCH("resources/applicants")
    Object b(@Body RequestBody requestBody, c<? super com.sumsub.sns.internal.core.data.model.remote.response.d> cVar);

    @POST("/resources/videoIdent/applicant/{applicantId}/apply")
    Object c(@Path("applicantId") String str, c<? super h0> cVar);

    @POST("resources/applicants/{applicantId}/ekyc/skip")
    Object d(@Path("applicantId") String str, c<? super d0> cVar);

    @GET("resources/applicants/{applicantId}/one")
    Object e(@Path("applicantId") String str, c<? super d.c.C0351d> cVar);

    @POST("/resources/applicantActions/{actionId}/review/status/pending")
    Object f(@Path("actionId") String str, c<? super d.c.C0351d> cVar);

    @GET("/resources/questionnaires/-;id={questionnaireId}/one")
    Object g(@Path("questionnaireId") String str, c<? super w> cVar);
}
