package com.example.demoapplication.common;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class AndroidApplication extends Application implements ViewModelStoreOwner {
    private ViewModelProvider appViewModelProvider;
    private static AndroidApplication instance;
    private ViewModelStore viewModelStore = new ViewModelStore();

    @Override
    public void onCreate() {
        super.onCreate();
        appViewModelProvider = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(this));
        instance = this;
        // Perform any global initialization here
    }
    public ViewModelProvider getAppViewModelProvider() {
        return appViewModelProvider;
    }

    public static AndroidApplication getInstance() {
        return instance;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }
}
