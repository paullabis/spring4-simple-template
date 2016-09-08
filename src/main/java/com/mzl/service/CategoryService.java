package com.mzl.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryService {
}
