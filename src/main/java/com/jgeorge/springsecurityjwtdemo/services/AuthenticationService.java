package com.jgeorge.springsecurityjwtdemo.services;

import com.jgeorge.springsecurityjwtdemo.dto.JwtAuthenticationResponse;
import com.jgeorge.springsecurityjwtdemo.dto.RefreshTokenRequest;
import com.jgeorge.springsecurityjwtdemo.dto.SigninRequest;
import com.jgeorge.springsecurityjwtdemo.dto.SignupRequest;
import com.jgeorge.springsecurityjwtdemo.entity.User;

public interface AuthenticationService {
  User signup(SignupRequest signUpRequest);

  JwtAuthenticationResponse signin(SigninRequest signInRequest);

  JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
