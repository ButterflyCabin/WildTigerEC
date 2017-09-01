package com.test.yehu.tiger.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.test.yehu.tiger.R;
import com.test.yehu.tiger.delegates.TigerDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by WildTiger on 2017/9/1.
 */

public abstract class PoxyActivity extends SupportActivity {
    public abstract TigerDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout contentFrameLayout = new ContentFrameLayout(this);
        contentFrameLayout.setId(R.id.delegate_container);
        setContentView(contentFrameLayout);
        if (null == savedInstanceState) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
