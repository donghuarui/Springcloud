package com.dhr.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/25 16:11
 * @Description: 每个服务访问5次， 换笑一个服务 （3个0）
 * total = 0， 默认=0， 如果=5， 我们指向下一个服务节点
 * index = 0， 默认=0，  如果total=5， index+1
 */
public class RuiRandomRule extends AbstractLoadBalancerRule {
    private int total = 0; //被调用的次数
    private int currentIndex = 0;//当前是谁在提供服务

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers(); //获得活着的服务
                List<Server> allList = lb.getAllServers();//获得全部的服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);//生成区间随机数
//                server = (Server) upList.get(index);//从活着的服务中随机获取一个
                //======================================================
                if (total < 5) {
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total = 0;
                    currentIndex++;
                    if (currentIndex > upList.size() - 1) {
                        currentIndex = 0;
                    }
                    server = upList.get(currentIndex); //从活着的服务中，获取指定的服务来进行操作
                }

                //===========================================
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
