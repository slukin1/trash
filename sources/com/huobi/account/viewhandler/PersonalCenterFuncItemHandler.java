package com.huobi.account.viewhandler;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.account.entity.PersonalCenterFuncItem;
import pro.huobi.R;
import s9.c;

public class PersonalCenterFuncItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, PersonalCenterFuncItem personalCenterFuncItem, ViewGroup viewGroup) {
        Resources resources = cVar.itemView.getContext().getResources();
        ImageView imageView = (ImageView) cVar.itemView.findViewById(R.id.icon);
        TextView textView = (TextView) cVar.itemView.findViewById(R.id.title);
        TextView textView2 = (TextView) cVar.itemView.findViewById(R.id.subtitle);
        RelativeLayout relativeLayout = (RelativeLayout) cVar.itemView.findViewById(R.id.personal_center_func);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) cVar.itemView.findViewById(R.id.lottie_animation_icon);
        if (!personalCenterFuncItem.isIconJson()) {
            imageView.setVisibility(0);
            lottieAnimationView.setVisibility(8);
            imageView.setImageResource(personalCenterFuncItem.getIconRes());
            lottieAnimationView.cancelAnimation();
        } else if (personalCenterFuncItem.getIconJsonRes() != -1) {
            imageView.setVisibility(4);
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation(personalCenterFuncItem.getIconJsonRes());
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        }
        int paddingLeft = relativeLayout.getPaddingLeft();
        int paddingTop = relativeLayout.getPaddingTop();
        int paddingRight = relativeLayout.getPaddingRight();
        int paddingBottom = relativeLayout.getPaddingBottom();
        if (personalCenterFuncItem.getFuncItemBg() != -1) {
            relativeLayout.setBackgroundResource(personalCenterFuncItem.getFuncItemBg());
        } else {
            relativeLayout.setBackgroundResource(R.drawable.personal_center_func_item_bg);
        }
        relativeLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setText(resources.getString(personalCenterFuncItem.getTitleRes()));
        String string = resources.getString(personalCenterFuncItem.getSubtitleSuffixRes());
        if (!TextUtils.isEmpty(personalCenterFuncItem.getSubtitleText())) {
            textView2.setText(personalCenterFuncItem.getSubtitleText());
        } else if (TextUtils.isEmpty(personalCenterFuncItem.getSubtitlePrefix())) {
            textView2.setText(string);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(personalCenterFuncItem.getSubtitlePrefix());
            int length = spannableStringBuilder.length();
            if (!"--".equals(personalCenterFuncItem.getSubtitlePrefix())) {
                spannableStringBuilder.append(" ");
                spannableStringBuilder.append(string);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(PixelUtils.a(14.0f)), 0, length, 17);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.baseColorPrimaryText)), 0, length, 17);
            textView2.setText(spannableStringBuilder);
        }
        cVar.itemView.setOnClickListener(personalCenterFuncItem.getOnClickListener());
    }

    public int getResId() {
        return R.layout.personal_center_func_item_layout;
    }
}
