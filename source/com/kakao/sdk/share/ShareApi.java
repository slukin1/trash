package com.kakao.sdk.share;

import com.kakao.sdk.share.model.ImageUploadResult;
import com.kakao.sdk.share.model.ValidationResult;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0016\b\u0003\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H'JA\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00062\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0003\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H'¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/kakao/sdk/share/ShareApi;", "", "scrapImage", "Lretrofit2/Call;", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "imageUrl", "", "secureResource", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lretrofit2/Call;", "uploadImage", "image", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/MultipartBody$Part;Ljava/lang/Boolean;)Lretrofit2/Call;", "validateCustom", "Lcom/kakao/sdk/share/model/ValidationResult;", "templateId", "", "templateArgs", "", "validateDefault", "templateObject", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "validateScrap", "url", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lretrofit2/Call;", "share_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ShareApi {
    @FormUrlEncoded
    @POST("/v2/api/talk/message/image/scrap")
    Call<ImageUploadResult> scrapImage(@Field("image_url") String str, @Field("secure_resource") Boolean bool);

    @POST("/v2/api/talk/message/image/upload")
    @Multipart
    Call<ImageUploadResult> uploadImage(@Part MultipartBody.Part part, @Part("secure_resource") Boolean bool);

    @GET("/v2/api/kakaolink/talk/template/validate?link_ver=4.0")
    Call<ValidationResult> validateCustom(@Query("template_id") long j11, @Query("template_args") Map<String, String> map);

    @GET("/v2/api/kakaolink/talk/template/default?link_ver=4.0")
    Call<ValidationResult> validateDefault(@Query("template_object") DefaultTemplate defaultTemplate);

    @GET("/v2/api/kakaolink/talk/template/scrap?link_ver=4.0")
    Call<ValidationResult> validateScrap(@Query("request_url") String str, @Query("template_id") Long l11, @Query("template_args") Map<String, String> map);
}
