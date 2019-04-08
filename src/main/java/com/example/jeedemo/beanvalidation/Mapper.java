package com.example.jeedemo.beanvalidation;

import org.mapstruct.Mappings;

@org.mapstruct.Mapper(componentModel = "cdi")
public interface Mapper {

    CopyDemo toCopyDemo (DemoBean demoBean);

}
