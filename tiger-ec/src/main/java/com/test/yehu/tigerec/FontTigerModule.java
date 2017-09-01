package com.test.yehu.tigerec;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by ButterflyCabin on 2017/9/1.
 */

public class FontTigerModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return FontTigerIcons.values();
    }
}
