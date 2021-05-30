package bnsal.sitemap.parser;

import java.util.Set;

import bnsal.sitemap.parser.model.Sitemap;
import bnsal.sitemap.parser.model.SitemapEntry;
import bnsal.sitemap.parser.model.SitemapIndex;

/**
 * @author Bnsal
 */
interface ISitemapParser {
    void parse();
    Set<SitemapIndex> getSitemapIndexes();
    Set<SitemapEntry> getSitemapEntries();
    Sitemap.SitemapType getSitemapType();
}
