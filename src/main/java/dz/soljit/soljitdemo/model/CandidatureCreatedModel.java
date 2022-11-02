package dz.soljit.soljitdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatureCreatedModel {

        public String id;
        public boolean success;
        public ArrayList<Object> errors;

}
