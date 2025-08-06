package tw;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.LinkObject;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f26231a;

    /* renamed from: b  reason: collision with root package name */
    public String f26232b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f26233c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f26234d;

    /* renamed from: e  reason: collision with root package name */
    public String f26235e;

    /* renamed from: f  reason: collision with root package name */
    public LinkObject f26236f;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f26237a;

        /* renamed from: b  reason: collision with root package name */
        public String f26238b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f26239c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f26240d;

        /* renamed from: e  reason: collision with root package name */
        public String f26241e;

        /* renamed from: f  reason: collision with root package name */
        public LinkObject f26242f;

        public b(String str, String str2, LinkObject linkObject) {
            this.f26237a = str;
            this.f26238b = str2;
            this.f26242f = linkObject;
        }

        public d g() {
            return new d(this);
        }

        public b h(String str) {
            this.f26241e = str;
            return this;
        }
    }

    public static b a(String str, String str2, LinkObject linkObject) {
        return new b(str, str2, linkObject);
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.f26231a);
        jSONObject.put(MessengerShareContentUtility.IMAGE_URL, this.f26232b);
        jSONObject.put(TUIChatConstants.IMAGE_WIDTH, this.f26233c);
        jSONObject.put(TUIChatConstants.IMAGE_HEIGHT, this.f26234d);
        jSONObject.put("description", this.f26235e);
        jSONObject.put("link", this.f26236f.b());
        return jSONObject;
    }

    public d(b bVar) {
        this.f26231a = bVar.f26237a;
        this.f26232b = bVar.f26238b;
        this.f26233c = bVar.f26239c;
        this.f26234d = bVar.f26240d;
        this.f26235e = bVar.f26241e;
        this.f26236f = bVar.f26242f;
    }
}
