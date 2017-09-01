package com.test.yehu.tiger.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * Created by WildTiger on 2017/8/31.
 */

public class Configurator {
    private static final WeakHashMap<String, Object> TIGER_CONFIGS = new WeakHashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        TIGER_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public WeakHashMap<String, Object> getTigerConfigs() {
        return TIGER_CONFIGS;
    }

    public static final Configurator getInstance() {
        return Holder.INSTANCE;
    }

    // 通过静态内部内的发方式来实现单例
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        initIcons();
        TIGER_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        TIGER_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private final void checkConfigurations() {
        final boolean isReady = (boolean) TIGER_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            new RuntimeException("Configuration is not ready, call configure.");
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfigurations();
        return (T) TIGER_CONFIGS.get(key);
    }

    private static void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer iconifyInitializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                iconifyInitializer.with(ICONS.get(i));
            }
        }
    }
    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

}
