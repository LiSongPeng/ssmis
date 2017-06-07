package test;

import config.AppConfig;
import dao.impl.StudentDaoImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihuibo on 17-4-4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentDaoTest {
    @Autowired
    SessionFactory sessionFactory;

    @BeforeAll
    public static void initSesssionFactory() {
//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//        Metadata metadata = new MetadataSources(standardRegistry)
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .build();
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
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
        System.out.println((studentDao.findStudentByConditions(conditions,false).get(0).getStuId()));
    }
//    @Test
//    public void testfindcouse() {
//        String key="English";
//        CourseServiceImpl courseService=new CourseServiceImpl();
//        List<CourseSchedule> list;
//        list=courseService.getCoursesInfoByKeyName(key);
//        System.out.println(list.get(0).getCrsId());
//
//
//    }
//    @Test
//    public void testfindallcourse(){
//        CourseServiceImpl courseService=new CourseServiceImpl();
//        List<Course> list=courseService.getallCourse();
//        Iterator iterable= list.iterator();
//        while (iterable.hasNext()){
//            Course course= (Course) iterable.next();
//            System.out.println(course.getCrsId()+course.getCrsName()+course.getSummarization());
//        }
//
//    }

    @Test
    public void t(){
        System.out.println("hello");
    }
    @AfterAll
    public static void close() {

    }
}
