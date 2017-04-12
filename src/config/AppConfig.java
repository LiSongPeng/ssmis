package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lihuibo on 4/12/17.
 */
@Configuration
@ComponentScan(basePackages = {"dao.impl","service.impl","action"})
public class AppConfig {
    @Bean(destroyMethod = "close")
    public SessionFactory sessionFactory(){
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources metadataSources=new MetadataSources(serviceRegistry);
        return metadataSources.getMetadataBuilder().build().buildSessionFactory();
    }
}
