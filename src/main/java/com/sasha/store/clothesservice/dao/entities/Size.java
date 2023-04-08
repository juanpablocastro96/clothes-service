package com.sasha.store.clothesservice.dao.entities;

import lombok.Getter;

@Getter
public enum Size {
    XS("extra-small"),
    S("small"),
    M("medium"),
    L("large"),
    XL("extra-large"),
    XXL("extra-extra-large");
    Size(String size) {
    }
}
