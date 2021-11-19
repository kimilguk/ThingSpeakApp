package com.global.thingspeakapp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.global.thingspeakapp.R;
import com.global.thingspeakapp.model.ChannelFeed;
import com.global.thingspeakapp.network.ApiClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ville on 26.09.2021.
 */
public class FullscreenActivity extends AppCompatActivity {

    LineChart mChart;
    Toolbar mToolbar;

    private int fieldId;
    private int channelId;

    private ChannelFeed mChannelFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mChart = (LineChart) findViewById(R.id.chart);

        setSupportActionBar(mToolbar);

        channelId = getIntent().getIntExtra("channel_id", 0);
        fieldId = getIntent().getIntExtra("field_id", 0);

        if(channelId <= 0 || fieldId <= 0){
            Toast.makeText(this, "Invalid id", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            ApiClient.getInstance().getChannelFieldFeed(channelId, fieldId, null, null, new Callback<ChannelFeed>() {
                @Override
                public void success(ChannelFeed channelFeed, Response response) {
                    mChannelFeed = channelFeed;
                    mToolbar.setTitle(mChannelFeed.getChannel().getField(fieldId));
                    setupChart();
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(FullscreenActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    private void setupChart(){
        if (mChannelFeed.getChannel().getField(fieldId) != null && !mChannelFeed.getChannel().getField(fieldId).equals("")) {
            LineData data = mChannelFeed.getLineData(fieldId);

            // Check if there is data to show
            if(data != null && data.getDataSets().size() > 0){
                mChart.setData(data);
            }
            mChart.invalidate();
        }
    }

}
