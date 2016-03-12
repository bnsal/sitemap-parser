package bithazard.sitemap.parser;

import bithazard.sitemap.parser.model.Sitemap;
import bithazard.sitemap.parser.model.SitemapEntry;
import bithazard.sitemap.parser.model.SitemapIndex;

import java.util.Set;

/**
 * @author Bithazard
 */
interface ISitemapParser {
    void parse();
    Set<SitemapIndex> getSitemapIndexes();
    Set<SitemapEntry> getSitemapEntries();
    Sitemap.SitemapType getSitemapType();
}
