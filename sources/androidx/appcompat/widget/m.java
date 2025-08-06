package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.h;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public TextView f4622a;

    /* renamed from: b  reason: collision with root package name */
    public TextClassifier f4623b;

    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    public m(TextView textView) {
        this.f4622a = (TextView) h.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f4623b;
        return textClassifier == null ? a.a(this.f4622a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f4623b = textClassifier;
    }
}
