package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import cn.videon.meeting.voice.domain.enumeration.Status;

/**
 * A DTO for the MeetingRoom entity.
 */
public class MeetingRoomDTO implements Serializable {

    private Long id;

    private String name;

    private Integer maxPeople;

    private String imageUrl;

    private Status status;

    private Long levelId;

    private Set<MeetingRoomFunctionDTO> meetingRoomFunctions = new HashSet<>();

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

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Set<MeetingRoomFunctionDTO> getMeetingRoomFunctions() {
        return meetingRoomFunctions;
    }

    public void setMeetingRoomFunctions(Set<MeetingRoomFunctionDTO> meetingRoomFunctions) {
        this.meetingRoomFunctions = meetingRoomFunctions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MeetingRoomDTO meetingRoomDTO = (MeetingRoomDTO) o;
        if (meetingRoomDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), meetingRoomDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MeetingRoomDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", maxPeople=" + getMaxPeople() +
            ", imageUrl='" + getImageUrl() + "'" +
            ", status='" + getStatus() + "'" +
            ", level=" + getLevelId() +
            "}";
    }
}
