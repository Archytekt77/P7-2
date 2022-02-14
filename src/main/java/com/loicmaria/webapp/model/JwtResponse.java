package com.loicmaria.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {

    private String jwtToken;

    private User user;


}
