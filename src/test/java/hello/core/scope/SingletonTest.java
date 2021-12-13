package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest
{
    @Test
    void singletonBeanFine()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);

        Assertions.assertThat(bean1).isEqualTo(bean2);
        ac.close();

    }

    @Scope()
    static class SingletonBean
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
