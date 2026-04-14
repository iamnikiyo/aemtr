package com.aemtr.core.models.gallery;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GalleryImageItemModel {

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String imageReference;

    @ValueMapValue
    private String imageAlign;

    public String getLink() {
        return link;
    }

    public String getImageReference() {
        return imageReference;
    }

    public String getImageAlign() {
        return imageAlign;
    }
}
