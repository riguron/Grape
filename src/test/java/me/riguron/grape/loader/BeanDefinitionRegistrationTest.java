package me.riguron.grape.loader;

import me.riguron.grape.bean.BeanDefinition;
import me.riguron.grape.bean.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BeanDefinitionRegistrationTest {

    @Test
    void whenRegisterNonImplementorThenTypeRegistered() {


        Registry<BeanDefinition> registry = mock(Registry.class);

        BeanDefinitionRegistration beanDefinitionRegistration
                = new BeanDefinitionRegistration(registry);


        beanDefinitionRegistration.register(DoesNotImplement.class,
                mock(BeanDefinition.class));

        verify(registry).put(eq(DoesNotImplement.class), any());
    }

    @Test
    void whenRegisterInterfaceImplementationThenSupertypeRegistered() {

        Registry<BeanDefinition> registry = mock(Registry.class);

        BeanDefinitionRegistration beanDefinitionRegistration
                = new BeanDefinitionRegistration(registry);


        beanDefinitionRegistration.register(Impl.class, mock(BeanDefinition.class)
        );

        verify(registry).put(eq(Interface.class), any());

    }

    static class DoesNotImplement {
    }

    interface Interface {

    }

    static class Impl implements Interface {

    }

}