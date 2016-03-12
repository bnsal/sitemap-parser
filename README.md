Java sitemap parser
===================
Java library to parse sitemaps. For details see the Javadoc comments in the respective classes.

**General information:**
- works with Java 7 and higher
- no other dependencies
- currently built with Maven
- MIT license

**To get you started:**

    SitemapParser sitemapParser = new SitemapParser();
This creates a new SitemapParser.

Let's assume you want to parse the sitemap(s) of a website and want to make sure that this still works even when the location of the sitemap(s) changes. 

    Set<String> sitemapLocations = sitemapParser.getSitemapLocations("https://www.google.com/");
This returns a Set with URLs of the locations of the sitemaps of the website (in this case from Google). You can pass any URL from a website. The getSitemapLocations only uses the hostname (as well as protocol and port) and ignores the rest. Internally the methods fetches the robots.txt file of the webserver and extracts the sitemap information. So this method will only work when the robots.txt file contains at least one entry for a sitemap (which is the case for Google).

    int sitemapLocationSize = sitemapLocations.size();
    String lastSitemapLocation = sitemapLocations.toArray(new String[sitemapLocationSize])[sitemapLocationSize - 1];
    Sitemap sitemap = sitemapParser.parseSitemap(lastSitemapLocation, false);
This would parse the last sitemap that was returned. If this is a sitemap index (which it is in this case), it would not recursivly parse all contained sitemaps but only the sitemap index. Pass true as second parameter or omit it to parse all contained sitemaps (this will be quite a few in this case).

    System.out.println("Sitemap is of type " + sitemap.getSitemapType());
    System.out.println("Sitemap contains " + sitemap.getSitemapIndexes().size() + "sitemap indexes");
This prints the type of the sitemap and of how many sitemap indexes the sitemap consists.

    SitemapIndex firstSitemapIndex = sitemap.getSitemapIndexes().iterator().next();
    sitemap = sitemapParser.parseSitemap(firstSitemapIndex.getLoc());
This gets the sitemap for the first sitemap index entry.

    Date minLastModDate = new GregorianCalendar(2015, Calendar.AUGUST, 15).getTime();
    sitemap = sitemap.getSitemapWithMinPriority(0.9).getSitemapModifiedAfter(minLastModDate);
This filters out entries with a priority lower than 0.9 and before 2015-08-15 (this is done locally without fetching the sitemap again). 

    System.out.println("Sitemap is of type " + sitemap.getSitemapType());
    System.out.println("Sitemap contains " + sitemap.getSitemapEntries().size() + " entries after filtering");
    for (SitemapEntry sitemapEntry : sitemap.getSitemapEntries()) {
        System.out.println(sitemapEntry);
    }
This prints out the sitemap type (which is XML in this case) and the number of entries that remained after filtering. Afterwards these entries are printed as well.
