package cn.videon.meeting.voice.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Modification entity.
 */
public class ModificationDTO implements Serializable {

    private Long id;

    private Instant time;

    private String result;

    private Long userId;

    private Long meetingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModificationDTO modificationDTO = (ModificationDTO) o;
        if (modificationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), modificationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ModificationDTO{" +
            "id=" + getId() +
            ", time='" + getTime() + "'" +
            ", result='" + getResult() + "'" +
            ", user=" + getUserId() +
            ", meeting=" + getMeetingId() +
            "}";
    }
}
