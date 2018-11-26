package cn.videon.meeting.voice.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import cn.videon.meeting.voice.domain.enumeration.Status;

/**
 * A DTO for the Meeting entity.
 */
public class MeetingDTO implements Serializable {

    private Long id;

    private String name;

    private String recorder;

    private String compere;

    private String participator;

    private Instant startTime;

    private Instant endTime;

    private String result;

    private String voiceInfo;

    private String level;

    private String type;

    private Status status;

    private Long meetingRoomId;

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

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere;
    }

    public String getParticipator() {
        return participator;
    }

    public void setParticipator(String participator) {
        this.participator = participator;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVoiceInfo() {
        return voiceInfo;
    }

    public void setVoiceInfo(String voiceInfo) {
        this.voiceInfo = voiceInfo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Long meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
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

        MeetingDTO meetingDTO = (MeetingDTO) o;
        if (meetingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), meetingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MeetingDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", recorder='" + getRecorder() + "'" +
            ", compere='" + getCompere() + "'" +
            ", participator='" + getParticipator() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", result='" + getResult() + "'" +
            ", voiceInfo='" + getVoiceInfo() + "'" +
            ", level='" + getLevel() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            ", meetingRoom=" + getMeetingRoomId() +
            "}";
    }
}
