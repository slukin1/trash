package v6;

import android.app.Activity;
import android.webkit.WebView;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import java.util.List;
import java.util.Map;
import u6.g;

public interface u extends g {
    void clearNeedLoginAction();

    Activity getActivity();

    String getAvailableLocationY();

    String getDisplayHeight();

    String getDisplayWidth();

    String getNavigatorHeight();

    String getTopHeight();

    WebView getWebView();

    boolean isSupportBlankLabel();

    void setAlertDialogInfo(AlertInfo alertInfo);

    void setHBWebViewLifecycleCallback(t tVar);

    void setNeedLoginAction(boolean z11, boolean z12, JsMessage jsMessage);

    void setProcess(int i11);

    void setTitleText(CharSequence charSequence);

    void setWebViewRefreshType(String str);

    void showActionBarShare(boolean z11);

    void showTopIcon(List<Map<String, String>> list);
}
