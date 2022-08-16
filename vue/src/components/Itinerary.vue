<template>
  
    <div class="card">
       <button @click="deleteItinerary()">Delete this trip</button>
      <h2>{{ itinerary.itinerary_name }}</h2>
      
      <div v-for="landmark in landmarks" v-bind:key="landmark.landmark_id">
        <h3>{{ landmark.landmark_name }}</h3>
        <button @click="removeLandmark(landmark.landmark_id)">X</button>
      </div>
      

     
      <div class="mapcard">
        <itinerary-map v-bind:itinerary="this.itinerary" />
      </div>
    </div>

</template>

<script>
import ItineraryService from "../services/ItineraryService";

import LandmarkService from "../services/LandmarkService";
import ItineraryMap from "./ItineraryMap.vue";

export default {
  components: { ItineraryMap },
  props: {
    itinerary: Object,
  },
  data() {
    return {
      landmarks: [],
    };
  },

  mounted() {
    LandmarkService.getByItinerary(this.itinerary.itinerary_id).then(
      (response) => {
        this.landmarks = response.data;
      }
    );
  },
  methods: {
    removeLandmark(landmark_id) {
      ItineraryService.removeLandmark(this.itinerary.itinerary_id, landmark_id);
      location.reload();
    },
    deleteItinerary() {
      ItineraryService.deleteItinerary(this.itinerary.itinerary_id);
      location.reload();
    },
  },
};
</script>

<style scoped>
.card {
 
  background-color: rgba(73, 41, 41, 0.7);
  border-radius: 18px;
  box-shadow: 2px 4px 12px rgb(0 0 0 / 8%);
  padding: 1em;

  width: 100%;
  position: relative;
  
}
button {
  float: right;
 
  
}
h3{
  float: left;
  
}

/* .card:hover {
  transform: rotate(3deg);
  cursor: pointer;
  transition-duration: 0.5s;
} */
</style>