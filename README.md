# GraphHopper Routing Engine for The University of Windsor

My purpose with this project was to implement a **smart navigation** component within a larger **Smart Campus** web-application to help new students adapt and feel safer on campus. As a user, you can choose from 3 routing options:
* Fastest: that is, the shortest route.
* Indoors: paths that go through buildings are preferred, and a penalty cost is associated with outdoor edges.
  * Useful if you don't like Canadian winters or forgot to bring an umbrella on a rainy day.
* Safest: prefers paths that are well-lit for students walking through campus at night.

**Note:** I've only defined indoor and well-lit paths for the University of Windsor campus, see **TODO: DOCUMENTATION** to learn how to integrate your own route data.


## Basic Usage Demo
![Smart Routing Demo](http://charlopov.com/img/portfolio/sc/sc1.png)


## Useful Documentation
--------------

* Forking & Deploying
* Modifying weighting / adding additional weightings
* Additional customization