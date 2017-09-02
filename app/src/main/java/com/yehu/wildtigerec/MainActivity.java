package com.yehu.wildtigerec;

import com.test.yehu.tiger.activities.PoxyActivity;
import com.test.yehu.tiger.delegates.TigerDelegate;

public class MainActivity extends PoxyActivity {

    @Override
    public TigerDelegate setRootDelegate() {
        return new MainDelegate();
    }
}
