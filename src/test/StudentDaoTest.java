package test;

import dao.impl.StudentDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihuibo on 17-4-4.
 */
public class StudentDaoTest {
    static SessionFactory sessionFactory;

    @BeforeAll
    public static void initSesssionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    @Test
    public void testfindStudentByConditions() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setSessionFactory(sessionFactory);
        Map<String, Object> conditions = new HashMap<>(2);
/*        String stu_id="20143232";
        String password="123456";
        conditions.put("address",stu_id);
        conditions.put("password",password);
        Assertions.assertEquals(studentDao.findStudentByConditions(conditions).get(0).getStu_id(),stu_id);*/
        String bluremail ="河南";/*new String("河南".getBytes(), Charset.forName("UTF-8"));*/
        conditions.put("address",bluremail);
        System.out.println((studentDao.findStudentByConditions(conditions,false).get(0).getStu_id()));
    }

    @AfterAll
    public static void close() {
        sessionFactory.close();
    }
}
