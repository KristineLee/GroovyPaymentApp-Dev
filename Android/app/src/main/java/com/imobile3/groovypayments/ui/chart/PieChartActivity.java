package com.imobile3.groovypayments.ui.chart;

import java.util.List;
import android.os.Bundle;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.anychart.charts.Pie;
import com.anychart.chart.common.dataentry.DataEntry;
import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.ui.BaseActivity;
import com.imobile3.groovypayments.ui.dialog.ProgressDialog;
import androidx.lifecycle.ViewModelProviders;

public class PieChartActivity extends BaseActivity {

    private ProgressDialog mProgressDialog;
    private PieChartViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);
        setUpMainNavBar();
        mProgressDialog = new ProgressDialog(this);

        mViewModel.getProductList().observe(this, PieChartActivity.this::setPieChart);
    }

    // TODO: Update list parameterized type to chart library data wrapper
    private void setPieChart(List<DataEntry> data) {
        // TODO: Populate the chart view
        mProgressDialog.setMessage(
                getResources().getString(
                        R.string.daily_report_progress_message
                )
        );
        mProgressDialog.show();

        AnyChartView productChart = findViewById(R.id.productChart);
        Pie pie = AnyChart.pie();
        pie.data(data);
        pie.labels().fontSize(12).fontDecoration("underline").position();
        pie.legend().itemsLayout(LegendLayout.HORIZONTAL_EXPANDABLE).align(Align.CENTER);

        // dismiss progress dialog
        productChart.setOnRenderedListener(() -> mProgressDialog.dismiss());
        productChart.setChart(pie);
    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this, new PieChartViewModelFactory())
                .get(PieChartViewModel.class);
    }

    @Override
    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showLogo();
        mMainNavBar.showSubtitle(getString(R.string.daily_report_subtitle));
    }
}

