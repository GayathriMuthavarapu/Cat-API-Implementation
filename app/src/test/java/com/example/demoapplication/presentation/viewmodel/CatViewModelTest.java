package com.example.demoapplication.presentation.viewmodel;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.os.Looper;

import androidx.lifecycle.Observer;

import com.example.demoapplication.domain.usecase.CatUseCase;
import com.example.demoapplication.presentation.uimodel.CatModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public class CatViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatUseCase getCatsUseCase;

    private CatViewModel catViewModel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        catViewModel = new CatViewModel(getCatsUseCase);
    }

    @Test
    public void fetchCatImages_Success() {

        List<CatModel> mockCatModels = new ArrayList<>();
        when(getCatsUseCase.getCatList(10)).thenReturn(Single.just(mockCatModels));



        Observer<List<CatModel>> observer = mock(Observer.class);
        catViewModel.getCatListLiveData().observeForever(observer);


        catViewModel.loadCatList(10);


        verify(getCatsUseCase).getCatList(10);

        verify(observer).onChanged(mockCatModels);
    }

    @Test
    public void fetchCatImages_Error() {

        String errorMessage = "Failed to fetch cat list";
        when(getCatsUseCase.getCatList(10)).thenReturn(Single.error(new Throwable(errorMessage)));

        Observer<String> observer = mock(Observer.class);
        catViewModel.getErrorLiveData().observeForever(observer);

        catViewModel.loadCatList(10);
        verify(getCatsUseCase).getCatList(10);
        verify(observer).onChanged(errorMessage);
    }
}
