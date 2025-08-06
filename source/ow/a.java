package ow;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.jumio.defaultui.JumioActivity;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JumioActivity f52990a;

    public /* synthetic */ a(JumioActivity jumioActivity) {
        this.f52990a = jumioActivity;
    }

    public final void onActivityResult(Object obj) {
        JumioActivity.launcher$lambda$3(this.f52990a, (ActivityResult) obj);
    }
}
