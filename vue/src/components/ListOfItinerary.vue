<template>
  <div>
<the-map />
  </div>
</template>

<script>
import LandmarkService from "../services/LandmarkService";
import ItineraryService from "../services/ItineraryService";
import TheMap from "../components/map.vue";

export default {
name: "itinerary-list",
data(){
    return {
        itinerary: "",
        landmark: ""
    };
},
components: {
    TheMap,
},
created(){
    //service get list
}
}
</script>

<style>

</style>