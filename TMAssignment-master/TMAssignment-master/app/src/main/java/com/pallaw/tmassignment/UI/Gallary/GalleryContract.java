package com.pallaw.tmassignment.UI.Gallary;

import com.pallaw.tmassignment.Data.Models.TMResponse;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface GalleryContract {

    interface View {

        void showData(TMResponse tmResponse);

        void showError(Throwable e);
    }

    interface Presenter {
        void onDownloadData();
    }
}
