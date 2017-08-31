package com.test.yehu.tiger.app;

import java.util.WeakHashMap;

/**
 * Created by ButterflyCabin on 2017/8/31.
 */

public class Configurator {
    private static final WeakHashMap<String, Object> TIGER_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        TIGER_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public WeakHashMap<String, Object> getTigerConfigs() {
        return TIGER_CONFIGS;
    }

    public final static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    // 通过静态内部内的发方式来实现单例
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
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

}
