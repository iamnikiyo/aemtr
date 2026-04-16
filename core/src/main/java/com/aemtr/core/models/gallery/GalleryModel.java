package com.aemtr.core.models.gallery;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
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
