package com.aemtr.core.models.gallery;

import org.apache.commons.compress.utils.Lists;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GalleryModel {

    @SlingObject
    private Resource resource;

    @ChildResource
    private List<GalleryImageItemModel> images;

    @PostConstruct
    protected void init(){
       // collectImages();
    }

    public List<GalleryImageItemModel> getImages() {
        return images;
    }
}
