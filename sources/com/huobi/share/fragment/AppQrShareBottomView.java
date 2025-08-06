package com.huobi.share.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.zxing.WriterException;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.domain.DomainSwitcher;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.x;
import pro.huobi.R;

public class AppQrShareBottomView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f80867b;

    public AppQrShareBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private String getDownloadAppUrl() {
        String str;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            if (x.d()) {
                str = DomainSwitcher.R();
            } else {
                str = DomainSwitcher.T();
            }
        } else if (x.d()) {
            str = DomainSwitcher.S();
        } else {
            str = DomainSwitcher.U();
        }
        if (TextUtils.isEmpty(str)) {
            return AppLanguageHelper.getInstance().isChineseLanguage() ? "https://m.huobi.br.com/zh-cn/download/" : "https://m.huobi.br.com/en-us/download/";
        }
        return str;
    }

    public final void a(Context context) {
        FrameLayout.inflate(context, R.layout.app_share_img_bottom_layout, this);
        this.f80867b = (ImageView) findViewById(R.id.share_img_qrcode);
        try {
            this.f80867b.setImageBitmap(ImageUtils.c(getDownloadAppUrl(), (int) getResources().getDimension(R.dimen.dimen_180)));
        } catch (WriterException e11) {
            e11.printStackTrace();
        }
    }

    public AppQrShareBottomView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
