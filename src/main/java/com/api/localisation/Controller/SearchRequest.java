package com.api.localisation.Controller;

import com.api.localisation.Entity.TypeState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    @JsonProperty("p1")
    @Nullable
    public PointRequest p1;
    @Nullable
    @JsonProperty("p2")
    public PointRequest p2;
    public TypeState type;
    public Integer limit;
}
