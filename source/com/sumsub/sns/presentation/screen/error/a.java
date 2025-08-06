package com.sumsub.sns.presentation.screen.error;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/a;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "", "onViewCreated", "<init>", "()V", "a", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final C0528a f39769a = new C0528a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final String f39770b = "SNSErrorDialog";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39771c = "arg_message";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39772d = "arg_button";

    /* renamed from: com.sumsub.sns.presentation.screen.error.a$a  reason: collision with other inner class name */
    public static final class C0528a {
        public /* synthetic */ C0528a(r rVar) {
            this();
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putCharSequence(a.f39771c, charSequence);
            bundle.putCharSequence(a.f39772d, charSequence2);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0528a() {
        }
    }

    public static final void a(a aVar, View view) {
        aVar.dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.sns_fragment_error_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.sns_text);
        CharSequence charSequence = null;
        if (textView != null) {
            Bundle arguments = getArguments();
            textView.setText(arguments != null ? arguments.getCharSequence(f39771c) : null);
        }
        Button button = (Button) view.findViewById(R.id.sns_button);
        if (button != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                charSequence = arguments2.getCharSequence(f39772d);
            }
            button.setText(charSequence);
            button.setOnClickListener(new c(this));
        }
    }
}
