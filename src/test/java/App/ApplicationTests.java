package App;

import App.controller.*;
import App.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ChatController chatController;

    @Autowired
    DoctorController doctorController;

    @Autowired
    DonationController donationController;

    @Autowired
    PatientController patientController;

    @Autowired
    StudentController studentController;

    @Autowired
    UserController userController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void contextLoads() {
        assertThat(authenticationController).isNotNull();
        assertThat(chatController).isNotNull();
        assertThat(doctorController).isNotNull();
        assertThat(donationController).isNotNull();
        assertThat(patientController).isNotNull();
        assertThat(studentController).isNotNull();
        assertThat(userController).isNotNull();
    }

    @Test
    public void checkAuthority() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().is(401));
        this.mockMvc.perform(get("/auth/login")).andExpect(status().is(405));
    }

}
