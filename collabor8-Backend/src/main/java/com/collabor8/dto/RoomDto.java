package com.collabor8.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RoomDto {

    @NotBlank(message = "Room name is required")
    @Size(min = 5, max = 100, message = "Room name must be between 5 and 100 characters")
    private String name;

    @NotNull(message = "Owner id is required")
    private int owner_id;

    @NotEmpty(message = "Participant List cannot be empty.")
    private List<Long> participantIds;

    public RoomDto(String name, int id, List<Long> participantIds) {
        this.name = name;
        this.owner_id = id;
        this.participantIds = participantIds;
    }
}
