package org.coderead.cache;

/**
 * 缓存解决方案一:
 *  集中式实现
 */
public class MyCache {
    public void 设置缓存(Object key,Object value){
        保存数据(key,value);
    }
    private void 保存数据(Object key, Object value) {
        //1. 内存
        //2. 硬盘
        //3. 第三方应用集群
    }
    public Object 读取缓存(Object key){
            return new Object();
    }
    public void 清空缓存(){
    }
    public int 获取缓存数量(){
        return 100;
    }
    private void 溢出淘汰(){
        //1. LRU 淘汰最少使用的数据
        //2. FIFO 淘汰最旧的数据
    }
    private void 清理过期数据(){
    }
    private void 命中率统计(){
    }

}
