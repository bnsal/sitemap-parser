package com.bnsal.web;

import java.util.Set;

import com.bnsal.web.model.Sitemap;
import com.bnsal.web.model.SitemapEntry;
import com.bnsal.web.model.SitemapIndex;

/**
 * @author Bnsal
 */
interface ISitemapParser {
    void parse();
    Set<SitemapIndex> getSitemapIndexes();
    Set<SitemapEntry> getSitemapEntries();
    Sitemap.SitemapType getSitemapType();
}
