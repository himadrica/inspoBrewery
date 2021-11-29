package com.inspo.solutions.inspoBrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private UUID id;

    @NotNull(message = "Name can not be null")
    @Size(min = 3, max = 8, message = "Name should be between")
    private String name;
}
