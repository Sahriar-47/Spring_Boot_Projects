package com.example.modelview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerModelView {
    private String name;
    private String email;
    private String phoneNo;

    CustomerModelView(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    CustomerModelView(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
