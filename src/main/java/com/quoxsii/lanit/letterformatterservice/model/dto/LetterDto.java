package com.quoxsii.lanit.letterformatterservice.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "Письмо_инопланетянам")
@XmlAccessorType(XmlAccessType.FIELD)
@Validated
public class LetterDto {

    @Valid
    @NotNull(message = "tag <код_расы> must be presented")
    @XmlElement(name = "код_расы")
    private Race race;

    @Valid
    @NotNull(message = "tag <created> must be presented")
    @XmlElement(name = "created")
    private Created created;

    @Valid
    @NotNull(message = "tag <uid> must be presented")
    @XmlElement(name = "uid")
    private Uid uid;

    @Valid
    @NotEmpty(message = "tag <author> must be presented at least once")
    @XmlElement(name = "author")
    private List<Author> authors;

    @Valid
    @NotNull(message = "tag <document> must be presented")
    @XmlElement(name = "document")
    private Document document;

    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "код_расы")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Validated
    public static class Race {

        @NotBlank(message = "tag <value> of <код_расы> must not be empty")
        @XmlElement(name = "value")
        private String value;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "created")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Validated
    public static class Created {

        @NotBlank(message = "attribute date_time of <created> must not be empty")
        @XmlAttribute(name = "date_time")
        private String date;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "uid")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Validated
    public static class Uid {

        @Valid
        @NotNull(message = "tag <code> of <uid> must be presented")
        @XmlElement(name = "code")
        private Code code;

        @Getter
        @Setter
        @NoArgsConstructor
        @XmlRootElement(name = "code")
        @XmlAccessorType(XmlAccessType.FIELD)
        @Validated
        public static class Code {

            @NotBlank(message = "tag <value> of <code> must not be empty")
            @XmlElement(name = "value")
            private String value;

        }

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "author")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Validated
    public static class Author {

        @Valid
        @NotNull(message = "tag <id> of <author> must be presented")
        @XmlElement(name = "id")
        private Id id;

        @Getter
        @Setter
        @NoArgsConstructor
        @XmlRootElement(name = "id")
        @XmlAccessorType(XmlAccessType.FIELD)
        @Validated
        public static class Id {

            @NotBlank(message = "tag <value> of <id> must not be empty")
            @XmlElement(name = "value")
            private String value;

        }

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "document")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Validated
    public static class Document {

        @NotBlank(message = "tag <text> of <document> must not be empty")
        @XmlElement(name = "text")
        private String text;

        @XmlElement(name = "address")
        private Address address;

        @XmlElement(name = "tel")
        private Tel tel;

        @Getter
        @Setter
        @NoArgsConstructor
        @XmlRootElement(name = "address")
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Address {

            @XmlElement(name = "value")
            private String value;

        }

        @Getter
        @Setter
        @NoArgsConstructor
        @XmlRootElement(name = "tel")
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Tel {

            @XmlElement(name = "value")
            private String value;

        }

    }

}
