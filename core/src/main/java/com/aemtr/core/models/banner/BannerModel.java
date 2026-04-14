package com.aemtr.core.models.banner;

import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerModel {

    @SlingObject
    private Resource resource;

    @ValueMapValue
    private String backgroundColor;

    private String childNodeTitle;

    @PostConstruct
    protected void init(){
        // aqui siempre entra
        collectInfoFromChild();
        String a = "foo";
    }

    private void collectInfoFromChild(){
        Resource childResource = resource.getChild("titlebanner");
        if (childResource != null) {
            ValueMap props = childResource.getValueMap();
            if(props != null && props.containsKey(JcrConstants.JCR_TITLE)){
                this.childNodeTitle = props.get(JcrConstants.JCR_TITLE, String.class);
            }
        }
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}