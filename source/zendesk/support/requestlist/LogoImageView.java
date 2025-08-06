package zendesk.support.requestlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

public class LogoImageView extends AppCompatImageView {
    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener((View.OnClickListener) null);
    }

    public void setVisibility(int i11) {
        super.setVisibility(8);
    }
}
