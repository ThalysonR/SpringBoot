package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@Controller
public class Configuracao {
    public static void main(String[] args) {
        SpringApplication.run(Configuracao.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
        dataSource.setUsername("teste");
        dataSource.setPassword("123456");
        return dataSource;
    }

//    @Bean
//    @PropertySource(additionalProperties.class)
//    public Properties additionalProperties(){
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "update");
//        return props;
//    }
}
