package angularauthbackend.config;

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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import angularauthbackend.model.User;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "angularauthbackend")
public class WebConfig extends WebMvcConfigurerAdapter{
     
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean(name = "dataSource")
   	public DataSource getH2DataSource() {
   		DriverManagerDataSource dataSource = new DriverManagerDataSource();
   		dataSource.setDriverClassName("org.h2.Driver");
   		dataSource.setUrl("jdbc:h2:tcp://localhost/~/angularauth");

   		dataSource.setUsername("sa");
   		dataSource.setPassword("");
   		
   		
   		return dataSource;
   	}
       
       private Properties getHibernateProperties() {
       	Properties properties = new Properties();
       	properties.setProperty("hibernate.hbm2ddl.auto", "update");
       	properties.put("hibernate.show_sql", "true");
       	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
       	return properties;
       }
       
       @Autowired
       @Bean(name = "sessionFactory")
       public SessionFactory getSessionFactory(DataSource dataSource) {
       	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
       	sessionBuilder.addProperties(getHibernateProperties());
       	sessionBuilder.addAnnotatedClasses(User.class);
       	return sessionBuilder.buildSessionFactory();
       }
       
   	@Autowired
   	@Bean(name = "transactionManager")
   	public HibernateTransactionManager getTransactionManager(
   			SessionFactory sessionFactory) {
   		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
   				sessionFactory);

   		return transactionManager;
   	}
 
}
