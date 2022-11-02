package dz.soljit.soljitdemo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTH_INFO")
public class LoginResponse{

    @Id
    @GeneratedValue
    private Long myId;

    public String access_token;
    public String instance_url;
    public String id;
    public String token_type;
    public String issued_at;
    public String signature;
}
