package com.imobile3.groovypayments.ui.chart;

import java.util.List;
import java.util.ArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.imobile3.groovypayments.data.CartRepository;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;

public class PieChartViewModel extends ViewModel {

    private CartRepository mCartRepository;

    PieChartViewModel(CartRepository repository) {
        mCartRepository = repository;
    }

    LiveData<List<DataEntry>> getProductList() {
        final MutableLiveData<List<DataEntry>> observable =
                new MutableLiveData<>(new ArrayList<>());

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Spaghetti", 850));
        data.add(new ValueDataEntry("Ice Coffee", 535));
        data.add(new ValueDataEntry("Mango Graham", 675));
        data.add(new ValueDataEntry("Coffee Float", 750));
        data.add(new ValueDataEntry("Bicol Express", 450));
        data.add(new ValueDataEntry("Baby Back Ribs", 890));
        data.add(new ValueDataEntry("Ala King Rice Bowl", 400));
        observable.setValue(data);

        return observable;
    }
}
