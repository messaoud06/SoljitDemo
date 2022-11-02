package dz.soljit.soljitdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDescribe {

    public boolean activateable;
    public Object associateEntityType;
    public Object associateParentEntity;
    public boolean createable;
    public boolean custom;
    public boolean customSetting;
    public boolean deepCloneable;
    public boolean deletable;
    public boolean deprecatedAndHidden;
    public boolean feedEnabled;
    public boolean hasSubtypes;
    public boolean isInterface;
    public boolean isSubtype;
    public String keyPrefix;
    public String label;
    public String labelPlural;
    public boolean layoutable;
    public boolean mergeable;
    public boolean mruEnabled;
    public String name;
    public boolean queryable;
    public boolean replicateable;
    public boolean retrieveable;
    public boolean searchable;
    public boolean triggerable;
    public boolean undeletable;
    public boolean updateable;
    public Urls urls;
}
