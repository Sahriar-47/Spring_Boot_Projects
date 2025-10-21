package com.example.payload.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private Long id;
    private String name;
    private String gender;
    private String mobileNumber;
    private String email;
    private Long insuranceId;
    private List<Long> appointmentIds;
}
