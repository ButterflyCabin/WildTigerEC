package com.yehu.wildtigerec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.test.yehu.tiger.app.Tiger;
import com.test.yehu.tigerec.FontTigerModule;

/**
 * Created by WildTiger on 2017/8/31.
 */

public class TigerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Tiger.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new IoniconsModule())
                .withIcon(new FontTigerModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
