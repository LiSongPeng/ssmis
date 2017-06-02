package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import team.jiangtao.entity.Course;
import team.jiangtao.entity.CoursesTable;
import team.jiangtao.entity.Student;
import team.jiangtao.entity.Teacher;

import java.util.Date;
import java.util.List;


/**
 * Created by tose on 2017/5/31.
 */
public class CoursesTableDaoTest {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            //Query<CoursesTable> query = session.createNativeQuery("from coursesTable ct LEFT JOIN courseSchedule cs ON ct.crsId=cs.crsId AND ct.dpmId=cs.dpmId AND ct.tchId=cs.tchId LEFT JOIN studentSchedule ss ON cs.tchId=ss.tch and cs.dpmId=ss.dpm AND cs.crsId=ss.crs WHERE ss.stu=?1");
            Query<CoursesTable> query = session.createNativeQuery("SELECT courses_table.* FROM courses_table LEFT JOIN course_schedule ON courses_table.crs_id=course_schedule.crs_id AND  courses_table.dpm_id=course_schedule.dpm_id AND courses_table.tch_id=course_schedule.tch_id LEFT JOIN student_schedule ON course_schedule.tch_id=student_schedule.tch and course_schedule.dpm_id=student_schedule.dpm AND course_schedule.crs_id=student_schedule.crs WHERE student_schedule.stu=?1", CoursesTable.class);
            query.setParameter(1, "20141111");
            List<CoursesTable> list = query.list();
            System.out.println("list" + list.get(0).getClass());
            String[][] table = new String[5][11];
            String site, off, name, teacher;
            String[] offs, sites;
            String content;
            int offValue;
            for (CoursesTable each : list) {
                site = each.getSite();
                System.out.println("site:" + site);
                teacher = each.getTeacherByTchId().getName();
                System.out.println("teacher:" + teacher);
                name = each.getCourseByCrsId().getCrsName();
                off = each.getOff();
                offs = off.split(",");
                sites = site.split(",");
                for (int i = 0; i < offs.length; i++) {
                    content = "";
                    offValue = Integer.valueOf(offs[i]);
                    content += name + "<br/>" + teacher + "<br/>" + sites[i];
                    table[offValue / 11][offValue % 11] = content;
                }
            }
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++)
                    System.out.println(table[i][j]);
            }
            System.out.println(list.size());
            transaction.commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }

    }
}
