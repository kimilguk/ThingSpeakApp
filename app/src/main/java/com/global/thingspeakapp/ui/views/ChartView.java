package com.global.thingspeakapp.ui.views;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.global.thingspeakapp.R;
import com.global.thingspeakapp.activities.FullscreenActivity;

/**
 * Created by ville on 11.04.2021.
 */
public class ChartView extends LinearLayout implements Toolbar.OnMenuItemClickListener {

    Toolbar mToolbar;
    LineChart mLineChart;
    private int fieldId = 0;
    private int channelId = 0;

    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_chart, this);

        mToolbar = (Toolbar) findViewById(R.id.chart_toolbar);
        mLineChart = (LineChart) findViewById(R.id.chart);

        mToolbar.inflateMenu(R.menu.chart);
        mToolbar.setOnMenuItemClickListener(this);

        mLineChart.getLegend().setEnabled(false);

        mLineChart.getXAxis().setDrawLabels(false);
        mLineChart.getAxisLeft().setDrawLabels(true);
        mLineChart.getAxisRight().setDrawLabels(false);
        mLineChart.setDescription("");
        mLineChart.setPinchZoom(false);
        mLineChart.setDoubleTapToZoomEnabled(false);
    }

    public void setTitle(String title){
        if(mToolbar != null) mToolbar.setTitle(title);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.action_chart_fullscreen){
            Intent i = new Intent(getContext(), FullscreenActivity.class);
            i.putExtra("channel_id", channelId);
            i.putExtra("field_id", fieldId);
            getContext().startActivity(i);
        }
        return true;
    }

    public void setData(LineData data) {
        mLineChart.setData(data);
        data.getDataSetByIndex(0).setDrawCircles(false);
        data.getDataSetByIndex(0).setColor(getResources().getColor(R.color.main_blue_dark));

        mLineChart.animateX(1000);
        //mLineChart.invalidate();
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
