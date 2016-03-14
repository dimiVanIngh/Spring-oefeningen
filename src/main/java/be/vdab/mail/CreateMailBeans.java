package be.vdab.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan
@PropertySource("classpath:/mail.properties")
@EnableAsync
public class CreateMailBeans {
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// SSL
	/*
	@Bean
	@Autowired
	JavaMailSenderImpl javaMailSenderImpl(@Value("${mailserver.host}") String host,
			@Value("${mailserver.portSSL}") int port, @Value("${mailserver.protocol}") String protocol,
			@Value("${mailserver.username}") String username, @Value("${mailserver.password}") String password) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.ssl.checkserveridentity", "true");
	    props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.protocols", "SSLv3");
		mailSender.setJavaMailProperties(props);
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}*/
	
	// TLS 
	@Bean
	@Autowired
	JavaMailSenderImpl javaMailSenderImpl(@Value("${mailserver.host}") String host,
			@Value("${mailserver.portTLS}") int port, @Value("${mailserver.protocol}") String protocol,
			@Value("${mailserver.username}") String username, @Value("${mailserver.password}") String password) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(props);
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	} 
}