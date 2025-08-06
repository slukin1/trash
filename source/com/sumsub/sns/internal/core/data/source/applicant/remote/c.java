package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.model.remote.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J[\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000eJ'\u0010\r\u001a\u00020\u00142\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0015J'\u0010\u0011\u001a\u00020\u00142\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0015ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/c;", "", "", "applicantId", "Lokhttp3/MultipartBody$Part;", "image", "Lokhttp3/RequestBody;", "meta", "", "headers", "idDocSetType", "Lretrofit2/Response;", "Lcom/sumsub/sns/internal/core/data/model/remote/k;", "a", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "actionId", "Lcom/sumsub/sns/internal/core/data/model/remote/l;", "b", "", "imageId", "", "(Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public interface c {
    @DELETE("/resources/applicants/{applicantId}/resources/{imageId}")
    Object a(@Path("applicantId") String str, @Path("imageId") int i11, kotlin.coroutines.c<? super Unit> cVar);

    @POST("/resources/applicants/{applicantId}/info/idDoc")
    @Multipart
    Object a(@Path("applicantId") String str, @Part MultipartBody.Part part, @Part("metadata") RequestBody requestBody, @HeaderMap Map<String, String> map, @Query("idDocSetType") String str2, kotlin.coroutines.c<? super Response<k>> cVar);

    @DELETE("/resources/applicantActions/{actionId}/images/{imageId}")
    Object b(@Path("actionId") String str, @Path("imageId") int i11, kotlin.coroutines.c<? super Unit> cVar);

    @POST("/resources/applicantActions/{actionId}/images")
    @Multipart
    Object b(@Path("actionId") String str, @Part MultipartBody.Part part, @Part("metadata") RequestBody requestBody, @HeaderMap Map<String, String> map, @Query("idDocSetType") String str2, kotlin.coroutines.c<? super Response<l>> cVar);
}
