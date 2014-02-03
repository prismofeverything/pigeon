# pigeon

A collection of classification algorithms in Clojure

## Installation

Add this line to your `project.clj`

    :dependencies [[pigeon "0.0.1"]]

## Usage

Pigeon will accept a series of archetypes as java.util.Collecitons to be matched against, and then respond 
with the closest match given an unidentified input collection.

To instantiate the classifier, simply:

```clj
(def pigeon (pigeon.Classifier.))
```

To add archetypes to the classifier, provide an `id` and an `archetype` to the `.add` method:

```clj
(.add pigeon "up" [(processing.core.PVector. 1 1 1) (processing.core.PVector. 2 2 2) (processing.core.PVector. 3 3 3)])
(.add pigeon "down" [(processing.core.PVector. 3 3 3) (processing.core.PVector. 2 2 2) (processing.core.PVector. 1 1 1)])
```

Then, to match against an unidentified collection, call `.match` with it.  It will return with the id of the closest archetype: 

```clj
(.match pigeon [(processing.core.PVector. 1 1 0) (processing.core.PVector. 1 2 1) (processing.core.PVector. 3 2 1)])
---> "up"
```

## License

Copyright © 2014 Ryan Spangler

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
