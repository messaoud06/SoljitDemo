package dz.soljit.soljitdemo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInformation {

    private String username;
    private String password;
    private String client_id;
    private String client_secret;
    private String grant_type;

}
