package on;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import org.json.JSONObject;

public final /* synthetic */ class a implements GraphRequest.GraphJSONObjectCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f58877a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessToken f58878b;

    public /* synthetic */ a(b bVar, AccessToken accessToken) {
        this.f58877a = bVar;
        this.f58878b = accessToken;
    }

    public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
        this.f58877a.b(this.f58878b, jSONObject, graphResponse);
    }
}
