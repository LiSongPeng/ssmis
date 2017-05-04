package test;

/**
 * Created by lihuibo on 17-4-4.
 */
//public class StudentDaoTest {
//    static SessionFactory sessionFactory;
//
//    @BeforeAll
//    public static void initSesssionFactory() {
//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//        Metadata metadata = new MetadataSources(standardRegistry)
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .build();
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
//    }
//
//    @Test
//    public void testfindStudentByConditions() {
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.setSessionFactory(sessionFactory);
//        Map<String, Object> conditions = new HashMap<>(2);
///*        String stu_id="20143232";
//        String password="123456";
//        conditions.put("address",stu_id);
//        conditions.put("password",password);
//        Assertions.assertEquals(studentDao.findStudentByConditions(conditions).get(0).getStu_id(),stu_id);*/
//        String bluremail ="河南";/*new String("河南".getBytes(), Charset.forName("UTF-8"));*/
//        conditions.put("address",bluremail);
//        System.out.println((studentDao.findStudentByConditions(conditions,false).get(0).getStuId()));
//    }
//    @Test
//    public void testffindallcourse() {
//        CourseDaoImpl courseDao=new CourseDaoImpl();
//        courseDao.setSessionFactory(sessionFactory);
//        Map<String,Object> con=new HashMap<>();
//        String id="1";
//        String name="English";
//        con.put("crsId",id);
//        con.put("crsName",name);
//        List<Course> list;
//        list=courseDao.findCourseByConditions(con,true,false);
//        System.out.println(list.get(0).getCrsName());
//
//    }
//
//    @AfterAll
//    public static void close() {
//        sessionFactory.close();
//    }
//}
