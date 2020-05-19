package com.monitor4all.tinySpring.ioc.xml;

import com.monitor4all.tinySpring.ioc.BeanDefinition;
import com.monitor4all.tinySpring.ioc.BeanPostProcessor;
import com.monitor4all.tinySpring.ioc.BeanReference;
import com.monitor4all.tinySpring.ioc.PropertyValue;
import com.monitor4all.tinySpring.ioc.factory.BeanFactory;
import com.monitor4all.tinySpring.ioc.factory.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlBeanFactory implements BeanFactory {

    /**
     * 从xml读取的数据存入Map<String, BeanDefinition>
     */
    private XmlBeanDefinitionReader beanDefinitionReader;

    /**
     * 存储Bean的名称
     */
    private List<String> beanDefinitionNames = new ArrayList<>();

    /**
     * 存储Map<String, BeanDefinition>
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 存储所有读取到的BeanPostProcessor类
     */
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String beanId) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("no this bean with name " + beanId);
        }

        // 将BeanDefinition中的bean进行初始化赋值
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
            bean = initializeBean(bean, beanId);
            beanDefinition.setBean(bean);
        }

        return bean;
    }

    /**
     * XmlBeanFactory构造函数
     */
    public XmlBeanFactory(String location) throws Exception {
        beanDefinitionReader = new XmlBeanDefinitionReader();
        loadBeanDefinitions(location);
    }

    /**
     * 1. 读取Bean配置文件:将读到的Bean配置通过XmlBeanDefinitionReader封装成BeanDefinition对象
     * @param location
     * @throws Exception
     */
    private void loadBeanDefinitions(String location) throws Exception {
        beanDefinitionReader.loadBeanDefinitions(location);
        registerBeanDefinition();
        registerBeanPostProcessor();
    }


    /**
     * 2. 将封装好的 BeanDefinition 对象注册到 BeanDefinition 容器中
     */
    private void registerBeanDefinition() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionReader.getRegistry().entrySet()) {
            String name = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            beanDefinitionMap.put(name, beanDefinition);
            beanDefinitionNames.add(name);
        }
    }

    /**
     * 3. 注册 BeanPostProcessor 相关实现类到 BeanPostProcessor 容器中
     * 4. 随后BeanFactory进入就绪状态
     * @throws Exception
     */
    private void registerBeanPostProcessor() throws Exception {
        List beans = getBeansForType(BeanPostProcessor.class);
        for (Object bean : beans) {
            addBeanPostProcessor((BeanPostProcessor) bean);
        }
    }

    /**
     * 判断如果是BeanPostProcessor.class则加入List
     * @param type
     * @return
     * @throws Exception
     */
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

    /**
     * 将beanPostProcessor加入beanPostProcessors中
     * @param beanPostProcessor
     */
    private void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 创建bean
     * @param bd
     * @return
     * @throws Exception
     */
    private Object createBean(BeanDefinition bd) throws Exception {
        Object bean = bd.getBeanClass().newInstance();
        applyPropertyValues(bean, bd);

        return bean;
    }

    /**
     * 将属性值写入Bean中
     * @param bean
     * @param bd
     * @throws Exception
     */
    private void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : bd.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }

    /**
     * 初始化Bean：对赋值后的Bean进行前置后置操作
     * @param bean
     * @param name
     * @return
     * @throws Exception
     */
    private Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

}
