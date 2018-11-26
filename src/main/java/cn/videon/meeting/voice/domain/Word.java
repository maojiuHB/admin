package cn.videon.meeting.voice.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import cn.videon.meeting.voice.domain.enumeration.WordsType;

/**
 * 词汇
 * word：词汇
 * wordsType：词汇类型
 */
@ApiModel(description = "词汇 word：词汇 wordsType：词汇类型")
@Entity
@Table(name = "word")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word")
    private String word;

    @Enumerated(EnumType.STRING)
    @Column(name = "words_type")
    private WordsType wordsType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public Word word(String word) {
        this.word = word;
        return this;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordsType getWordsType() {
        return wordsType;
    }

    public Word wordsType(WordsType wordsType) {
        this.wordsType = wordsType;
        return this;
    }

    public void setWordsType(WordsType wordsType) {
        this.wordsType = wordsType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        if (word.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), word.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Word{" +
            "id=" + getId() +
            ", word='" + getWord() + "'" +
            ", wordsType='" + getWordsType() + "'" +
            "}";
    }
}
