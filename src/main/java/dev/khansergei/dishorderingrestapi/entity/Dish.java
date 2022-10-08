package dev.khansergei.dishorderingrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private Long id;
    private String name;
    private String type;
    private Integer price;
}
