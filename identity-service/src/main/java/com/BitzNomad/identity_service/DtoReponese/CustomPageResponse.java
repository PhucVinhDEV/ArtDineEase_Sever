package com.BitzNomad.identity_service.DtoReponese;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomPageResponse<T> {
    long totalElements;
    int totalPages;
    int size;
    int number;
    List<T> content;
    boolean first;
    boolean last;
    int numberOfElements;
    boolean empty;
}
