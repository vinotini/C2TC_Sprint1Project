package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCDemo {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationincontext.out.xml");

        Phone jio = context.getBean("jio", Phone.class);
        jio.calling();
        jio.internet();

        Phone oppo = context.getBean("oppo", Phone.class);
        oppo.calling();
        oppo.internet();

        Phone samsung = context.getBean("samsung", Phone.class);
        samsung.calling();
        samsung.internet();
    }
}
