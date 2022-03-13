package App;

import App.controller.*;
import App.services.interfaces.DonationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
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



}
