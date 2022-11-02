package dz.soljit.soljitdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AllCandidature {

    @JsonIgnore
    public ObjectDescribe objectDescribe;

    public ArrayList<RecentItem> recentItems;

}
