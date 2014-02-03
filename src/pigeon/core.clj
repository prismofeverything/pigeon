(ns pigeon.core)

(defn add-archetype
  [repository id archetype]
  (assoc repository id archetype))

(defn diff-archetype
  [archetype unidentified]
  (reduce
   (fn [sum [a u]]
     (+ sum (.dist a u)))
   0 (map vector archetype unidentified)))

(defn match-archetype
  [repository unidentified]
  (let [affinities (reduce
                    (fn [matches [id archetype]]
                      (assoc matches id (diff-archetype archetype unidentified)))
                    {} repository)
        affinities (sort-by last affinities)]
    (first (first affinities))))
