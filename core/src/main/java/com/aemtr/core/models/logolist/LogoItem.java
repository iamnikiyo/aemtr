package com.aemtr.core.models.logolist;

import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class LogoItem {

    @ValueMapValue
    private String logoReference;

    @ValueMapValue
    private String imageAlt;

    @ValueMapValue
    private String link;

}
