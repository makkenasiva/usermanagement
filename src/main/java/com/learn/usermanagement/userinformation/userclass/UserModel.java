package com.learn.usermanagement.userinformation.userclass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @JsonIgnore
    private Long id;
    private String username;
    private String user_password;
    private String email;
    @JsonIgnore
    private String status;

    private Integer role_id;


    private Integer institution_id;
    @JsonIgnore
    private String institution_name;
}
