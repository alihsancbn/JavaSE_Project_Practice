package com.alihs.dto;

import com.alihs.roles.ERoles;
import lombok.Getter;
import lombok.Setter;



import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
//@Builder
public class Register extends Base implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    private String userName;
    private String email;
    private String password;
    private String roles;
    private String phoneNum;
    private Boolean isPassive;

    public Register(Long ID, Date createDate, String userName, String email, String password, String roles, String phoneNum, Boolean isPassive) {
        super(ID, createDate);
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.phoneNum = phoneNum;
        this.isPassive = isPassive;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isPassive=" + isPassive +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        /*Register user1 = Register.builder()

                .email("alihsancbn@gmail.com")
                .password("12345")
                .isPassive(false)
                .userName("KaiserWII")
                .roles(ERoles.ADMIN.toString())
                .build();*/
        Register user1 = new Register();
        user1.setID(1L);
        user1.setEmail("alihsancbn@gmail.com");
        user1.setPassword("12345");
        user1.setIsPassive(Boolean.FALSE);
        user1.setUserName("KaiserWII");
        user1.setRoles(ERoles.ADMIN.toString());
        System.out.println(user1);
    }
}
