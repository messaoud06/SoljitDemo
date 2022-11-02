package dz.soljit.soljitdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecentItem {

    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
}
