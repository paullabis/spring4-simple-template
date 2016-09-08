package com.mzl.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author paul.labis@practiceinsight.io
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryService {
}
