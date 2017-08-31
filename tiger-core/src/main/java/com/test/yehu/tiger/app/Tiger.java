package com.test.yehu.tiger.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by ButterflyCabin on 2017/8/31.
 */

public final class Tiger {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String ,Object> getConfigurations(){
        return Configurator.getInstance().getTigerConfigs();
    }
}
