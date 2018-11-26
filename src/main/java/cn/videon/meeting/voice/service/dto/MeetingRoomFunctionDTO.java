package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MeetingRoomFunction entity.
 */
public class MeetingRoomFunctionDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MeetingRoomFunctionDTO meetingRoomFunctionDTO = (MeetingRoomFunctionDTO) o;
        if (meetingRoomFunctionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), meetingRoomFunctionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MeetingRoomFunctionDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
