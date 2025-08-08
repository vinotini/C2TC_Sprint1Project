package com.tnsif.springcore_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext var=new ClassPathXmlApplicationContext("applicationincontext.xml");
        
        Collage c1 = var.getBean("smvec",Collage.class);
        c1.display();
        
        Collage c2 = var.getBean("mvit",Collage.class);
        c1.display();
       
    }
}