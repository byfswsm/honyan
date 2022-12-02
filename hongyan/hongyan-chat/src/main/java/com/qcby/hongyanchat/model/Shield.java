package com.qcby.hongyanchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Shield {
    private Long id;

    private Long userId;

    private Long shieldId;
}
