package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.Objects;
import cn.videon.meeting.voice.domain.enumeration.WordsType;

/**
 * A DTO for the Word entity.
 */
public class WordDTO implements Serializable {

    private Long id;

    private String word;

    private WordsType wordsType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordsType getWordsType() {
        return wordsType;
    }

    public void setWordsType(WordsType wordsType) {
        this.wordsType = wordsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WordDTO wordDTO = (WordDTO) o;
        if (wordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), wordDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WordDTO{" +
            "id=" + getId() +
            ", word='" + getWord() + "'" +
            ", wordsType='" + getWordsType() + "'" +
            "}";
    }
}
