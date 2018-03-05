package com.bearyinnovative.anndroid_sdk;

import com.bearyinnovative.common.base.BaseApplication;
import com.bearyinnovative.horcrux.utility.AppConfig;
import com.bearyinnovative.horcrux.utility.AppInitializationManager;

/**
 * Created by nickming on 05/03/2018.
 */

public class TestApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        AppConfig.INSTANCE.init(this);
        AppInitializationManager.AppInitializationParams initParams = new AppInitializationManager.AppInitializationParams(true, false,
                "", false, false,
                BuildConfig.DEBUG, false);
        AppInitializationManager.INSTANCE.init(this, initParams);
    }
}
