package com.csrent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
    @NotBlank (message = "El nombre no puede quedar vacio")
    private String name;
    @Email (message = "El correo no es valido")
    @NotBlank (message = "El correo no puede quedar vacio")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[!@#$%^&*()]).{8,}$",
    message = "Expresion que se necesita para crear contrasena")
    @NotBlank (message = "La contrasena no puede quedar vacio")
    private String password;
    @NotBlank (message = "El rol no puede quedar vacio")
    private String rol;


}
