package com.learn.usermanagement.userinformation.userclass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @JsonIgnore
    private Integer id;
    private String username;
    private String user_password;
    private String email;
    @JsonIgnore
    private String status;
    @JsonIgnore
    private Integer role_id;

    private String role_name;

    private Integer institution_id;
}
