package com.bnsal;

import java.util.Set;

import com.bnsal.model.Sitemap;
import com.bnsal.model.SitemapEntry;
import com.bnsal.model.SitemapIndex;

/**
 * @author Bnsal
 */
interface ISitemapParser {
    void parse();
    Set<SitemapIndex> getSitemapIndexes();
    Set<SitemapEntry> getSitemapEntries();
    Sitemap.SitemapType getSitemapType();
}
