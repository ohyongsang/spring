package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest
{
    @Test
    void prototypeBeanFind()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("PrototypeBean1 = " + bean1);
        System.out.println("PrototypeBean2 = " + bean2);


    }

    @Scope("prototype")
    static class PrototypeBean
    {
        @PostConstruct
        public void init()
        {
            System.out.println("singleton_init");
        }

        @PreDestroy
        public void destroy()
        {
            System.out.println("singleton_destroy");
        }
    }
}
