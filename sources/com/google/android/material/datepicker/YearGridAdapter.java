package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar2) {
        this.materialCalendar = materialCalendar2;
    }

    private View.OnClickListener createYearClickListener(final int i11) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                YearGridAdapter.this.materialCalendar.setCurrentMonth(YearGridAdapter.this.materialCalendar.getCalendarConstraints().clamp(Month.create(i11, YearGridAdapter.this.materialCalendar.getCurrentMonth().month)));
                YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    public int getPositionForYear(int i11) {
        return i11 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    public int getYearForPosition(int i11) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + i11;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i11) {
        int yearForPosition = getYearForPosition(i11);
        String string = viewHolder.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(yearForPosition)}));
        viewHolder.textView.setContentDescription(String.format(string, new Object[]{Integer.valueOf(yearForPosition)}));
        CalendarStyle calendarStyle = this.materialCalendar.getCalendarStyle();
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == yearForPosition ? calendarStyle.todayYear : calendarStyle.year;
        for (Long longValue : this.materialCalendar.getDateSelector().getSelectedDays()) {
            todayCalendar.setTimeInMillis(longValue.longValue());
            if (todayCalendar.get(1) == yearForPosition) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder.textView);
        viewHolder.textView.setOnClickListener(createYearClickListener(yearForPosition));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
