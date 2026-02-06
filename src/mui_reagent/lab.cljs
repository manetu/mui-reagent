(ns mui-reagent.lab
  (:require [mui-reagent.utils :refer [adapt]]
            ["@mui/lab" :as lib]))

;; Note: Date/time picker components have been moved to @mui/x-date-pickers
;; Use that package directly for DatePicker, TimePicker, DateTimePicker, etc.

;; Lab components still available in MUI v7
(def loading-button (adapt (.-LoadingButton lib)))
(def localization-provider (adapt (.-LocalizationProvider lib)))
(def masonry (adapt (.-Masonry lib)))
(def tab-context (adapt (.-TabContext lib)))
(def tab-list (adapt (.-TabList lib)))
(def tab-panel (adapt (.-TabPanel lib)))
(def timeline (adapt (.-Timeline lib)))
(def timeline-connector (adapt (.-TimelineConnector lib)))
(def timeline-content (adapt (.-TimelineContent lib)))
(def timeline-dot (adapt (.-TimelineDot lib)))
(def timeline-item (adapt (.-TimelineItem lib)))
(def timeline-opposite-content (adapt (.-TimelineOppositeContent lib)))
(def timeline-separator (adapt (.-TimelineSeparator lib)))
(def tree-item (adapt (.-TreeItem lib)))
(def tree-view (adapt (.-TreeView lib)))
