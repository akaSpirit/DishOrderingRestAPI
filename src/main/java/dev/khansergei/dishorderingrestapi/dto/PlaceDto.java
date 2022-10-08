package dev.khansergei.dishorderingrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
    private Long id;
    private String name;
    private String description;

    public PlaceDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
