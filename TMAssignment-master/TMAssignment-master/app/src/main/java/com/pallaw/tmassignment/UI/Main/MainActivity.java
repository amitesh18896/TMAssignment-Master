package com.pallaw.tmassignment.UI.Main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pallaw.tmassignment.R;
import com.pallaw.tmassignment.UI.Gallary.GalleryFragment;
import com.pallaw.tmassignment.Util.ActivityUtils;


public class MainActivity extends AppCompatActivity {

    private GalleryFragment galleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null == galleryFragment) {
            galleryFragment = GalleryFragment.newInstance();
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), galleryFragment, R.id.mainContentFrame);
    }

}
