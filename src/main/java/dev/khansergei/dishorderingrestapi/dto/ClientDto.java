package dev.khansergei.dishorderingrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    public ClientDto(String name, String email, String password, boolean enabled) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
}
