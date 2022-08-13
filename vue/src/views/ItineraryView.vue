<template>
<list-of-itinerary>
  <the-map />
</template>

<script>
import ItineraryService from '../services/ItineraryService'
import TheMap from "../components/map.vue";
import ListOfItinerary from '../components/ListOfItinerary.vue'

export default {
    name: "Itinerary-view",
    data(){
        return {
            itinerary: "",
            landmark: ""
        }
    },
    components: {
    TheMap,
        ListOfItinerary
  },
  created() {
    ItineraryService.search().then((response) => {
      this.itinerary = response.data;
    });

}
}
</script>

<style>

</style>