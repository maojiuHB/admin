package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.MeetingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Meeting and its DTO MeetingDTO.
 */
@Mapper(componentModel = "spring", uses = {MeetingRoomMapper.class, MeetingRoomFunctionMapper.class})
public interface MeetingMapper extends EntityMapper<MeetingDTO, Meeting> {

    @Mapping(source = "meetingRoom.id", target = "meetingRoomId")
    MeetingDTO toDto(Meeting meeting);

    @Mapping(source = "meetingRoomId", target = "meetingRoom")
    Meeting toEntity(MeetingDTO meetingDTO);

    default Meeting fromId(Long id) {
        if (id == null) {
            return null;
        }
        Meeting meeting = new Meeting();
        meeting.setId(id);
        return meeting;
    }
}
