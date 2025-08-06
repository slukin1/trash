package ui;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class b implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f60705a;

    public /* synthetic */ b(FragmentActivity fragmentActivity) {
        this.f60705a = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f60705a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.ae.us")));
    }
}
