package com.example.payload.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentDateTime;
    private String appointmentReason;
    private Long patientId;
    private Long doctorId;
}
