package up;

import android.text.TextUtils;
import okhttp3.HttpUrl;
import s3.a;

public class b extends a {

    /* renamed from: i  reason: collision with root package name */
    public String f84906i;

    public b(String str) {
        super(str);
        this.f84906i = str;
    }

    public String a() {
        HttpUrl parse;
        if (TextUtils.isEmpty(this.f84906i) || (parse = HttpUrl.parse(this.f84906i)) == null || TextUtils.isEmpty(parse.encodedPath())) {
            return super.a();
        }
        return parse.encodedPath();
    }
}
