package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.WordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Word and its DTO WordDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WordMapper extends EntityMapper<WordDTO, Word> {



    default Word fromId(Long id) {
        if (id == null) {
            return null;
        }
        Word word = new Word();
        word.setId(id);
        return word;
    }
}
