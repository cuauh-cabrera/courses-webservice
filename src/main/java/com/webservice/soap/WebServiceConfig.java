package com.webservice.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	private static final String COURSE_DETAILS_ENDPOINT = "/ws/*";

  	
	/**
	 * Creates a MessageDispatcherServlet to handle requests by mapping the
	 * message servlet into an endpoint URL   
	 * @param the application context information
	 * @return a servletRegistrationBean endpoint
	 */
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(messageDispatcherServlet, COURSE_DETAILS_ENDPOINT);
	}
	
	/**
	 * Creates a WSDL contract from a XSD schema 
	 * @param coursesSchema representing the course-details.xsd
	 * @return a WSDL definition 
	 */
	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://cuauh-cabrera.com/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesSchema);
		return definition;
	}
	
	/**
	 * Defines a bean to represent the course details XSD schema
	 * @return a representation of the provided XSD schema
	 */
	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/course-details.xsd"));
	}
	
	
}
