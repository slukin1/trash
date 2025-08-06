package com.sumsub.sns.core.data.listener;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.sumsub.sns.R;
import com.sumsub.sns.core.a;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@a
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSDefaultIconHandler;", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "()V", "onResolveIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "key", "", "stepIcon", "", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public class SNSDefaultIconHandler implements SNSIconHandler {
    private final int stepIcon(DocumentType documentType) {
        if (documentType.g()) {
            return R.drawable.sns_ic_step_identity;
        }
        if (documentType.h()) {
            return R.drawable.sns_ic_step_poa;
        }
        if (documentType.k()) {
            return R.drawable.sns_ic_step_selfie;
        }
        if (documentType.d()) {
            return R.drawable.sns_ic_step_applicant_data;
        }
        if (documentType.j()) {
            return R.drawable.sns_ic_step_questionnaire;
        }
        if (documentType.i()) {
            return R.drawable.sns_ic_step_phone;
        }
        if (documentType.f()) {
            return R.drawable.sns_ic_step_email;
        }
        if (documentType.e()) {
            return R.drawable.sns_ic_step_ekyc;
        }
        if (documentType.m()) {
            return R.drawable.sns_ic_step_video_ident;
        }
        return R.drawable.sns_ic_step_identity;
    }

    public Drawable onResolveIcon(Context context, String str) {
        int i11;
        Drawable f11;
        Drawable a11 = com.sumsub.sns.core.presentation.helper.a.f31095a.a(str);
        if (a11 != null) {
            return a11;
        }
        boolean z11 = true;
        if (x.b(str, "default/videoident")) {
            i11 = R.drawable.sns_ic_videoident_intro_face;
        } else if (x.b(str, "default/do_idCard")) {
            i11 = R.drawable.sns_ic_intro_do;
        } else if (x.b(str, "default/do_passport")) {
            i11 = R.drawable.sns_ic_intro_do_passport;
        } else if (x.b(str, "default/dont_idCard")) {
            i11 = R.drawable.sns_ic_intro_dont;
        } else if (x.b(str, "default/dont_passport")) {
            i11 = R.drawable.sns_ic_intro_dont_passport;
        } else if (x.b(str, "default/facescan")) {
            i11 = R.drawable.sns_ic_intro_liveness;
        } else if (x.b(str, "default/do_idCard_backSide")) {
            i11 = R.drawable.sns_ic_intro_do_back;
        } else if (x.b(str, "default/dont_idCard_backSide")) {
            i11 = R.drawable.sns_ic_intro_dont_back;
        } else if (x.b(str, "IdentityType/PASSPORT")) {
            i11 = R.drawable.sns_ic_iddoc_passport;
        } else if (x.b(str, "IdentityType/DRIVERS")) {
            i11 = R.drawable.sns_ic_iddoc_driving_license;
        } else if (x.b(str, "IdentityType/RESIDENCE_PERMIT")) {
            i11 = R.drawable.sns_ic_iddoc_residence_permit;
        } else if (x.b(str, SNSIconHandler.SNSResultIcons.SUCCESS.getImageName())) {
            i11 = R.drawable.sns_ic_success;
        } else if (x.b(str, SNSIconHandler.SNSResultIcons.FAILURE.getImageName())) {
            i11 = R.drawable.sns_ic_fatal;
        } else if (x.b(str, SNSIconHandler.SNSResultIcons.SUBMITTED.getImageName())) {
            i11 = R.drawable.sns_ic_submitted;
        } else if (x.b(str, SNSIconHandler.SNSResultIcons.WARNING.getImageName())) {
            i11 = R.drawable.sns_ic_warning;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.WARNING_OUTLINE.getImageName())) {
            i11 = R.drawable.sns_ic_warning_outline;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.CLOSE.getImageName())) {
            i11 = R.drawable.sns_ic_close;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.BACK.getImageName())) {
            i11 = R.drawable.sns_ic_back;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.DISCLOSURE.getImageName())) {
            i11 = R.drawable.sns_ic_step_open;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.TORCH_ON.getImageName())) {
            i11 = R.drawable.sns_ic_flash_on;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.TORCH_OFF.getImageName())) {
            i11 = R.drawable.sns_ic_flash_off;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.GALLERY.getImageName())) {
            i11 = R.drawable.sns_ic_gallery;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.MAIL.getImageName())) {
            i11 = R.drawable.sns_ic_email;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.NFC.getImageName())) {
            i11 = R.drawable.sns_ic_nfc_logo;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.MRTD_PASSPORT.getImageName())) {
            i11 = R.drawable.sns_ic_mrtd_passport;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.MRTD_IDCARD.getImageName())) {
            i11 = R.drawable.sns_ic_mrtd_id_card;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.MRTD_PHONE.getImageName())) {
            i11 = R.drawable.sns_ic_mrtd_hand;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.BIN.getImageName())) {
            i11 = R.drawable.sns_ic_delete;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.CALENDAR.getImageName())) {
            i11 = R.drawable.sns_ic_calendar;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ATTACHMENT.getImageName())) {
            i11 = R.drawable.sns_ic_attachment;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.IMAGE.getImageName())) {
            i11 = R.drawable.sns_ic_image;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.SEARCH.getImageName())) {
            i11 = R.drawable.sns_ic_search;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.NOTIFY.getImageName())) {
            i11 = R.drawable.sns_ic_notify;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.TAKE_PHOTO.getImageName())) {
            i11 = R.drawable.sns_ic_capture;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.LOCATION_ON.getImageName())) {
            i11 = R.drawable.sns_ic_location_on;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.LOCATION_OFF.getImageName())) {
            i11 = R.drawable.sns_ic_location_off;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.COUNTRY_OTHER.getImageName())) {
            i11 = R.drawable.sns_ic_flag_placeholder;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.PICTURE_AGREEMENT.getImageName())) {
            i11 = R.drawable.sns_ic_earth;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_ID.getImageName())) {
            i11 = R.drawable.sns_ic_iddoc_id_card;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_HOME.getImageName())) {
            i11 = R.drawable.sns_ic_iddoc_residence_permit;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_PERSONS.getImageName())) {
            i11 = R.drawable.sns_ic_persons;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_LIGHT.getImageName())) {
            i11 = R.drawable.sns_ic_light;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_CAMERA.getImageName())) {
            i11 = R.drawable.sns_ic_camera;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ICON_WIFI.getImageName())) {
            i11 = R.drawable.sns_ic_wifi;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.WARNING.getImageName())) {
            i11 = R.drawable.sns_ic_warning_triangle;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ROTATE_CW.getImageName())) {
            i11 = R.drawable.sns_ic_rotate_cw;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.ROTATE_CCW.getImageName())) {
            i11 = R.drawable.sns_ic_rotate_ccw;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.FLIP.getImageName())) {
            i11 = R.drawable.sns_flip;
        } else if (x.b(str, SNSIconHandler.SNSCommonIcons.SUCCESS_CHECK.getImageName())) {
            i11 = R.drawable.sns_ic_success_check;
        } else if (x.b(str, SNSIconHandler.SNSEidIcons.PIN.getImageName())) {
            i11 = R.drawable.sns_ic_pin;
        } else if (x.b(str, SNSIconHandler.SNSEidIcons.DONE.getImageName())) {
            i11 = R.drawable.sns_ic_success;
        } else if (x.b(str, SNSIconHandler.SNSEidIcons.ID_CARD.getImageName())) {
            i11 = R.drawable.sns_ic_id_hand;
        } else if (x.b(str, SNSIconHandler.SNSEidIcons.NFC_SCAN.getImageName())) {
            i11 = R.drawable.sns_ic_nfc_id;
        } else if (x.b(str, SNSIconHandler.SNSEidIcons.CAN.getImageName())) {
            i11 = R.drawable.sns_ic_eid_can;
        } else if (StringsKt__StringsJVMKt.M(str, "IdentityType/", false, 2, (Object) null)) {
            i11 = R.drawable.sns_ic_iddoc_id_card;
        } else if (StringsKt__StringsJVMKt.M(str, "Flag/", false, 2, (Object) null)) {
            Integer valueOf = Integer.valueOf(i.a(context, "sns_ic_flag_" + StringsKt__StringsKt.W0(str, "/", (String) null, 2, (Object) null)));
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            i11 = valueOf != null ? valueOf.intValue() : R.drawable.sns_ic_flag_placeholder;
        } else {
            i11 = StringsKt__StringsJVMKt.M(str, "DocType/", false, 2, (Object) null) ? stepIcon(new DocumentType(StringsKt__StringsKt.W0(str, "/", (String) null, 2, (Object) null))) : -1;
        }
        Integer valueOf2 = Integer.valueOf(i11);
        if (valueOf2.intValue() == -1) {
            z11 = false;
        }
        if (!z11) {
            valueOf2 = null;
        }
        if (valueOf2 == null || (f11 = ResourcesCompat.f(context.getResources(), valueOf2.intValue(), context.getTheme())) == null) {
            return null;
        }
        u0.a.a(f11, context.getTheme());
        return f11;
    }
}
