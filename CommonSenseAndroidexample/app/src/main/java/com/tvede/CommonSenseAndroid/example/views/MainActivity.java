package com.tvede.CommonSenseAndroid.example.views;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tvede.CommonSenseAndroid.activity.SimpleActivityDataBinding;
import com.tvede.CommonSenseAndroid.example.R;
import com.tvede.CommonSenseAndroid.example.databinding.MainActivityBinding;

import static com.tvede.CommonSenseAndroid.helpers.NullHelper.isAnyNull;

/**
 * Created by kasper on 21-08-2016.
 */

public class MainActivity extends SimpleActivityDataBinding<MainActivityBinding> {

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void onInitializationFailed() {
        Toast.makeText(this, "Bad app, please reinstall", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityReady(@NonNull MainActivityBinding dataBinding) {
        if (isAnyNull(dataBinding.title)) { //validate state
            onInitializationFailed();
            return; //bad state
        }
        dataBinding.title.setText("asd2");
        //good state.

        //TODO eventually subscribe or whatever here. // //TODO here load data.


    }

}
