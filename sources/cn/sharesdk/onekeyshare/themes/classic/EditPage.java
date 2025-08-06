package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.FriendListPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.FriendListPagePort;
import com.mob.MobSDK;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EditPage extends OnekeySharePage implements View.OnClickListener, TextWatcher, Runnable {
    public AsyncImageView aivThumb;
    public EditText etContent;
    private OnekeyShareThemeImpl impl;
    public LinearLayout llBottom;
    public LinearLayout llPage;
    public int maxBodyHeight;
    public Platform platform;
    public RelativeLayout rlThumb;
    public RelativeLayout rlTitle;

    /* renamed from: sp  reason: collision with root package name */
    public Platform.ShareParams f13727sp;
    public ScrollView svContent;
    public Bitmap thumb;
    public TextView tvAt;
    public TextView tvCancel;
    public TextView tvShare;
    public TextView tvTextCouter;
    public XView xvRemove;

    public EditPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.impl = onekeyShareThemeImpl;
    }

    private void cancelAndFinish() {
        ShareSDK.logDemoEvent(5, this.platform);
        finish();
    }

    private String getJoinSelectedUser(HashMap<String, Object> hashMap) {
        if (hashMap == null || !hashMap.containsKey("selected")) {
            return null;
        }
        ArrayList arrayList = (ArrayList) hashMap.get("selected");
        if ("FacebookMessenger".equals(((Platform) hashMap.get("platform")).getName())) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sb2.append('@');
            sb2.append((String) it2.next());
            sb2.append(' ');
        }
        return sb2.toString();
    }

    private void removeThumb() {
        this.f13727sp.setImageArray((String[]) null);
        this.f13727sp.setImageData((Bitmap) null);
        this.f13727sp.setImagePath((String) null);
        this.f13727sp.setImageUrl((String) null);
    }

    private void shareAndFinish() {
        int stringRes = ResHelper.getStringRes(this.activity, "ssdk_oks_sharing");
        if (stringRes > 0) {
            Toast.makeText(this.activity, stringRes, 0).show();
        }
        if (isDisableSSO()) {
            this.platform.SSOSetting(true);
        }
        this.platform.setPlatformActionListener(getCallback());
        this.platform.share(this.f13727sp);
        this.impl.callback = null;
        finish();
    }

    private void showFriendList() {
        FriendListPage friendListPage;
        if (this.activity.getResources().getConfiguration().orientation == 1) {
            friendListPage = new FriendListPagePort(this.impl);
        } else {
            friendListPage = new FriendListPageLand(this.impl);
        }
        friendListPage.setPlatform(this.platform);
        friendListPage.showForResult(MobSDK.getContext(), (Intent) null, this);
    }

    private void showThumb(Bitmap bitmap) {
        PicViewerPage picViewerPage = new PicViewerPage(this.impl);
        picViewerPage.setImageBitmap(bitmap);
        picViewerPage.show(this.activity, (Intent) null);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void hideSoftInput(View view) {
        Object systemService = this.activity.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public boolean isShowAtUserLayout(String str) {
        return "SinaWeibo".equals(str) || "TencentWeibo".equals(str) || "Facebook".equals(str) || "Twitter".equals(str);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.equals(this.tvCancel)) {
            cancelAndFinish();
        } else if (view.equals(this.tvShare)) {
            this.f13727sp.setText(this.etContent.getText().toString().trim());
            shareAndFinish();
        } else if (view.equals(this.aivThumb)) {
            showThumb(this.thumb);
        } else if (view.equals(this.xvRemove)) {
            this.maxBodyHeight = 0;
            this.rlThumb.setVisibility(8);
            this.llPage.measure(0, 0);
            onTextChanged(this.etContent.getText(), 0, 0, 0);
            removeThumb();
        } else if (view.equals(this.tvAt)) {
            showFriendList();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(-789517));
    }

    public void onPause() {
        hideSoftInput(getContentView());
        super.onPause();
    }

    public void onResult(HashMap<String, Object> hashMap) {
        String joinSelectedUser = getJoinSelectedUser(hashMap);
        if (!TextUtils.isEmpty(joinSelectedUser)) {
            this.etContent.append(joinSelectedUser);
        }
    }

    public int onSetTheme(int i11, boolean z11) {
        if (isDialogMode()) {
            this.activity.requestWindowFeature(1);
            if (Build.VERSION.SDK_INT < 11) {
                return 16973835;
            }
            try {
                ReflectHelper.invokeInstanceMethod(this.activity, "setFinishOnTouchOutside", Boolean.FALSE);
                return 16973835;
            } catch (Throwable unused) {
                return 16973835;
            }
        } else {
            this.activity.getWindow().setSoftInputMode(37);
            return super.onSetTheme(i11, z11);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.tvTextCouter.setText(String.valueOf(charSequence.length()));
        if (this.maxBodyHeight == 0) {
            this.maxBodyHeight = (this.llPage.getHeight() - this.rlTitle.getHeight()) - this.llBottom.getHeight();
        }
        if (this.maxBodyHeight > 0) {
            this.svContent.post(this);
        }
    }

    public void run() {
        int height = this.svContent.getChildAt(0).getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ResHelper.forceCast(this.svContent.getLayoutParams());
        int i11 = this.maxBodyHeight;
        if (height > i11 && layoutParams.height != i11) {
            layoutParams.height = i11;
            this.svContent.setLayoutParams(layoutParams);
        } else if (height < i11 && layoutParams.height == i11) {
            layoutParams.height = -2;
            this.svContent.setLayoutParams(layoutParams);
        }
    }

    public void setPlatform(Platform platform2) {
        this.platform = platform2;
    }

    public void setShareParams(Platform.ShareParams shareParams) {
        this.f13727sp = shareParams;
    }
}
