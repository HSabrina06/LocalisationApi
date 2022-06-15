package com.api.localisation.Controller;

import com.api.localisation.Entity.TypeState;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PointRequest {

    private String lan;

    private String lng;

}
