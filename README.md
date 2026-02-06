[![Clojars Project](https://img.shields.io/clojars/v/io.github.manetu/mui-reagent.svg)](https://clojars.org/io.github.manetu/mui-reagent)
# mui-reagent

Reagent component wrappers for [Material UI (MUI)](https://mui.com/) v7.

## Installation

Add to your `project.clj` dependencies:

```clojure
[io.github.manetu/mui-reagent "VERSION"]
```

Add the Roboto font to your HTML:

```html
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
```

## Usage

Require the namespaces you need:

```clojure
(ns my-app.core
  (:require [mui-reagent.core :as mui]
            [mui-reagent.style :as mui.style]
            [mui-reagent.lab :as mui.lab]))
```

Use MUI components as Reagent components:

```clojure
(defn my-app []
  [:div
   [mui/css-baseline]
   [mui/theme-provider {:theme (mui.style/create-mui-theme {:palette {:primary {:main "#1976d2"}}})}
    [mui/container {:maxWidth "sm"}
     [mui/button {:variant "contained" :color "primary"} "Click me"]]]])
```

## Available Namespaces

| Namespace | Description |
|---|---|
| `mui-reagent.core` | All `@mui/material` components (132 components) |
| `mui-reagent.style` | Theme creation, styling utilities (`create-mui-theme`, `theme-provider`, `make-styles`, etc.) |
| `mui-reagent.lab` | `@mui/lab` components (`loading-button`, `masonry`, `timeline-*`, `tree-*`, `tab-context`, etc.) |
| `mui-reagent.utils` | Internal utilities for adapting React components to Reagent |

## Icons

This library does not wrap MUI icons. Import them directly via ClojureScript JS interop:

```clojure
(ns my-app.core
  (:require ["@mui/icons-material/Add" :default AddIcon]
            [reagent.core :as r]))

(def add-icon (r/adapt-react-class AddIcon))

;; Then use in your components:
[add-icon {:color "primary"}]
```

You'll need to add `@mui/icons-material` to your `deps.cljs`:

```clojure
{:npm-deps {"@mui/icons-material" "7.0.0"}}
```

## Examples

See the [examples](examples/) directory for fully functional demonstrations.

## License

Copyright Manetu Inc.

Distributed under the Eclipse Public License v1.0.
