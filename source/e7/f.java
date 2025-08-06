package e7;

import androidx.lifecycle.MutableLiveData;

public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f70055c = new f();

    /* renamed from: a  reason: collision with root package name */
    public final String f70056a = "EdgeEngine#";

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<String> f70057b = new MutableLiveData<>();

    public static f a() {
        return f70055c;
    }

    public String b() {
        return this.f70057b.getValue();
    }

    public void c(String str) {
        this.f70057b.setValue(str);
    }
}
