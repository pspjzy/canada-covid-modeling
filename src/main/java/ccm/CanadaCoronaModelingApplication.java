package ccm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CanadaCoronaModelingApplication {

    public static void main(String[] args) { SpringApplication.run(CanadaCoronaModelingApplication.class,args); }

}
