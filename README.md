# GraphHopper Routing Engine for The University of Windsor

My purpose with this project was to implement a **smart navigation** component within a larger **Smart Campus** web-application to help new students adapt and feel safer on campus. As a user, you can choose from 3 routing options:
* Fastest: that is, the shortest route.
* Indoors: paths that go through buildings are preferred, and a penalty cost is associated with outdoor edges.
  * Useful if you don't like Canadian winters or forgot to bring an umbrella on a rainy day.
* Safest: prefers paths that are well-lit for students walking through campus at night.

**Note:** I've only defined indoor and well-lit paths for the University of Windsor campus, see **TODO: DOCUMENTATION** to learn how to integrate your own route data.

[![Smart Routing Demo](http://charlopov.com/img/portfolio/sc/sc1.png)]


## Useful Documentation
--------------

* Forking
* Modifying weighting / adding additional weightings
* 

GraphHopper for the Web
--------------

See GraphHopper in action on [GraphHopper Maps](https://graphhopper.com/maps)

[![GraphHopper Maps](https://karussell.files.wordpress.com/2014/12/graphhopper-maps-0-4-preview.png)](https://graphhopper.com/maps)

GraphHopper Maps uses the [Directions API for Business](https://graphhopper.com/#directions-api) under the hood, which provides 
a Routing API via GraphHopper, a Route Optimization API via [jsprit](http://jsprit.github.io/), a fast Matrix API
and an address search via [Photon](https://github.com/komoot/photon). Additionally the map tiles from various providers are used 
where the default is [Omniscale](http://omniscale.com/), and all is available for free, via encrypted connections and from German servers
for a nice and private route planning experience!


GraphHopper for Mobile
---------------

There are subprojects to make GraphHopper working offline
on [Android](https://github.com/graphhopper/graphhopper/tree/master/android)
and [iOS](http://github.com/graphhopper/graphhopper-ios)


Get Started
---------------

Read through our Documentation ([0.5](https://github.com/graphhopper/graphhopper/blob/0.5/docs/index.md), [unstable](https://github.com/graphhopper/graphhopper/blob/master/docs/index.md)), 
ask questions on [Stackoverflow](http://stackoverflow.com/questions/tagged/graphhopper)
and sign up to the [discussion](https://discuss.graphhopper.com/).


Contribute
---------------

Read through [how to contribute](https://github.com/graphhopper/graphhopper/blob/master/CONTRIBUTING.md)
like finding and fixing bugs and improving our documentation or translations!


Features
---------------

 * Written in Java
 * Open Source
 * Memory efficient and fast
 * Highly customizable
 * Works on the desktop, as a web service and offline on Android or iOS
 * Large test suite
 * [... more](http://graphhopper.com/#overview)
