package com.pallaw.tmassignment.UI.Gallary;

import com.pallaw.tmassignment.Data.DataManager;
import com.pallaw.tmassignment.Data.Models.TMResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pallaw Pathak on 2019-06-14. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class GalleryPresenter implements GalleryContract.Presenter {
    private GalleryContract.View view;
    private DataManager dataManager;

    public GalleryPresenter(GalleryContract.View view, DataManager dataManager) {
        this.view = view;
        this.dataManager = dataManager;
    }

    @Override
    public void onDownloadData() {
        Observable<TMResponse> tmResponse = dataManager.getApiService().getTMResponse();
        tmResponse.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TMResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TMResponse tmResponse) {
                        view.showData(tmResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
