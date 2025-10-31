package com.example.payload.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceResponse {
    private String insuranceProvider;
    private LocalDate validUntil;
    private String insuranceNumber;
    private Long patientId;
}
