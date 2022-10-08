package dev.khansergei.dishorderingrestapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("dish_name")
    private String dishName;
    private LocalDateTime time;
}
