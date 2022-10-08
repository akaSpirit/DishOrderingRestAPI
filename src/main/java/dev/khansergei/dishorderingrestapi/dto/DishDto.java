package dev.khansergei.dishorderingrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private String place;

    public DishDto(String name, String type, Integer price, String place) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.place = place;
    }
}
