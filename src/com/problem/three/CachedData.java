package com.problem.three;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
 
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void processCachedData(String key, String value){
        rwl.readLock().lock();
        // 缓存有效
        if(map.containsKey(key)){
            // 处理数据
        }else{
            try{
                rwl.readLock().unlock(); // 释放读锁
                rwl.writeLock().lock();  // 获取写锁

                try{
                    // 再次判断有效性
                    if(!map.containsKey(key)){
                        // 更新缓存对象
                        map.put(key, value);
                    }
                    // 锁降级
                    rwl.readLock().lock();
                }finally {
                    rwl.writeLock().unlock();
                }
            }finally {
                rwl.readLock().unlock();
            }
        }
    }
}
