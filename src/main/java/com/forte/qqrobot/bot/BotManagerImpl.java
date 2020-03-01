package com.forte.qqrobot.bot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * {@link BotManager}的基础实现类，使用Map储存数据。
 * @author <a href="https://github.com/ForteScarlet"> ForteScarlet </a>
 */
public class BotManagerImpl implements BotManager {

    /** 数据储存用的Map */
    private Map<String, BotInfo> botMap;

    public BotManagerImpl(){
        this.botMap = new ConcurrentHashMap<>(2);
    }

    public BotManagerImpl(int initialCapacity){
        this.botMap = new ConcurrentHashMap<>(initialCapacity);
    }

    public BotManagerImpl(Supplier<Map<String, BotInfo>> botMapGetter){
        this.botMap = botMapGetter.get();
    }


    /**
     * 通过bot的code获取一个Bot的信息
     *
     * @param botCode 账号
     * @return bot信息
     */
    @Override
    public BotInfo getBot(String botCode) {
        return botMap.get(botCode);
    }

    /**
     * 注册一个botInfo。在实现的时候需要注意线程安全问题，概率较小，但是不是没有可能
     *
     * @param info bot信息，作为key的code信息将会从其中获取。info中的各项参数不可为null
     * @return 是否注册成功
     */
    @Override
    public boolean registerBot(BotInfo info) {
        String key = info.getBotCode();
        // 在注册时候锁住map对象
        synchronized (botMap) {
            BotInfo botInfo = botMap.get(key);
            if(botInfo == null){
                botMap.put(key, info);
                return true;
            }else{
                // 已经存在, 不放入
                return false;
            }
        }

    }
}
