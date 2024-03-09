package lk.ijse.config;
import lk.ijse.entity.User;
import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).getMetadataBuilder().build();
        sessionFactory = metadata.buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}