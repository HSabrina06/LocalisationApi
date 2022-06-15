# LocalisationApi
 REST API that handles locations

Create a Location

create a new location by providing a name, a type with possible values premium or standard and coordinates using lat and lng. The system has to assign the location an id and return it back within the response.

example values to create a location:

name:  Fancy Place
lat:  48.2
lng:  15.6
type:  premium


Search for a Location

search for locations based on type or by defining a rectangular area with two points p1, p2 (lat,lng) and returning all locations within it. It is also possible to use both criteria together and the result set might be limited by limit. Results must be ordered by type where premium ones come first.

example to search for a location:

p1: 46.6, 15.4
p2: 48.8, 17.5
type: premium
limit: 3
