package com.alihs.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

//@Data
//@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
abstract public class Base implements Serializable {
    private Long ID;

    @Builder.Default
    private Date createDate= new Date(System.currentTimeMillis());

    public Base(){
        System.out.println("Hash Code: "+Base.class.hashCode());
    }

}
