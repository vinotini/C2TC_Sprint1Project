package dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MathsExam {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationincontext.xml");

        Student diStudent1 = context.getBean("diStudent1", Student.class);
        Student1 diStudent2 = context.getBean("diStudent2", Student1.class);

        diStudent1.showInfo();
        diStudent2.showInfo();
    }
}