package com.test.yehu.tigerec;

import com.joanzapata.iconify.Icon;

/**
 * Created by ButterflyCabin on 2017/9/1.
 */

public enum FontTigerIcons implements Icon {
    scanner('\ue628'),
    ali_pay('\ue66b');

    char character;

    FontTigerIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
