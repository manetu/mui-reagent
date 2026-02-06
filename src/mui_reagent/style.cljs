(ns mui-reagent.style
  (:require [goog.object :as gobj]
            [mui-reagent.utils :refer [adapt]]
            ["@mui/styles" :refer [makeStyles]]
            ["@mui/material/styles" :refer [colors withStyles createTheme] :as lib]))

(def mui-colors (js->clj colors))

(def theme-provider (adapt (.-ThemeProvider lib)))

(def keyword-or-string? #(or (string? %) (keyword? %)))

(defn color-for
  "Get the color from Material color db.
   Accept:
   color as keyword / string
   level as integer

   Return `#000000` if color not found"
  [color_ level_]
  (if (keyword-or-string? color_)
    (if (int? level_)
      (get-in mui-colors [(name color_) (str level_)] "#000000")
      (throw (js/Error. "`level_` must be integer.")))
    (throw (js/Error. "`color_` must be string or keyword."))))

(defn create-mui-theme
  "Create MUI theme from a clojure map."
  [raw-theme]
  (if (map? raw-theme)
    (-> raw-theme clj->js createTheme)
    (throw (js/Error. "`raw-theme` must be valid clojure map."))))

(defn class-name
  "Function helper to get class-name from component.
   Accept react component and className as string or keyword. "
  [component id]
  (if (keyword-or-string? id)
    (gobj/getValueByKeys component "props" "classes" (clj->js id))
    (throw (js/Error. "`id` must be string or keyword."))))

(def theme (create-mui-theme {}))

(defn with-style
  "Return mui withStyle fn. Accept clojure map as argument."
  [m]
  (if (map? m)
    (withStyles (clj->js m))
    (throw (js/Error. "`m` must be valid clojure map."))))

(defn- wrap-styles [styles]
  (if (fn? styles)
    (fn [theme]
      (-> (js->clj theme :keywordize-keys true)
          (styles)
          (clj->js)))
    (clj->js styles)))

(defn make-styles
  "Returns mui useStyle hook which accepts one argument: the props that will be
   used for interpolation in the style sheet."
  ([styles]
   (make-styles styles {}))
  ([styles opts]
   (makeStyles (wrap-styles styles) (clj->js opts))))
