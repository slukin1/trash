package w6;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import i6.k;
import java.util.List;
import v6.u;
import x6.g;

public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public g f69074a;

    /* renamed from: b  reason: collision with root package name */
    public ValueCallback<Uri> f69075b;

    /* renamed from: c  reason: collision with root package name */
    public String f69076c;

    /* renamed from: d  reason: collision with root package name */
    public String f69077d;

    /* renamed from: e  reason: collision with root package name */
    public u f69078e;

    /* renamed from: f  reason: collision with root package name */
    public PermissionRequest f69079f;

    public b(u uVar) {
        this.f69078e = uVar;
    }

    public static /* synthetic */ void c(ValueCallback valueCallback, Uri uri) {
        Uri[] uriArr = uri != null ? new Uri[]{uri} : null;
        if (valueCallback != null) {
            try {
                valueCallback.onReceiveValue(uriArr);
            } catch (Exception unused) {
            }
        }
    }

    public PermissionRequest b() {
        return this.f69079f;
    }

    public void d(int i11, int i12, Intent intent) {
        g gVar;
        if (i11 == 4 && (gVar = this.f69074a) != null) {
            gVar.h(i12, intent);
        }
    }

    public void e(int i11, List<String> list) {
        ValueCallback<Uri> valueCallback = this.f69075b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.f69075b = null;
        }
        if (EasyPermissions.somePermissionPermanentlyDenied(this.f69078e.getActivity(), list)) {
            Resources resources = this.f69078e.getActivity().getResources();
            new AppSettingsDialog.Builder(this.f69078e.getActivity(), resources.getString(R$string.permission_camera_write_external_storage_apply)).setTitle(resources.getString(R$string.permission_apply)).setPositiveButton(resources.getString(R$string.go_to_settings)).setNegativeButton(resources.getString(R$string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    @SuppressLint({"CheckResult"})
    public void f(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.f69075b = valueCallback;
        this.f69076c = str;
        this.f69077d = str2;
        g();
    }

    public void g() {
        String[] strArr = {"android.permission.CAMERA", Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this.f69078e.getActivity(), strArr)) {
            h();
        } else {
            EasyPermissions.requestPermissions(this.f69078e.getActivity(), 123, strArr);
        }
    }

    public void h() {
        g gVar = new g(this.f69078e.getActivity());
        this.f69074a = gVar;
        gVar.i(this.f69075b, this.f69076c, this.f69077d);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(consoleMessage.messageLevel());
        sb2.append(" ");
        sb2.append(consoleMessage.message());
        if (TextUtils.isEmpty(consoleMessage.sourceId())) {
            str = "";
        } else {
            str = ", source='" + consoleMessage.sourceId() + '\'' + "(" + consoleMessage.lineNumber() + ")";
        }
        sb2.append(str);
        k.p("chrome", sb2.toString(), false);
        return false;
    }

    public boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
        if (!this.f69078e.isSupportBlankLabel()) {
            return super.onCreateWindow(webView, z11, z12, message);
        }
        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webView.getHitTestResult().getExtra())));
        return false;
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (ContextCompat.checkSelfPermission(this.f69078e.getWebView().getContext(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this.f69078e.getActivity(), new String[]{"android.permission.CAMERA"}, TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND);
            this.f69079f = permissionRequest;
            return;
        }
        permissionRequest.grant(permissionRequest.getResources());
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        permissionRequest.deny();
    }

    public void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        this.f69078e.setProcess(i11);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        this.f69078e.setTitleText(str);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < acceptTypes.length; i11++) {
            if (!(acceptTypes[i11] == null || acceptTypes[i11].length() == 0)) {
                sb2.append(acceptTypes[i11]);
                sb2.append(";");
            }
        }
        if (sb2.length() == 0) {
            sb2 = new StringBuilder(SelectMimeType.SYSTEM_IMAGE);
        }
        f(new a(valueCallback), sb2.toString(), "filesystem");
        return true;
    }
}
