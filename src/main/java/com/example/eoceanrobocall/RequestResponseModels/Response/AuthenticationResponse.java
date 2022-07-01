package com.example.eoceanrobocall.RequestResponseModels.Response;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private String jwt;
    private String username;
    private Instant expiry;
    private int account_code;
}
