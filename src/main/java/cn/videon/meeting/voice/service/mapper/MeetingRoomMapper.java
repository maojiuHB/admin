package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.MeetingRoomDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MeetingRoom and its DTO MeetingRoomDTO.
 */
@Mapper(componentModel = "spring", uses = {LevelMapper.class, MeetingRoomFunctionMapper.class})
public interface MeetingRoomMapper extends EntityMapper<MeetingRoomDTO, MeetingRoom> {

    @Mapping(source = "level.id", target = "levelId")
    MeetingRoomDTO toDto(MeetingRoom meetingRoom);

    @Mapping(source = "levelId", target = "level")
    MeetingRoom toEntity(MeetingRoomDTO meetingRoomDTO);

    default MeetingRoom fromId(Long id) {
        if (id == null) {
            return null;
        }
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(id);
        return meetingRoom;
    }
}
