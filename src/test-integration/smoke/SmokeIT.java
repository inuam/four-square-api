package integration.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import com.au.api.SearchApiApplication;
import com.au.api.location.controller.LocationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApiApplication.class)
public class SmokeIT {

    @Autowired
    private LocationController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
}