package com.spring.annotation;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// this class is required to call the preDestroy methods of prototype scoped bean
@Component 
public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

	private BeanFactory beanFactory;
	
	private final List<Object> prototypeBeans = new LinkedList<>();
	
	@Override
	public void destroy() throws Exception {
		synchronized (prototypeBeans) {
			for (Object obj:prototypeBeans) {
				if (obj instanceof DisposableBean) {
					((DisposableBean) obj).destroy();
				}
			}
		}
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		this.beanFactory = arg0;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if (beanFactory.isPrototype(beanName)) {
			synchronized (prototypeBeans) {
				prototypeBeans.add(bean);
			}
		}
		return bean;
	}

}
