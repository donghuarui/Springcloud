package com.dhr.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/25 15:54
 * @Description:
 */
@Configuration
public class RuiRule {
    @Bean
    public IRule myRule() {
//        return new RandomRule();
        return new RuiRandomRule();
    }

}