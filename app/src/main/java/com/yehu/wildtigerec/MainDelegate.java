package com.yehu.wildtigerec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.test.yehu.tiger.delegates.TigerDelegate;

/**
 * Created by WildTiger on 2017/9/1.
 */

public class MainDelegate extends TigerDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rotView) {

    }
}
