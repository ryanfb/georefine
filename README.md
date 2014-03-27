GeoRefine
=========

GeoRefine is a geospatial processing extension for [OpenRefine](http://openrefine.org/).

GREL functions
--------------

 * `point`: creates a point from latitude and longitude in the WGS84 coordinate reference system
 * `distance`: computes the distance between two points in meters
 * `parseGeoJson`: parses GeoJSON string

Feature Wishlist
----------------

 * parsing geospatial information from and to GeoJSON/WKT/WKB
 * spatial operations in GREL: distance, area, contains, overlaps, touches, equals, crosses, disjoint, within
 * spatial faceting on spatial operations
 * spatial clustering
 * simple spatial visualization

Compiling
---------

Unlike most OpenRefine extensions, GeoRefine uses maven instead of ant, due to the need for complicated [GeoTools](http://www.geotools.org/) dependencies. Run `mvn compile` to compile Java source to classes. If you update dependencies, run `mvn dependency:copy-dependencies` to install them into `target`. You'll then need to manually move them into `module/MOD-INF/lib`, taking care to remove conflicting jars already provided by OpenRefine such as `openrefine-1.0.jar` and `json-20100208.jar`. GeoRefine is expected to be built in the `extensions` directory of an OpenRefine source tree, with the OpenRefine system jar built in that tree with the `ant jar` task.