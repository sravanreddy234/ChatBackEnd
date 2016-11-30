package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDAO;
import com.niit.daoImpl.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Chat;
import com.niit.model.Event;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.JobApplication;
import com.niit.model.Users;



@Configuration
@ComponentScan("com.niit.binder")
//@ComponentScan(basePackages = "com.niit.binder", excludeFilters = @Filter(type = FilterType.ANNOTATION, value = AppConfig.class))
@EnableTransactionManagement
public class ApplicationContextConfig {
	/*@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
				--- Database connection settings ---
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");		//specify the driver...
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");		//specify the db_url...
		dataSource.setUsername("SRAVAN");		//specify the db_username...
		dataSource.setPassword("sravan");		//specify the db_password...
		

		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle11gDialect");
		connectionProperties.setProperty("hibernate.format_sql", "true");
		connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
		dataSource.setConnectionProperties(connectionProperties);		
		return dataSource;                                    // we are using oracle db for our project...
	}*/
	
	
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/sra");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.showsql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
	@Bean(name = "sessionFactory")			//sessionfactory creates the session for the application...
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		//specify all the model classes... 
		sessionBuilder.addAnnotatedClass(Users.class);			
		sessionBuilder.addAnnotatedClass(Blog.class);	
		sessionBuilder.addAnnotatedClass(Chat.class);	
		sessionBuilder.addAnnotatedClass(Event.class);	
		sessionBuilder.addAnnotatedClass(Friend.class);	
		sessionBuilder.addAnnotatedClass(Job.class);		
		sessionBuilder.addAnnotatedClass(Forum.class);	
		sessionBuilder.addAnnotatedClass(ForumComment.class);
		sessionBuilder.addAnnotatedClass(JobApplication.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	
	return transactionManager;
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDetailsDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
}
