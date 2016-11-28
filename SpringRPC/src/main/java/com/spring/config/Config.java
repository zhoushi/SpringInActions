package com.spring.config;

/**
 * Created by Administrator on 2016/11/28.
 */

import com.spring.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * 配置bean
 */
@Configuration
public class Config {
    /**
     * 使用RmiProxyFactoryBean引用SpitterService 的RMI服务
     * @return
     */
    @Bean
    public RmiProxyFactoryBean spitterService(){
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/SpitterService");
        rmiProxy.setServiceInterface(SpitterService.class);
        return rmiProxy;
    }

    /**
     * hessian
     */
    @Bean
    public HessianServiceExporter hessianExportedSpitterService(SpitterService service){
        HessianServiceExporter exporter = new HessianServiceExporter();

        exporter.setService(service);

        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }
}
