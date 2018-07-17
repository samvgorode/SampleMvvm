package com.example.mvvm.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvvm.models.AppModel;
import com.example.mvvm.utils.ApplicationsDataManager;

import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<AppModel>> appModels = new MutableLiveData<>();

    @Inject
    public MainActivityViewModel(ApplicationsDataManager applicationsDataManager) {
        appModels.setValue(applicationsDataManager.getLaunchAppList());
    }

    public MutableLiveData<List<AppModel>> getAppModels() {
        return appModels;
    }
}
