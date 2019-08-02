package evgenyt.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Spring JDBC connection sample
 *
 * - dataSource bean described in applicationContext.xml file
 * - jar-file wiath drivers downloaded and added to libs
 * - spring-jdbc dependency added to pom.xml
 *
 * Aug 2019 EvgenyT
 */

public class App 
{
    public static void main( String[] args )
    {
        // Read context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // Get dataSource bean
        DriverManagerDataSource dataSource = context.getBean("dataSource",
                DriverManagerDataSource.class);
        // Connect DB and execute query
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.
                    prepareStatement("insert into person(person_name) values ('John Flint')");
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
