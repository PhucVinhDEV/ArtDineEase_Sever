package com.BitzNomad.identity_service.configuration;

import com.BitzNomad.identity_service.Entity.Restaurant.Size;
import com.BitzNomad.identity_service.Respository.RestaurantRepository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataInitializer {

    @Autowired
    SizeRepository sizeRepository;

//    @Bean
//    public CommandLineRunner LoadData(DataSource dataSource) {
//        return args -> {
//            try (Connection connection = dataSource.getConnection()) {
//                ScriptUtils.executeSqlScript(connection, new ClassPathResource("data.sql"));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        };
//    }
}
