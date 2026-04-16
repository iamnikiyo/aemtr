package com.aemtr.core.models.logolist;

import com.aemtr.core.testcontext.AppAemContext;
import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(AemContextExtension.class)
class LogoListModelTest {

    private final AemContext context = AppAemContext.newAemContext();

    private LogoListModel model;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(LogoListModel.class, LogoItem.class);

        Page page = context.create().page("/content/aemtr/test");
        Resource logoList = context.create().resource(page, "logo-list",
                "sling:resourceType", "aemtr/components/logo-list");
        Resource multifield = context.create().resource(logoList, "logosMultifield");
        context.create().resource(multifield, "item0",
                "logoReference", "/content/dam/aemtr/logo.png",
                "imageAlt", "AEMTR",
                "link", "/content/aemtr/test");

        model = logoList.adaptTo(LogoListModel.class);
    }

    @Test
    void exposesLombokGeneratedGettersForHtl() {
        assertNotNull(model);
        assertNotNull(model.getLogosMultifield());
        assertEquals(1, model.getLogosMultifield().size());

        LogoItem item = model.getLogosMultifield().get(0);
        assertEquals("/content/dam/aemtr/logo.png", item.getLogoReference());
        assertEquals("AEMTR", item.getImageAlt());
        assertEquals("/content/aemtr/test", item.getLink());
    }
}
