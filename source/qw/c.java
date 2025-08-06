package qw;

import com.kakao.common.IConfiguration;
import com.kakao.util.exception.KakaoException;
import org.json.JSONObject;

public class c implements IConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public String f25617a;

    /* renamed from: b  reason: collision with root package name */
    public String f25618b;

    /* renamed from: c  reason: collision with root package name */
    public String f25619c;

    /* renamed from: d  reason: collision with root package name */
    public String f25620d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f25621e;

    public c(String str, String str2, String str3, String str4, JSONObject jSONObject) throws KakaoException {
        if (str == null || str.length() == 0) {
            throw new KakaoException(KakaoException.ErrorType.MISS_CONFIGURATION, "Android key hash is null.");
        }
        this.f25617a = str;
        this.f25618b = str2;
        this.f25619c = str3;
        this.f25620d = str4;
        this.f25621e = jSONObject;
    }

    public String a() {
        return this.f25619c;
    }

    public String b() {
        return this.f25618b;
    }

    public JSONObject c() {
        return this.f25621e;
    }
}
