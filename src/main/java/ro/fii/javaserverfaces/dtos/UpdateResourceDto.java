package ro.fii.javaserverfaces.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateResourceDto {
    private Integer id;
    private Integer quantity;
}
