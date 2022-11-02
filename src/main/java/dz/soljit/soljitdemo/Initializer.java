package dz.soljit.soljitdemo;


import dz.soljit.soljitdemo.model.LoginResponse;
import dz.soljit.soljitdemo.repository.AuthRepository;
import dz.soljit.soljitdemo.services.RestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

    private final RestService restService;

    private final AuthRepository authRepository;

    /*public Initializer(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }*/

    public Initializer(RestService restService, AuthRepository authRepository) {
        this.restService = restService;
        this.authRepository = authRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        LoginResponse loginResponse = restService.login();

        authRepository.save(loginResponse);

        restService.allCandidature();

    }
}
